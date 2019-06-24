package model;

public abstract class AbstractMyLinkedList<T> implements MyList<T> {

    NodeUD<T> head = null;
    NodeUD<T> tail = null;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getFirst() {
        return head == null ? null : head.getData();
    }

    @Override
    public T getLast() {
        return tail == null ? null : tail.getData();
    }

    @Override
    public void eliminateAll() {
        head = null;
        tail = null;
        size = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        if (size > 0) {
            NodeUD<T> result = head;
            sb.append(head.getData().toString());
            while (result.getNext() != null) {
                result = result.getNext();
                sb.append("  " + result.getData().toString());
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
