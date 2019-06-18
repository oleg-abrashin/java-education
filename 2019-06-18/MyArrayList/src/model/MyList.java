package model;

public interface MyList<T> {

    public void add(T data);
    public boolean add(T data, int index);
    public T get(int index);
    public boolean set(T data, int index);
    public boolean contains(T data);

    public T trim_first();
    public T trim_last();
    public T remove(int index);
    public T mark_range_as_null(int left_border_of_range,int right_border_of_range);
    public T input_value_in_range(int left_border_of_range,int right_border_of_range, String value);


    public int size();
    public void trim();
    public void shuffle();
    public int indexOf(T value);

}
