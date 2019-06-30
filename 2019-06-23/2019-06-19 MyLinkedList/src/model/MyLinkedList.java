package model;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<T> implements MyList<T>, Iterable<T>{
	
	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;

	@Override
	public void add(T data) {
		 Node<T> node = new Node<T>(data);
		 
		 if (head == null) {
			 head = node;
		 }
		 else {
			 node.setPrev(tail);
			 tail.setNext(node);
		 }
			 tail = node;
			 size++;
		
	}

	@Override
	public void addLast(T data) {
		add(data);	
	}

	@Override
	public void addFirst(T data) {
		Node<T> node = new Node<T>(data);
		
		if (head == null) {
			tail = node;
		}
		else {
			head.setPrev(node);
			node.setNext(head);
		}
		
		head = node;
		size++;	
	}

	@Override
	public boolean addByIndex(int index, T data) {
		if(index < 0 || index > size) return false;
		if (index == 0) addFirst(data);
		else if(index == size)add(data);
		else {
			Node<T> node = new Node<T>(data);
			
			Node<T> target = getNodeByIndex(index);
			
			Node<T> prev = target.getPrev();
			
			node.setNext(target);
			node.setPrev(prev);
			prev.setNext(node);
			target.setPrev(node);
			
			size++;			
		}

		return true;
	}

	private Node<T> getNodeByIndex(int index) {
		Node<T> result = head;
		int counter = 0;
		while(counter < index) {
			result = result.getNext();
			counter++;
		}
		return result;
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
		if (index < 0 || index >= size) return false;
		getNodeByIndex(index).setData(data);
		return true;
	}

	@Override
	public T removeFirst() {
		if (head == null) return null;
		
		Node<T> next = head.getNext();
		if (next != null) next.setPrev(null);
		else tail = null;
		
		T result = head.getData();
		eliminate(head);		
		head = next;
		size--;
		return result;
	}
	
	@Override
	public T removeLast() {
		if (tail == null) return null;
		
		Node<T> prev = tail.getPrev();
		if (prev != null)prev.setNext(null);
		else head = null;
		
		T result = tail.getData();
		eliminate(tail);
		tail = prev;
		size--;
		
		return result;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) return null;
		if (index == 0) return removeFirst();
		if (index == size - 1) return removeLast();
		
		Node<T> victim = getNodeByIndex(index);
		T result = victim.getData();
		
		Node<T> next = victim.getNext();
		Node<T> prev = victim.getPrev();
		
		prev.setNext(next);
		next.setPrev(prev);
		
		eliminate(victim);
		size--;
		
		return result;
	}

	@Override
	public boolean remove(T data) {
		
		Node<T> victim = head;
		while(victim != null) {
			if (victim.getData().equals(data)) {
				
				if (victim == head) return removeFirst() != null;
				if (victim == tail) return removeLast() != null;
				
				Node<T> next = victim.getNext();
				Node<T> prev = victim.getPrev();
				
				prev.setNext(next);
				next.setPrev(prev);
				
				eliminate(victim);
				size--;
				
				return true;	
			}
			victim = victim.getNext();
		}
		return false;
	}

	@Override
	public void eliminateAll() {
		Node<T> current = head;
		Node<T> next;
		while(current != null) {
			next = current.getNext();
			eliminate(current);
			current = next;
			head = current;
			size--;
		}
		size = 0;
		head = null;
		tail = null;
	}

	private void eliminate(Node<T> current) {
		current.setNext(null);
		current.setPrev(null);
		current.setData(null);
		
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

	@Override
	public Iterator<T> iterator() {
		
		return new MyLinkedListIterator(head);
	}
	
	public Iterator<T> backIterator(){
		return new MyLinkedListBackIterator(tail);
	}
	
	public Iterator<T> butterflyIterator(){
		return new MyLinkedListButterflyIterator(head);
	}
	
	public ListIterator<T> listIterator(){
		return new MyLinkedListListIterator();
	}

}
