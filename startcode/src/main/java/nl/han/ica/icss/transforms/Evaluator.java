package nl.han.ica.icss.transforms;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.BoolLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Evaluator implements Transform {

    private IHANLinkedList<HashMap<String, Literal>> variableValues;

    public Evaluator() {
        variableValues = new HANLinkedList<>();

    }

    @Override
    public void apply(AST ast) {


        variableValues = new HANLinkedList<>();
        evaluate(ast.root);
    }

    public void evaluate(ASTNode node){
        if(node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause){
            variableValues.addFirst(new HashMap<String,Literal>());
        }

        setVariableValues(node);
        replaceVariableReference(node);
        replaceOperation(node);
        transformIfAndElseClause(node);
        for(ASTNode child: node.getChildren()){
            if(!node.getChildren().isEmpty()){
            evaluate(child);
            }
        }
        if (node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause){
            variableValues.removeFirst();
        }

    }


    public void replaceOperation(ASTNode node){
        if (node instanceof Declaration){
        if(((Declaration) node).expression instanceof Operation){
          Expression value = evaluateOperations(((Declaration) node).expression);

            (((Declaration) node).expression) = value;
            }
        }
    }

    public void replaceVariableReference(ASTNode node){
        if(node instanceof Declaration){
            if(((Declaration) node).expression instanceof VariableReference){
                Literal value = getVariableValues(((Declaration) node).expression);
                ((Declaration) node).expression = value;
            }
        }
    }

    public void setVariableValues(ASTNode node){
        if(node instanceof VariableAssignment){
            String valueName = ((VariableAssignment) node).name.name;
            Literal value = (Literal) ((VariableAssignment) node).expression;
            variableValues.getFirst().put(valueName,value);
        }
    }

    public Literal getVariableValues(ASTNode node){
        Literal variableValue = null;
        if(node instanceof VariableReference){
            String variableName = ((VariableReference) node).name;
            for(int i = 0; i < variableValues.getSize(); i++){
                if(variableValues.get(i).containsKey(variableName)){
                    variableValue = variableValues.get(i).get(variableName);
                }
            }
        }
        return variableValue;
    }

    public Expression evaluateOperations(ASTNode node) {
        if (node instanceof Operation) {
            ASTNode leftSum = ((Operation) node).lhs;
            ASTNode rightSum = ((Operation) node).rhs;

            if (leftSum instanceof Operation) {
                leftSum = evaluateOperations(leftSum);
            }
            if (rightSum instanceof Operation) {
                rightSum = evaluateOperations(rightSum);
            }

            if (leftSum instanceof VariableReference) {
                leftSum = getVariableValues(leftSum);
            }
            if (rightSum instanceof VariableReference) {
                rightSum = getVariableValues(rightSum);
            }


            if (node instanceof AddOperation) {
                if (leftSum instanceof PixelLiteral && rightSum instanceof PixelLiteral) {
                    Expression result = new PixelLiteral(((PixelLiteral) leftSum).value + ((PixelLiteral) rightSum).value);

                    return result;
                } else if (leftSum instanceof PercentageLiteral && rightSum instanceof PercentageLiteral) {
                    Expression result = new PercentageLiteral(((PercentageLiteral) leftSum).value + ((PercentageLiteral) rightSum).value);
                    return result;
                }

            } else if (node instanceof SubtractOperation) {
                {
                    if (leftSum instanceof PixelLiteral && rightSum instanceof PixelLiteral) {
                        Expression result = new PixelLiteral(((PixelLiteral) leftSum).value - ((PixelLiteral) rightSum).value);
                        return result;
                    } else if (leftSum instanceof PercentageLiteral && rightSum instanceof PercentageLiteral) {
                        Expression result = new PercentageLiteral(((PercentageLiteral) leftSum).value - ((PercentageLiteral) rightSum).value);
                        return result;
                    }

                }

            }else if (node instanceof MultiplyOperation) {
                {
                    if (leftSum instanceof PixelLiteral && rightSum instanceof ScalarLiteral) {
                        Expression result = new PixelLiteral(((PixelLiteral) leftSum).value * ((ScalarLiteral) rightSum).value);
                        return result;
                    } else if (leftSum instanceof PercentageLiteral && rightSum instanceof ScalarLiteral) {
                        Expression result = new PercentageLiteral(((PercentageLiteral) leftSum).value * ((ScalarLiteral) rightSum).value);
                        return result;
                    }
                    else if (leftSum instanceof ScalarLiteral && rightSum instanceof PixelLiteral) {
                        Expression result = new PixelLiteral(((ScalarLiteral) leftSum).value * ((PixelLiteral) rightSum).value);
                        return result;
                    }
                    else if (leftSum instanceof ScalarLiteral && rightSum instanceof PercentageLiteral) {
                        Expression result = new PercentageLiteral(((ScalarLiteral) leftSum).value * ((PercentageLiteral) rightSum).value);
                        return result;
                    }
                }

            }
        }
        return null;
    }

    public void transformIfAndElseClause(ASTNode node) {
        ArrayList<Declaration> body = new ArrayList<>();
        ASTNode clauseToDelete = null;
        if (node instanceof Stylerule) {
            for (ASTNode child : node.getChildren()) {
                if (child instanceof IfClause) {
                    body.addAll(evaluateIfAndElseClause(child));
                    clauseToDelete = child;
                }
                ((Stylerule) node).body.remove(clauseToDelete);
                for (Declaration declaration : body) {
                    node.addChild(declaration);
                }
            }
        }
    }

    public ArrayList<Declaration> evaluateIfAndElseClause(ASTNode node){
        ArrayList<Declaration> body = new ArrayList<>();
        ArrayList<Declaration> elseBody = new ArrayList<>();
        if(((IfClause)node).conditionalExpression instanceof VariableReference){
            ((IfClause)node).conditionalExpression = getVariableValues(((IfClause)node).conditionalExpression);
        }
        for(ASTNode child: node.getChildren()){
            if(child instanceof IfClause){
                body.addAll(evaluateIfAndElseClause(child));
            }if (child instanceof Declaration){
                body.add((Declaration) child);
            }
            else if (child instanceof ElseClause){
                for(ASTNode elseChild: child.getChildren()){
                    if(elseChild instanceof IfClause){
                        elseBody.addAll(evaluateIfAndElseClause(elseChild));
                    }else if (elseChild instanceof Declaration){
                        elseBody.add((Declaration) elseChild);
                    }
                }
            }
        } if(((BoolLiteral) ((IfClause) node).conditionalExpression).value){
                return body;
        }else{
            return elseBody;
        }

    }

    
}
