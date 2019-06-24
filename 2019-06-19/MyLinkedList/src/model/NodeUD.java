package model;

public class NodeUD<T> {
    private T data;
    private NodeUD<T> next;

    public NodeUD(T data) {
        this.data = data;
    }

    public NodeUD() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeUD<T> getNext() {
        return next;
    }

    public void setNext(NodeUD<T> next) {
        this.next = next;
    }
}
