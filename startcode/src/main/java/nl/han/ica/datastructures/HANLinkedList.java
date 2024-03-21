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
        this.header.setNextNode(null);
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
       HANLinkedListItem<T> beforeDelete = (HANLinkedListItem<T>) get(pos - 1);
       HANLinkedListItem<T> afterDelete = (HANLinkedListItem<T>) get(pos + 1);


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

            return (T) iterator.retrieveCurrent();

    }


    public T getValue(int pos) {
        HANLinkedListIterator<T> iterator = new HANLinkedListIterator<T>(header);
        int walkpos = pos;

           while(walkpos > 0) {
               iterator.advance();
               walkpos--;
           }

            return (T) iterator.retrieveCurrent().getValue();
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
