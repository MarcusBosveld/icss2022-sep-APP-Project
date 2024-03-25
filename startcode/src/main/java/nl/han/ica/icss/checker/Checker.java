package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;



public class Checker {

    private IHANLinkedList<HashMap<String, ExpressionType>> variableTypes;
    private boolean isVariableAssignment;

    public void check(AST ast) {
        variableTypes = new HANLinkedList<>();
        isVariableAssignment = false;
        checkSemantics(ast.root);

    }


    public void checkSemantics(ASTNode node){
        if(node instanceof VariableAssignment){
            isVariableAssignment = true;
        }
        if(node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause){
            variableTypes.addFirst(new HashMap<String,ExpressionType>());
        }
        checkDeclaration(node);
        checkVariableAssignment(node);
        checkOperationsSameLiterals(node);
        for(ASTNode child: node.getChildren()){
            if(!node.getChildren().isEmpty()){
                checkSemantics(child);
            }
        }


        if(node instanceof VariableAssignment){
            isVariableAssignment = false;
        }
        if (node instanceof Stylesheet | node instanceof Stylerule | node instanceof IfClause){
            variableTypes.removeFirst();
        }
    }

    public void checkDeclaration(ASTNode declaration) {
        if(declaration instanceof Declaration){
            String propertyName = declaration.getChildren().get(0).getNodeLabel();
            ExpressionType expressionType = getExpressionType(((Declaration) declaration).expression);
            boolean isVariableReference = checkForVariableReference(((Declaration) declaration).expression);
            boolean isOperation = checkForOperation(((Declaration) declaration).expression);


            if(expressionType == ExpressionType.UNDEFINED && !isVariableReference && !isOperation){
                declaration.setError("Error: Undefined expression type");
            }
            switch (propertyName){
                case "Property: (background-color)":
                    if(expressionType != ExpressionType.COLOR && !isVariableReference && !isOperation){
                        declaration.setError("Gast dit is toch geen kleur");
                    }
                    break;
                case "Property: (color)":
                    if(expressionType != ExpressionType.COLOR && !isVariableReference && !isOperation){
                        declaration.setError("Gast dit is toch geen kleur");
                    }
                    break;
                case "Property: (width)":
                    if(expressionType != ExpressionType.PIXEL && expressionType != ExpressionType.PERCENTAGE && !isVariableReference && !isOperation){
                        declaration.setError("Gast dit is toch geen breedte");
                    }
                    break;
                case "Property: (height)":
                    if(expressionType != ExpressionType.PIXEL && expressionType != ExpressionType.PERCENTAGE && !isVariableReference && !isOperation){
                        declaration.setError("Gast dit is toch geen hoogte");
                    }
                    break;

                default:
                    declaration.setError("Deze property zit nog niet in deze versie. Hij is er wel wanneer GTA 7 uitkomt.");
            }

        }
    }

    public ExpressionType getExpressionType(ASTNode node){
        if(node instanceof PixelLiteral){
            return ExpressionType.PIXEL;
        }
        else if (node instanceof PercentageLiteral){
            return ExpressionType.PERCENTAGE;
        }
        else if (node instanceof ColorLiteral){
            return ExpressionType.COLOR;
        }
        else if (node instanceof ScalarLiteral){
            return ExpressionType.SCALAR;
        } else if (node instanceof BoolLiteral) {
            return ExpressionType.BOOL;

        } else {
            return ExpressionType.UNDEFINED;
        }
    }

    public boolean checkForVariableReference(ASTNode node){
        return node instanceof VariableReference;
    }

    public boolean checkForOperation(ASTNode node){
        return node instanceof Operation;
    }


    public void checkVariableAssignment(ASTNode node){
        if(node instanceof VariableAssignment) {
            if (((VariableAssignment) node).expression != null) {
                String variableName = ((VariableAssignment) node).name.name;
                ExpressionType expressionType = getExpressionType(((VariableAssignment) node).expression);
                variableTypes.getFirst().put(variableName, expressionType);
            }
        }
         if (node instanceof VariableReference & !isVariableAssignment){
            String variableName = ((VariableReference) node).name;
            if(getVariableReferenceType(variableName) == ExpressionType.UNDEFINED){
                node.setError("Gast, Hoe wil je een variabele gebruiken die nog geen waarde heeft?");
            }
        }
    }

    public void checkOperationsSameLiterals(ASTNode node){
        if(node instanceof Operation){
            ASTNode leftside = node.getChildren().get(0);
            ASTNode rightside = node.getChildren().get(1);

            if(leftside instanceof VariableReference){
                String variableName = ((VariableReference) leftside).name;
                ExpressionType expressionType = getVariableReferenceType(variableName);
                if (expressionType == ExpressionType.PIXEL){
                    leftside = new PixelLiteral(0);
                } else if (expressionType == ExpressionType.PERCENTAGE){
                    leftside = new PercentageLiteral(0);
                }
            }
            if(rightside instanceof VariableReference){
                String variableName = ((VariableReference) rightside).name;
                ExpressionType expressionType = getVariableReferenceType(variableName);
                if (expressionType == ExpressionType.PIXEL){
                    rightside = new PixelLiteral(0);
                } else if (expressionType == ExpressionType.PERCENTAGE){
                    rightside = new PercentageLiteral(0);
                }
            }

            if(node instanceof MultiplyOperation) {
                if (leftside instanceof PixelLiteral && rightside instanceof PixelLiteral) {
                    node.setError("Ewa broer, je mag alleen vermedigvuldigen met Scalaire waardes asabi");
                } else if (leftside instanceof PercentageLiteral && rightside instanceof PercentageLiteral) {
                    node.setError("Ewa broer, je mag alleen vermedigvuldigen met Scalaire waardes asabi");
                } else if (leftside instanceof PixelLiteral && rightside instanceof PercentageLiteral) {
                    node.setError("Ewa broer, je mag alleen vermedigvuldigen met Scalaire waardes asabi");
                } else if (leftside instanceof PercentageLiteral && rightside instanceof PixelLiteral) {
                    node.setError("Ewa broer, je mag alleen vermedigvuldigen met Scalaire waardes asabi");
                }
            }

            if(leftside instanceof PixelLiteral && !(rightside instanceof PixelLiteral)){
                node.setError("Ewa broer, je moet alleen rekenen met pixels bij pixels asabi");
            } else if (leftside instanceof PercentageLiteral && !(rightside instanceof PercentageLiteral)) {
                node.setError("Ewa broer, je moet alleen rekenen met percentages bij percentages asabi");
            }

        }
    }

        public ExpressionType getVariableReferenceType(String variableName){
        ExpressionType expressionType = ExpressionType.UNDEFINED;
        for(int i = 0; i < variableTypes.getSize(); i++){
            if(variableTypes.get(i).containsKey(variableName)){
                expressionType = variableTypes.get(i).get(variableName);
            }
        }
        return expressionType;
    }

    
}
