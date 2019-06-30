package model;

import java.util.Iterator;

public class IterativeIterator<T> implements Iterator<T> {

    MyTreeSet<T> treeSet;

    Node<T> current;

    public IterativeIterator(MyTreeSet<T> ts) {
        this.treeSet = ts;
        if (treeSet.getRoot() != null) current = treeSet.getRoot().getLeftMost();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T res = current.getData();
        if (current.getRight() != null) {
            current = current.getRight().getLeftMost();
        } else {
            while (!current.isLeftChild()) {
                if (current.isRoot()) {
                    break;
                } else {
                    current = current.getParent();
                }
            }
            current = current.getParent();
        }
        return res;
    }
}
