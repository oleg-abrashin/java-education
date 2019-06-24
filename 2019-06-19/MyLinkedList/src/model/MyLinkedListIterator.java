package model;

import java.util.Iterator;

public class MyLinkedListIterator<T> implements Iterator<T> {

    NodeBD<T> current;

    public MyLinkedListIterator(NodeBD<T> head) {
        super();
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T result = current.getData();
        current = current.getNext();
        return result;
    }
}
