package nodes;

public class Node<T> {
	
	protected T data;
	protected Node<T> next;

	public Node(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public void eliminate() {
		data = null;
		next = null;
	};
}
