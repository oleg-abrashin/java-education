package model;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayListIterator<T> implements Iterator<T> {

    MyArrayList<T> mal;

    private int current = 0;

    public MyArrayListIterator(MyArrayList<T> mal) {
        super();
        this.mal = mal;
    }

    @Override
    public boolean hasNext() {
        return current < mal.size();
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException("NoSuchElementException error");
        }
        return mal.get(current++);
    }
}
