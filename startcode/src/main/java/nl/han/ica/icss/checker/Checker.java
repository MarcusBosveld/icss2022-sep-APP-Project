package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.ast.ASTNode;
import nl.han.ica.icss.ast.Declaration;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;



public class Checker {

    private IHANLinkedList<HashMap<String, ExpressionType>> variableTypes;

    public void check(AST ast) {
        variableTypes = new HANLinkedList<>();
        checkSemantics(ast.root);

    }


    public void checkSemantics(ASTNode node){
        for(ASTNode child: node.getChildren()){
            checkDeclaration(child);
            if(!node.getChildren().isEmpty()){
                checkSemantics(child);
            }
        }




    }


    public void checkDeclaration(ASTNode declaration) {
        if(declaration instanceof Declaration){
            String propertyName = declaration.getChildren().get(0).getNodeLabel();
            ExpressionType expressionType = getExpressionType(((Declaration) declaration).expression);


            if(expressionType == ExpressionType.UNDEFINED){
                declaration.setError("Error: Undefined expression type");
            }
            switch (propertyName){
                case "Property: (background-color)":
                    if(expressionType != ExpressionType.COLOR){
                        declaration.setError("Gast dit is toch geen kleur");
                    }
                    break;
                case "Property: (color)":
                    if(expressionType != ExpressionType.COLOR){
                        declaration.setError("Gast dit is toch geen kleur");
                    }
                    break;
                case "Property: (width)":
                    if(expressionType != ExpressionType.PIXEL && expressionType != ExpressionType.PERCENTAGE){
                        declaration.setError("Gast dit is toch geen breedte");
                    }
                    break;
                case "Property: (height)":
                    if(expressionType != ExpressionType.PIXEL && expressionType != ExpressionType.PERCENTAGE){
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
        }
        else {
            return ExpressionType.UNDEFINED;
        }
    }

    
}
