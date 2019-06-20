package model;

public class MyLinkedList<T> implements MyList<T>{

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    @Override
    public void add(T data) {
        Node<T> node = new Node<T>(data);
        if(head == null){
            head = node;
        }else{
            node.setPrev(tail); //говорим узлу что его предыдущий элемент это старый хвост
            tail.setNext(node); //говорим указателю на старый хвост что новый узел это след элемент
        }
        tail = node;
        size++;
    }

    @Override
    public void addFirst(T data) {
        Node<T> node = new Node<T>(data);
        if(head == null) {
            tail = node;
        }else{
            head.setPrev(node);
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
        if(index<0 || index>size)return false;
        if(index == 0) addFirst(data);
        else if(index == size) add(data);
        else {
            Node<T> node = new Node<T>(data);

            Node<T> target = getNodeByIndex(index);

            Node<T> prev = target.getPrev();

            node.setNext(target);
            node.setPrev(prev);
            prev.setNext(node);
            target.setPrev(node);
            size++;
        }

        return true;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> result = head;
        int counter = 0;
        while(counter < index){
            result = result.getNext();
            counter++;
        }
        return result;
    }

    @Override
    public int indexOf(T data) {
        if(head == null)return -1;
        int counter = 0;
        Node<T> node = head;
        while(node != null){
            if(node.getData().equals(data))return counter;
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
    public T getFirst() {
        return head == null ? null : head.getData();
    }

    @Override
    public T getLast() {
        return tail == null ? null : tail.getData();
    }

    @Override
    public boolean set(int index, T data) {
        if (index < 0 || index >= size) return false;
        getNodeByIndex(index).setData(data);
        return true;
    }

    @Override
    public T removeFirst() {
        if(head == null)return null;
       Node<T> removeElement = head;
       if(head.getNext() == null){
           head = null; tail = null;
       }
       else{
           head = head.getNext();
           head.setPrev(null);
           removeElement.setNext(null);
       }
       size--;
        System.out.println("head = "+head);
        System.out.println("tail = "+tail);
       return removeElement.getData();
    }

    @Override
    public T removeLast() {
        if(tail == null)return null;
        Node<T> removeElement = tail;
        if(tail.getPrev() == null){head = null;tail = null;}
        else{
            tail=tail.getPrev();
            tail.setNext(null);
            removeElement.setPrev(null);
        }
        size--;
        return (T) removeElement.getData();
    }

    public T removeByIndex(int index) {
        if (index < 0 || index > size-1) return null;
        if (index == 0){removeFirst();return null;}
        if (index == (size-1)){removeLast();return null;}
        int counter = 0;
        Node<T> loopElement = head;
        Node<T> PrevElementBeforeRemoved = null;
        Node<T> NextElementAfterRemoved = null;
        while(loopElement != null) {
            if (counter == index) {
                PrevElementBeforeRemoved = loopElement.getPrev();
                NextElementAfterRemoved = loopElement.getNext();
                loopElement.setNext(null);
                loopElement.setPrev(null);
                PrevElementBeforeRemoved.setNext(NextElementAfterRemoved);
                NextElementAfterRemoved.setPrev(PrevElementBeforeRemoved);
                size--;
                return null;
            } else {
                counter++;
            }
            loopElement = loopElement.getNext();
        }
        return null;
    }

    @Override
    public T remove(T data) {
        Node<T> loopElement = head;
        int counter = 0;
        while(loopElement != null) {
            if(loopElement.getData().equals(data)){
                removeByIndex(counter);
            }
            counter++;
            loopElement = loopElement.getNext();
        }
        return data;
    }



    @Override
    public void eliminateAll() {
        long time_start = System.nanoTime();
        while(head != null) {
            removeFirst();
        }
        tail = null;
        long time_finish = System.nanoTime();
        System.out.println(time_finish-time_start);
    }

    @Override
    public int size() {
        return size;
    }

    //different from teacher
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        if (size > 0) {
            Node<T> result = head;
            sb.append(head.getData().toString() + "  ");
            while (result.getNext() != null) {
                result = result.getNext();
                sb.append(result.getData().toString());
                sb.append("  ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
