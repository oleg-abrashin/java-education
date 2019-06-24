package model;

public class NodeBD<T> extends NodeUD<T> {

    private T data;
    private NodeBD<T> next = null;
    private NodeBD<T> prev = null;

    public NodeBD(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeBD<T> getNext() {
        return next;
    }

    public void setNext(NodeBD<T> next) {
        this.next = next;
    }

    public NodeBD<T> getPrev() {
        return prev;
    }

    public void setPrev(NodeBD<T> prev) {
        this.prev = prev;
    }
}
