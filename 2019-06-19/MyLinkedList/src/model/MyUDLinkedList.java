package model;

public class MyUDLinkedList<T> extends AbstractMyLinkedList<T> {

    @Override
    public void add(T data) {
        NodeUD<T> node = new NodeUD<T>(data);
        if (head == null) { // если пусто -> создаем один элемент
            head = node;
        } else { // есть элементы
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    @Override
    public void addFirst(T data) {
        NodeUD<T> node = new NodeUD<T>(data);
        if (head == null) { // если пусто -> создаем один элемент
            tail = node;
        } else {
            node.setNext(head);
        }
        head = node;
        size++;
    }

    @Override
    public void addLast(T data) {
        add(data);

    }

    @Override
    public boolean addByIndex(int index, T data) {
        if (index > size || index < 0) return false;
        if (index == 0) addFirst(data);
        else if (index == size) add(data);
        else {
            NodeUD<T> node = new NodeUD<>(data);
            NodeUD<T> target = getNodeByIndex(index - 1);
            NodeUD<T> next = getNodeByIndex(index);

            target.setNext(node);

            node.setNext(next);
            size++;
        }
        return true;
    }

    private NodeUD<T> getNodeByIndex(int index) {
        NodeUD<T> result = head;
        int counter = 0;
        while (counter < index) {
            counter++;
            result = result.getNext();
        }
        return result;
    }

    @Override
    public int indexOf(T data) {
        if (head == null) return -1;
        int counter = 0;
        NodeUD<T> node = head;
        while (node != null) {
            if (node.getData().equals(data)) return counter;
            node = node.getNext();
            counter++;
        }
        return -1;
    }

    @Override
    public boolean contains(T data) {
        return indexOf(data) >= 0;
    }

    @Override
    public T get(int index) {
        return (index < 0 || index >= size) ? null : getNodeByIndex(index).getData();
    }

    @Override
    public boolean set(int index, T data) {
        if (index < 0 || index >= size) {
            return false;
        }
        getNodeByIndex(index).setData(data);
        return true;
    }

    @Override
    public T removeFirst() {
        if (head == null) return null;
        T result = head.getData();

        NodeUD<T> next = head.getNext();
        eliminate(head);

        head = next;
        if (next == null) tail = null;
        size--;
        return result;
    }

    private void eliminate(NodeUD<T> removeElement) {
        if (removeElement == null) return;
        removeElement.setNext(null);
        removeElement.setData(null);
    }

    @Override
    public T removeLast() {
        if (tail == null) return null;
        T result = tail.getData();
        if (head == tail) {
            eliminate(tail);
            head = null;
            tail = null;
        } else {
            NodeUD<T> prev = getNodeByIndex(size - 2);
            prev.setNext(null);
            eliminate(tail);
            tail = prev;
        }

        size--;
        return result;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) return null;
        if (index == size - 1)
            return removeLast();
        if (index == 0)
            return removeFirst();

        NodeUD<T> prev = getNodeByIndex(index - 1);
        NodeUD<T> target = prev.getNext();
        T result = target.getData();
        prev.setNext(target.getNext());

        eliminate(target);
        size--;

        return result;
    }

    @Override
    public boolean remove(T data) {
        if (head == null) return false;
        if (head.getData().equals(data)) {
            removeFirst();
            return true;
        }

        NodeUD<T> prev = head;
        NodeUD<T> target;
        do {
            target = prev.getNext();
            if (target == null) break;
            if (target.getData().equals(data)) {
                prev.setNext(target.getNext());
                eliminate(target);
                if (target == tail) tail = prev;
                size--;
                return true;
            }
            prev = target;

        } while (prev != null);

        return false;
    }

}