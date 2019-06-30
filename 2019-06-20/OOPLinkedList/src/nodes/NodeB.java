package nodes;

public class NodeB<T> extends Node<T>{
	
	private NodeB<T>prev;

	public NodeB(T data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public NodeB<T> getNext() {
		return (NodeB<T>) next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public NodeB<T> getPrev() {
		return prev;
	}

	public void setPrev(NodeB<T> prev) {
		this.prev = prev;
	}

	@Override
	public void eliminate() {
		data = null;
		next = null;
		prev = null;
	}

}
