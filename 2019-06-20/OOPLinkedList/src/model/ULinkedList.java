package model;

import nodes.Node;

public class ULinkedList<T> extends AbstractLinkedList<T>{

	@Override
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		
		if (head == null) head = node;
		else ((Node<T>)tail).setNext(node);
		
		tail = node;
		size++;		
	}
	
	@Override
	public void addFirst(T data) {
		
		Node<T> node = new Node<T>(data);
		if(head == null) tail = node;
		else node.setNext(head);
		head = node;
		size++;
	}

	@Override
	public boolean addByIndex(int index, T data) {
		if (index < 0 || index > size) return false;
		if (index == 0) addFirst(data);
		else if (index == size)add(data);
		else {
			Node<T> node = new Node<T>(data);
			Node<T> prev = getNodeByIndex(index - 1);
			
			node.setNext(prev.getNext());
			prev.setNext(node);
			
			size++;
		}
		return true;
	}


	@Override
	public T removeFirst() {
		
		if (head == null) return null;
		T result = head.getData();
		Node<T> next = head.getNext();
		head.eliminate();;
		head = next;
		if (head == null) tail = null;
		
		size--;
		return result;
	}

	@Override
	public T removeLast() {
		
		if (tail == null) return null;
		
		T result = tail.getData();
		if (head == tail) {
			tail.eliminate();
			head = null;
			tail = null;
		}
		else {
			Node<T> prev = getNodeByIndex(size-2);
			prev.setNext(null);
			tail.eliminate();
			tail = prev;
		}
		
		size--;
		return result;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) return null;
		if (index == 0) return removeFirst();
		if (index == size - 1) return removeLast();
		
		Node<T> prev = getNodeByIndex(index-1);
		Node<T> victim = prev.getNext();
		T result = victim.getData();
		prev.setNext(victim.getNext());
		
		victim.eliminate();
		size--;
		return result;
	}

	@Override
	public boolean remove(T data) {
		if (head == null) return false;
		
		if (head.getData().equals(data)) {
			removeFirst();
			return true;
		}
		
		Node<T> prev = head;
		Node<T> victim;
		do{
			victim = prev.getNext();
			if (victim == null) break;
			if (victim.getData().equals(data)) {
				prev.setNext(victim.getNext());
				victim.eliminate();;
				if (victim == tail) tail = prev;
				size--;
				return true;
			}
			prev = victim;
		}while(prev != null);
		
		return false;
	}
}
