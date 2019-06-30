package model;

import nodes.NodeB;

public class BLinkedList<T> extends AbstractLinkedList<T>{

	@Override
	public void add(T data) {
		
		NodeB<T> node = new NodeB<T>(data);
		 
		 if (head == null) {
			 head = node;
		 }
		 else {
			 node.setPrev((NodeB<T>)tail);
			 tail.setNext(node);
		 }
		 tail = node;
		 size++;
	}

	@Override
	public void addFirst(T data) {
		
		NodeB<T> node = new NodeB<T>(data);
		
		if (head == null) {
			tail = node;
		}
		else {
			((NodeB<T>)head).setPrev(node);
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
			NodeB<T> node = new NodeB<T>(data);
			
			NodeB<T> target = (NodeB<T>) getNodeByIndex(index);
			
			NodeB<T> prev = target.getPrev();
			
			node.setNext(target);
			node.setPrev(prev);
			prev.setNext(node);
			target.setPrev(node);
			
			size++;			
		}

		return true;
	}

	@Override
	public T removeFirst() {
		if (head == null) return null;
		
		NodeB<T> next = ((NodeB<T>)head).getNext();
		if (next != null) next.setPrev(null);
		else tail = null;
		
		T result = head.getData();
		head.eliminate();;		
		head = next;
		size--;
		return result;
	}

	@Override
	public T removeLast() {
		if (tail == null) return null;
		
		NodeB<T> prev = ((NodeB<T>)tail).getPrev();
		if (prev != null)prev.setNext(null);
		else head = null;
		
		T result = tail.getData();
		tail.eliminate();
		tail = prev;
		size--;
		
		return result;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) return null;
		if (index == 0) return removeFirst();
		if (index == size - 1) return removeLast();
		
		NodeB<T> victim = (NodeB<T>) getNodeByIndex(index);
		T result = victim.getData();
		
		NodeB<T> next = victim.getNext();
		NodeB<T> prev = victim.getPrev();
		
		prev.setNext(next);
		next.setPrev(prev);
		
		victim.eliminate();;
		size--;
		
		return result;
	}

	@Override
	public boolean remove(T data) {
		NodeB<T> victim = (NodeB<T>) head;
		while(victim != null) {
			if (victim.getData().equals(data)) {
				
				if (victim == head) return removeFirst() != null;
				if (victim == tail) return removeLast() != null;
				
				NodeB<T> next = victim.getNext();
				NodeB<T> prev = victim.getPrev();
				
				prev.setNext(next);
				next.setPrev(prev);
				
				victim.eliminate();;
				size--;
				
				return true;	
			}
			victim = victim.getNext();
		}
		return false;

	}

}
