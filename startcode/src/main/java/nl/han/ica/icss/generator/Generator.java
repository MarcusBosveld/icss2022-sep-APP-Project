package nl.han.ica.icss.generator;


import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;

public class Generator {
	private boolean inStylerule = false;

	public String generate(AST ast) {
		StringBuilder sb = new StringBuilder();
        return generateString(ast.root, sb).toString();

	}

	public StringBuilder generateString(ASTNode node, StringBuilder sb){

		makeStyleRule(node, sb);
		makeDeclaration(node, sb);

		for(ASTNode child: node.getChildren()){
			if(!node.getChildren().isEmpty()){
				generateString(child, sb);
			}

		}
		if (node instanceof Stylerule){
			inStylerule = false;
		}
		endStyleRule(node, sb);
		return sb;
	}


	public void makeStyleRule(ASTNode node, StringBuilder sb) {
		if (node instanceof Stylerule) {
			sb.append(((Stylerule) node).selectors.get(0).toString() + " {\n");
			inStylerule = true;
		}
	}
	public void makeDeclaration(ASTNode node, StringBuilder sb){
		if(node instanceof Declaration){
			if(((Declaration)node).expression instanceof ColorLiteral){
				sb.append("    " + ((Declaration)node).property.name + ": " + ((ColorLiteral)((Declaration)node).expression).value + ";\n");
			}else if (((Declaration)node).expression instanceof PixelLiteral){
				sb.append("    " + ((Declaration)node).property.name + ": " + ((PixelLiteral)((Declaration)node).expression).value + "px;\n");
			}else if (((Declaration)node).expression instanceof PercentageLiteral){
				sb.append("    " + ((Declaration)node).property.name + ": " + ((PercentageLiteral)((Declaration)node).expression).value + "%;\n");
			}
		}
	}
	public void endStyleRule(ASTNode node, StringBuilder sb){
		if(!inStylerule && node instanceof Stylerule){
			sb.append("}\n");
		}
	}
}
