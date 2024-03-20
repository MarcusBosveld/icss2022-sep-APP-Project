package nl.han.ica.datastructures;

public class HANLinkedListItem <T> {
    private T value;
    private HANLinkedListItem<T> nodeAfter;

    public HANLinkedListItem(){
        this.nodeAfter = nodeAfter;
    }

    public HANLinkedListItem<T> getNextNode(){
        return nodeAfter;
    }
}
