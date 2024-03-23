package nl.han.ica.datastructures;

import nl.han.ica.icss.ast.ASTNode;

public class HANStack<T> implements IHANStack<ASTNode> {

    private HANLinkedListItem<ASTNode> topOfStack;


    @Override
    public void push(ASTNode value) {
        HANLinkedListItem<ASTNode> newTopOfStack = new HANLinkedListItem<ASTNode>(value);
        newTopOfStack.setNextNode(topOfStack);

        topOfStack = newTopOfStack;

    }

    @Override
    public ASTNode pop() {
        HANLinkedListItem<ASTNode> oldTopOfStack = topOfStack;
        HANLinkedListItem<ASTNode> newTopOfStack = topOfStack.getNextNode();

        topOfStack = newTopOfStack;
        return oldTopOfStack.getValue();
    }

    @Override
    public ASTNode peek() {
        return topOfStack.getValue();
    }
}
