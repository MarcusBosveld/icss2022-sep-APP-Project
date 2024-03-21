package nl.han.ica.datastructures;

public class HANStack<T> implements IHANStack {

    private HANLinkedListItem<T> topOfStack;


    @Override
    public void push(Object value) {

        if (topOfStack == null) {
            topOfStack = new HANLinkedListItem<T>((T) value);;
        }
        else {
            HANLinkedListItem<T> oldTopOfStack = topOfStack;
            HANLinkedListItem<T> newTopOfStack = new HANLinkedListItem<T>((T) value);
            newTopOfStack.setNextNode(oldTopOfStack);
            topOfStack = newTopOfStack;
        }

    }

    @Override
    public Object pop() {
        HANLinkedListItem<T> oldTopOfStack = topOfStack;
        HANLinkedListItem<T> newTopOfStack = topOfStack.getNextNode();

        topOfStack = newTopOfStack;
        return oldTopOfStack;
    }

    @Override
    public Object peek() {
        return topOfStack;
    }
}
