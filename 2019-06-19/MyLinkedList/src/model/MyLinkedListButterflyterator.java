package model;

import java.util.Iterator;

public class MyLinkedListButterflyterator<T> implements Iterator<T> {

    NodeBD<T> current;

    public MyLinkedListButterflyterator(NodeBD<T> head) {
        super();
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    boolean rotate = false;

    @Override
    public T next() {
        T result = current.getData();

        if (this.rotate) {
            current = current.getPrev().getPrev();
        }

        if (!this.rotate && current.getNext().getNext() != null) {
            current = current.getNext().getNext();
        } else if (!this.rotate && current.getNext() != null) {
            current = current.getNext();
            this.rotate = true;
        }
        return result;
    }
}
