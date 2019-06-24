package model;

import java.util.Iterator;

public class MyLinkedListBackIterator<T> implements Iterator<T> {

    NodeBD<T> current;

    public MyLinkedListBackIterator(NodeBD<T> tail) {
        super();
        this.current = tail;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T result = current.getData();
        current = current.getPrev().getPrev();
        return result;
    }
}
