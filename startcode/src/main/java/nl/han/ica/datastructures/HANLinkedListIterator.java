package nl.han.ica.datastructures;

public class HANLinkedListIterator<T> {
    private HANLinkedListItem<T> current;

    public HANLinkedListIterator(HANLinkedListItem<T> current){
        this.current = current;
    }

    public boolean isValid(){
        return current != null;
    }

    public HANLinkedListItem<T> retrieveCurrent(){
    if(isValid()){
        return getCurrent();
    }
    else{
        return null;
        }
    }

    public void advance(){
        if(isValid()){
            current = current.getNextNode();
        }
    }

    public HANLinkedListItem<T> getCurrent(){
        return current;
    }
}


