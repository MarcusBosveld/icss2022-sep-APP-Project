package nl.han.ica.datastructures;

public class HANLinkedListItem <T> {
    private T value;
    private HANLinkedListItem<T> nodeAfter;



    public HANLinkedListItem<T> getNextNode(){
        return nodeAfter;
    }

    public void setNextNode(HANLinkedListItem<T> nodeAfter){
        this.nodeAfter = nodeAfter;
    }
}
