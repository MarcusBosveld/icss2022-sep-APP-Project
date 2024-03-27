package nl.han.ica.icss.transforms;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;
import java.util.LinkedList;

public class Evaluator implements Transform {

    private IHANLinkedList<HashMap<String, Literal>> variableValues;

    public Evaluator() {
        variableValues = new HANLinkedList<>();

    }

    @Override
    public void apply(AST ast) {


        //variableValues = new HANLinkedList<>();
        evaluate(ast.root);
    }

    public void evaluate(ASTNode node){
        if(node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause){
            variableValues.addFirst(new HashMap<String,Literal>());
        }
        replaceOperation(node);
        for(ASTNode child: node.getChildren()){
            if(!node.getChildren().isEmpty()){
            evaluate(child);
            }
        }

    }


    public void replaceOperation(ASTNode node){
        if (node instanceof Declaration){
        if(((Declaration) node).expression instanceof Operation){
          Expression value = evaluateOperations(((Declaration) node).expression);

            ((Declaration) node).expression = value;
            }
        }
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

            }
        }
        return null;
    }

    
}
