package model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class MyArrayList<T> implements MyList<T>, Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    static Random gen = new Random();
    private Object[] array;
    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;


    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int specifiedCapacity) {
        if (specifiedCapacity < DEFAULT_CAPACITY)
            specifiedCapacity = DEFAULT_CAPACITY;
        array = new Object[specifiedCapacity];
        capacity = specifiedCapacity;
    }


    @Override
    public void add(T data) {
        if (size == capacity) enlargeArray();
        array[size++] = data;
    }

    private void enlargeArray() {
        capacity = capacity * 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public boolean add(T data, int index) {
        if (index < 0 || index > size) return false;
        if (size == capacity) enlargeArray();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = data;
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return (T) array[index];
    }

    @Override
    public boolean set(T data, int index) {
        if (index < 0 || index >= size) return false;
        array[index] = data;
        return true;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(T data) {
        return indexOf(data) >= 0;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) throw new RuntimeException("Pizdets!!!"); // raise exception
        T obj = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        array[size - 1] = null;
        size--;
        return obj;
    }

    @Override
    public boolean remove(int indFrom, int indTo) {
        System.arraycopy(array, indTo, array, indFrom, size - indTo);
        Arrays.fill(array, size - (indTo - indFrom), size, null);
        size -= indTo - indFrom;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void trim() {
        array = Arrays.copyOf(array, size);
        capacity = size;
    }

    @Override
    public void shuffle() {
        int j = 0;
        for (int i = 0; i < size; i++) {
            j = gen.nextInt(size);
            Object pocket = array[j];
            array[j] = array[i];
            array[i] = pocket;
        }

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("  " + array[i]);
        }
        return "[" + sb.toString().trim() + "]";
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator(this);
    }

    public Object[] getArray() {
        return array;
    }
}
