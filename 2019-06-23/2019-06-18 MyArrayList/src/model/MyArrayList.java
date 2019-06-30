package model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class MyArrayList<T> implements MyList<T>{
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private static Random gen = new Random();
	
	public Object[] array;
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
		
		capacity = 2*capacity;
		Object[] newArray = new Object[capacity];
		System.arraycopy(array, 0, newArray, 0, size);
		array = newArray;
		
	}

	@Override
	public boolean add(T data, int index) {
		
		if (index < 0 || index > size) return false;
		
		if (size == capacity) enlargeArray();
		System.arraycopy(array, index, array, index+1, size - index);
		array[index] = data;
		size++;
		
		return true;
	}

	@SuppressWarnings("unchecked")
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
			if (value.equals(array[i]))return i;
		}
		return -1;
	}

	@Override
	public boolean contains(T data) {
		return indexOf(data) >= 0;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) return null;
		T result = (T)array[index];
		System.arraycopy(array, index+1, array, index, size - 1 - index);
		array[size - 1] = null;
		size--;
		return result;
	}
	
	public boolean removeRange(int from, int to) {
		if (from < 0 || to > size || from >= to)return false;
		System.arraycopy(array, to, array, from, size-to);
		size = size-(to-from);
		Arrays.fill(array, size, size+(to-from), null);
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
		for (int i=size-1; i > 0; i-- ) {
				j = gen.nextInt(i+1);
				Object pocket = array[j];
				array[j] = array[i];
				array[i] = pocket;		
		}	
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++)sb.append("  " +array[i]);
		return "["+sb.toString().trim()+"]";
	}

	@Override
	public Iterator<T> iterator() {
		return new MyArrayListIterator(this);
	}
	



}
