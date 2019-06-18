package model;

import java.util.Arrays;
import java.util.Random;

public class MyArrayList<T> implements MyList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private static int temp = 0;

    private static Random gen = new Random();

    public Object[] array;
    private int size = 0; //занимаемый объем
    public int capacity = 10; //общий объем

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int specifedCapacity) {
        if (specifedCapacity < DEFAULT_CAPACITY)
            specifedCapacity = DEFAULT_CAPACITY;
        array = new Object[specifedCapacity];
        capacity = specifedCapacity;
    }

    @Override
    public void add(T data) {
        if (size == capacity) enlargeArray();
        array[size++] = data;
    }

    private void enlargeArray() {
        capacity = 2 * capacity;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
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
        if (index < 0 || index > size) return false;
        array[index] = data;
        return true;
    }

    @Override
    public boolean contains(T data) {
        return indexOf(data) >= 0;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void trim() {
        array = Arrays.copyOf(array,size);
        capacity = size;
    }

    @Override
    public void shuffle() {
        int j = 0;
        for (int i = size-1; i > 0; i--) {
            j = gen.nextInt(i+1);
            Object pocket = array[j];
            array[j] = array[i];
            array[i] = pocket;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++)sb.append("  "+array[i]+"  ");
        return "["+sb.toString().substring(2)+"]";
    }

    @Override
    public int indexOf(T value){
        for (int i = 0; i < size; i++) {
            if(value.equals(array[i]))return i;
        }
        return -1;
    }

}