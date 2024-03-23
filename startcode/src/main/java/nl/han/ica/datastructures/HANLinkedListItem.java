package nl.han.ica.datastructures;

public class HANLinkedListItem <T> {

    private T value;
    private HANLinkedListItem<T> nodeAfter;

    public HANLinkedListItem(T value){
        this.value = value;
        this.nodeAfter = null;
    }

    public T getValue() {
        return value;
    }

    public HANLinkedListItem<T> getNextNode(){
        return nodeAfter;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public void setNextNode(HANLinkedListItem<T> nodeAfter){
        this.nodeAfter = nodeAfter;
    }
}
