package nl.han.ica.datastructures;

public class HANLinkedList<T> implements IHANLinkedList<T> {
    private T header;
    private HANLinkedListIterator<T> iterator;

    @Override
    public void addFirst(T value) {

        this.header = value;
    }

    @Override
    public void clear() {

    }

    @Override
    public void insert(int index, T value) {

    }

    @Override
    public void delete(int pos) {

    }

    @Override
    public T get(int pos) {
        return null;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
