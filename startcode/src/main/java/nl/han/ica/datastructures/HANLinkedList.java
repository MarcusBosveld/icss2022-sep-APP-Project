package nl.han.ica.datastructures;

public class HANLinkedList<T> implements IHANLinkedList<T> {
    private HANLinkedListItem<T> header;

    public HANLinkedList(){
        this.header = null;
    }
    @Override
    public void addFirst(T value) {
    //TODO: Vragen of de interface veranderd mag worden voor datatype
        HANLinkedListItem<T> oldHeader = this.header;

        this.header = new HANLinkedListItem<T>(value);
        this.header.setNextNode(oldHeader);
    }

    @Override
    public void clear() {
        this.header = null;
    }

    @Override
    public void insert(int index, T value) {
    }

    @Override
    public void delete(int pos) {
       if (pos == 0) {
           removeFirst();
           return;
       }
        HANLinkedListItem<T> beforeDelete = getNode(pos - 1);
        HANLinkedListItem<T> afterDelete = getNode(pos + 1);
        beforeDelete.setNextNode(afterDelete);

    }


    @Override
    public T get(int pos) {
        HANLinkedListIterator<T> iterator = new HANLinkedListIterator<T>(header);
        int walkpos = pos;

        while(walkpos > 0) {
            iterator.advance();
            walkpos--;
        }

        return  iterator.retrieveCurrent().getValue();



    }


    public HANLinkedListItem<T> getNode(int pos) {
        HANLinkedListIterator<T> iterator = new HANLinkedListIterator<T>(header);
        int walkpos = pos;

        while(walkpos > 0) {
            iterator.advance();
            walkpos--;
        }

        return iterator.getCurrent();

    }

    @Override
    public void removeFirst() {
        HANLinkedListItem<T> newHeader = header.getNextNode();
        this.header = newHeader;
    }

    @Override
    public T getFirst() {
        return header.getValue();
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
