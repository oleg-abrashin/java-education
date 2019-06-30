package interfaces;

public interface ITreeSet<T> {

    boolean add(T data);

    boolean contains(T data);

    boolean remove(T data);

    boolean superRemove(T data);

    int deep();

    int size();
}
