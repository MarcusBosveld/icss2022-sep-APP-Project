package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.ast.ASTNode;
import nl.han.ica.icss.ast.Declaration;
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
            System.out.println(propertyName);


        }




    }

    
}
