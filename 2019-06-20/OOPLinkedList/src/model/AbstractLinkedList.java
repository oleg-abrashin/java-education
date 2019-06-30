package model;

import nodes.Node;

public abstract class AbstractLinkedList<T> implements MyList<T> {
	
	Node<T> head;
	Node<T> tail;
	int size;
	
	protected Node<T> getNodeByIndex(int index){
		Node<T> current = head;
		int counter = 0;
		while(counter < index) {
			current = current.getNext();
			counter++;
		}
		return current;
	}

	@Override
	public int indexOf(T data) {
		int counter = 0;
		Node<T> node = head;
		while(node != null) {
			if (node.getData().equals(data)) return counter;
			node = node.getNext();
			counter++;
		}
		
		return -1;
	}

	@Override
	public boolean contains(T data) {
		return indexOf(data) >= 0;
	}

	@Override
	public T get(int index) {
		return (index < 0 || index >= size) ? null : getNodeByIndex(index).getData();	
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
	public boolean set(int index, T data) {
		if (index < 0 || index >= size)return false;
		getNodeByIndex(index).setData(data);
		return true;
	}

	@Override
	public void eliminateAll() {
		
		if (head == null) return;
		
		Node<T> current = head;
		Node<T> next;
		while(current != null) {
			next = current.getNext();
			current.eliminate();
			current = next;
		}
		head = null;
		tail = null;
		size = 0;	
	}

	@Override
	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> node = head;
		while(node != null) {
			sb.append(node.getData() + "  ");
			node = node.getNext();
		}
		
		return "["+sb.toString().trim()+"]";
	}
	
	public abstract void add(T data);
	public abstract void addFirst(T data);
	public void addLast(T data) {add(data);}
	public abstract boolean addByIndex(int index, T data);

	public abstract T removeFirst();
	public abstract T removeLast();
	public abstract T remove(int index);
	public abstract boolean remove(T data);

}
