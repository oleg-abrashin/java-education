package model;

public interface UDMyList<T> {
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
    T removeByIndex(int index);
    boolean remove(T data); //equals delete only first coincidence

    void eliminateAll(); //уничтожить все

    int size();


}
