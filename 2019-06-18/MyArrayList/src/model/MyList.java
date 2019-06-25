package model;

public interface MyList<T> {
	
	public void add(T data);
	public boolean add(T data, int index);
	public T get(int index);
	public boolean set(T data, int index);
	public int indexOf(T value);
	public boolean contains(T data);
	public T remove(int index);
	public boolean remove(int indFrom, int indTo);
	public int size();
	public void trim();
	public void shuffle();
}
