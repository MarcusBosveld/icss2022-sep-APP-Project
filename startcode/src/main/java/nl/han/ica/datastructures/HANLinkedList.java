package nl.han.ica.datastructures;

public class HANLinkedList<T> implements IHANLinkedList<T> {
    private HANLinkedListItem<T> header;
    
    public HANLinkedList(){
        this.header = new HANLinkedListItem<T>();
    }
    @Override
    public void addFirst(T value) {
    //TODO: Vragen of de interface veranderd mag worden voor datatype
        HANLinkedListItem<T> oldHeader = this.header;
        this.header = (HANLinkedListItem<T>) value;
        this.header.setNextNode(oldHeader);
    }

    @Override
    public void clear() {
        this.header.setNextNode(null);
        this.header = null;
    }

    @Override
    public void insert(int index, T value) {
    }

    @Override
    public void delete(int pos) {

        HANLinkedListItem<T> beforeDelete = (HANLinkedListItem<T>) get(pos-1);
        HANLinkedListItem<T> afterDelete = (HANLinkedListItem<T>) get(pos + 1);

        if(pos == 0){
            removeFirst();
        }
        else{
            beforeDelete.setNextNode(afterDelete);
        }
    }


    @Override
    public T get(int pos) {
        HANLinkedListIterator<T> iterator = new HANLinkedListIterator<T>(header);
        int walkpos = pos;

        if(walkpos > 0){
            iterator.advance();
            walkpos--;
            return get(walkpos);
        }
        else{
            return (T) iterator.retrieveCurrent();
        }
    }

    @Override
    public void removeFirst() {
        HANLinkedListItem<T> newHeader = (HANLinkedListItem<T>) get(1);
        this.header = newHeader;
    }

    @Override
    public T getFirst() {
        return (T) header;
    }

    @Override
    public int getSize() {
        HANLinkedListIterator<T> iterator = new HANLinkedListIterator<T>(header);
        int size = 0;
        while(iterator.isValid()){
            size++;
            iterator.advance();
        }
        return size;
    }
}
