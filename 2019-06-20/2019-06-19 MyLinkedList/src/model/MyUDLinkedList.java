package model;

public class MyUDLinkedList<T> implements MyList<T>{
	
	private NodeUD<T> head = null;
	private NodeUD<T> tail = null;
	private int size = 0;

	@Override
	public void add(T data) {
		NodeUD<T> node = new NodeUD<T>(data);
		
		if (head == null) head = node;
		else tail.setNext(node);
		
		tail = node;
		size++;	
	}

	@Override
	public void addFirst(T data) {
		NodeUD<T> node = new NodeUD<T>(data);
		if(head == null) tail = node;
		else node.setNext(head);
		head = node;
		size++;
	}

	@Override
	public void addLast(T data) {
		add(data);
		
	}

	@Override
	public boolean addByIndex(int index, T data) {
		if (index < 0 || index > size) return false;
		if (index == 0) addFirst(data);
		else if (index == size)add(data);
		else {
			NodeUD<T> node = new NodeUD<T>(data);
			NodeUD<T> prev = getNodeByIndex(index - 1);
			
			node.setNext(prev.getNext());
			prev.setNext(node);
			
			size++;
		}
		return true;
	}
	
	private NodeUD<T> getNodeByIndex(int index){
		NodeUD<T> current = head;
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
		NodeUD<T> node = head;
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
		return (index < 0 || index >= size) ?
				null :
				getNodeByIndex(index).getData();	
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
	public T removeFirst() {
		
		if (head == null) return null;
		T result = head.getData();
		NodeUD<T> next = head.getNext();
		eliminate(head);
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
			eliminate(tail);
			head = null;
			tail = null;
		}
		else {
			NodeUD<T> prev = getNodeByIndex(size-2);
			prev.setNext(null);
			eliminate(tail);
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
		
		NodeUD<T> prev = getNodeByIndex(index-1);
		NodeUD<T> victim = prev.getNext();
		T result = victim.getData();
		prev.setNext(victim.getNext());
		
		eliminate(victim);
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
		
		NodeUD<T> prev = head;
		NodeUD<T> victim;
		do{
			victim = prev.getNext();
			if (victim == null) break;
			if (victim.getData().equals(data)) {
				prev.setNext(victim.getNext());
				eliminate(victim);
				if (victim == tail) tail = prev;
				size--;
				return true;
			}
			prev = victim;
		}while(prev != null);
		
		return false;
	}

	@Override
	public void eliminateAll() {
		NodeUD<T> current = head;
		NodeUD<T> next;
		while(current != null) {
			next = current.getNext();
			eliminate(current);
			current = next;
			size--;
		}
		head = null;
		tail = null;
		
		size = 0;		
	}

	private void eliminate(NodeUD<T> node) {
		if (node == null) return;
		node.setNext(null);
		node.setData(null);
	}

	@Override
	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		NodeUD<T> node = head;
		while(node != null) {
			sb.append(node.getData() + "  ");
			node = node.getNext();
		}
		
		return "["+sb.toString().trim()+"]";
	}

}
