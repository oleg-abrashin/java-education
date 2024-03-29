package model;

public interface MyList<T> {
	
	void add(T data);
	void addFirst(T data);
	void addLast(T data);
	boolean addByIndex(int index, T data);
	
	int indexOf(T data);
	boolean contains(T data);
	
	T get(int index);
	T getFirst();
	T getLast();
	boolean set(int index, T data);
	
	T removeFirst();
	T removeLast();
	T remove(int index);
	T remove (T data);
	
	void eliminateAll();
	
	int size();

}
