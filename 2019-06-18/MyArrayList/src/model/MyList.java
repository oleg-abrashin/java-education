package model;

public interface MyList<T> {

    public void add(T data);
    public boolean add(T data, int index);
    public T get(int index);
    public boolean set(T data, int index);
    public boolean contains(T data);
    public T remove(int index);
    public int size();
    public void trim();
    public void shuffle();
    public int indexOf(T value);

}
