package model;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyTreeSetRecursiveIterator<T> implements Iterator<T> {

    private Node<T> head;
    private MyTreeSetRecursiveIterator<T> leftIterator=null;
    private MyTreeSetRecursiveIterator<T> rightIterator=null;

    private boolean liHasNext = true;
    private boolean headNotReturned = true;
    private boolean riHasNext = true;

    public MyTreeSetRecursiveIterator(Node<T> head) {
        super();
        this.head = head;
        if (head != null){
            leftIterator = new MyTreeSetRecursiveIterator<>(head.getLeft());
            rightIterator = new MyTreeSetRecursiveIterator<>(head.getRight());
        }
    }

    @Override
    public boolean hasNext() {
        if (head == null) return false;
        liHasNext = leftIterator.hasNext();
        riHasNext = rightIterator.hasNext();
        return liHasNext || headNotReturned || riHasNext;
    }

    @Override
    public T next() {
        if (!hasNext())throw new NoSuchElementException();

        if (liHasNext) return leftIterator.next();
        if (headNotReturned) {
            headNotReturned = false;
            return head.getData();
        }
        if (riHasNext) return rightIterator.next();

        return null;
    }
}