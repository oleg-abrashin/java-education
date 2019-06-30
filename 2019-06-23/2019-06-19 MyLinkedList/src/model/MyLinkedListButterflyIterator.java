package model;

import java.util.Iterator;

public class MyLinkedListButterflyIterator<T> implements Iterator<T> {

	Node<T> current;
	boolean forward = true;
	
	public MyLinkedListButterflyIterator(Node<T> head) {
		super();
		this.current = head;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		T result = current.getData();
	
		if (forward) {
			Node<T> next = current.getNext();
			if (next == null) {
				current = current.getPrev();
				forward = false;
			}
			else {
				next = next.getNext();
				if (next == null) {
					current = current.getNext();
					forward = false;
				}
				else current = next;
			}
		}
		else current = current.getPrev().getPrev();
		
		return result;
	}

}
