package model;

import interfaces.ITreeSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class MyTreeSet<T> implements ITreeSet<T>, Iterable<T> {

    private Node<T> root;
    private int size;
    private Comparator<T> comparator;

    public MyTreeSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public MyTreeSet() {
        comparator = (Comparator<T>) Comparator.naturalOrder();
    }

    @Override
    public boolean add(T data) {
        if (root == null) {
            Node<T> node = new Node<>(data);
            root = node;
            size++;
            return false;
        }
        Node<T> current = root;
        int compareResult;
        while (true) {
            compareResult = comparator.compare(current.getData(), data);
            if (compareResult == 0) return false;
            if (compareResult > 0) {
                if (current.getLeft() == null) break;
                current = current.getLeft();
            } else {
                if (current.getRight() == null) break;
                current = current.getRight();
            }
        }
        Node<T> node = new Node<>(data);
        node.setParent(current);
        if (compareResult > 0) current.setLeft(node);
        else current.setRight(node);
        size++;
        return false;
    }

    @Override
    public boolean contains(T data) {
        return get(data) != null;
    }

    private Node<T> get(T data) {
        Node<T> current = root;
        while (Integer.compare((Integer) current.getData(), (Integer) data) != 0) {
            if (Integer.compare((Integer) data, (Integer) current.getData()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    @Override
    public boolean superRemove(T data) {
        Node<T> target = get(data);
        if (target == null) {
            return false;
        }
        // Only element / r/l Most
        if (target.getRight() == null && target.getLeft() == null) {
            if (target.isRoot()) {
                root = null;
            } else if (target.isRightChild()) {
                target.getParent().setRight(null);
            } else {
                target.getParent().setLeft(null);
            }
            target.setParent(null);
            size--;
            return true;
        }
        // Elements with children
        Node<T> plug = target;
        if (plug.getRight() != null) {
            plug = plug.getRight().getLeftMost();
            while (plug.getLeft() != null) {
                plug = plug.getRight().getLeftMost();
            }
        } else {
            plug = plug.getLeft().getRightMost();
            while (plug.getRight() != null) {
                plug = plug.getLeft().getRightMost();
            }
        }

        System.out.println("Plug: " + plug.getData());

        // Removing

        Node<T> targetParent = target.getParent();
        Node<T> plugParent = plug.getParent();

        // If target and plug in relation
        if (target.getRight() != null && target.getRight().getData() == plug.getData()) {
            plug.setLeft(target.getLeft());
            if (target.getLeft() != null) {
                target.getLeft().setParent(plug);
            }
        } else if (target.getLeft() != null && target.getLeft().getData() == plug.getData()) {
            plug.setRight(target.getRight());
            if (target.getRight() != null) {
                target.getRight().setParent(plug);
            }
        }

        // Remove plug from parent and set new parent
        if (plug.isLeftChild()) {
            plugParent.setLeft(null);
        } else if (plug.isRightChild()) {
            plugParent.setRight(null);
        }

        // Connecting new parent to plug-child
        if (target.isLeftChild()) {
            targetParent.setLeft(plug);
        } else if (target.isRightChild()) {
            targetParent.setRight(plug);
        }


        if (target.getRight() != null) {
            plug.setRight(target.getRight());
            target.getRight().setParent(plug);
        }
        if (target.getLeft() != null) {
            plug.setLeft(target.getLeft());
            target.getLeft().setParent(plug);
        }

        // If target is Root
        if (target.isRoot()) {
            root = plug;
            plug.setParent(null);
        } else {
            plug.setParent(targetParent);
        }

        target.setRight(null);
        target.setLeft(null);
        target.setParent(null);
        size--;
        return true;
    }

    @Override
    public boolean remove(T data) {

        Node<T> toBeRemoved = get(data);
        if (toBeRemoved == null) return false;

        if (toBeRemoved.getLeft() == null) removeLeftDisabled(toBeRemoved);
        else if (toBeRemoved.getRight() == null) removeRightDisabled(toBeRemoved);
        else {
            Node<T> victim = toBeRemoved.getRight().getLeftMost();
            toBeRemoved.setData(victim.getData());
            removeLeftDisabled(victim);
        }
        size--;
        return false;
    }

    private void removeRightDisabled(Node<T> node) {
        if (node == root) {
            root = root.getLeft();
        } else {

            Node<T> left = node.getLeft();
            Node<T> parent = node.getParent();

            if (node.isLeftChild()) parent.setLeft(left);
            else parent.setRight(left);

            if (left != null) left.setParent(parent);
        }
    }

    private void removeLeftDisabled(Node<T> node) {
        if (node == root) {
            root = root.getRight();
        } else {

            Node<T> right = node.getRight();
            Node<T> parent = node.getParent();

            if (node.isLeftChild()) parent.setLeft(right);
            else parent.setRight(right);

            if (right != null) right.setParent(parent);
        }
    }


    @Override
    public int deep() {
        return subTreeDeep(root);
    }

    private int subTreeDeep(Node<T> node) {

        return node == null ? 0 : Integer.max(subTreeDeep(node.getLeft()),
                subTreeDeep(node.getRight())) + 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new IterativeIterator(this);
    }

    public Iterator<T> recursiveIterator() {
        return new MyTreeSetRecursiveIterator<>(root);
    }

    public Iterator<T> rangeIterator(T min, T max) {
        return new MyTreeSetRangeIterator<>(root, min, max, comparator);
    }

    public Node<T> getRoot() {
        return root;
    }

    private void granBalance(){
        ArrayList<T> alt = new ArrayList<>();
        for(T t:this) alt.add(t);
        root = null;
        size = 0;
        putSubArray(alt,0,alt.size()-1);
    }


    private void putSubArray(ArrayList<T> array, int min, int max){
        if (max - min < 2){
            add(array.get(min));
            if (max != min)add(array.get(max));
        } else {
            int middle = (max + min) / 2;
            add(array.get(middle));
            putSubArray(array, min, middle - 1);
            putSubArray(array, middle + 1, max);
        }
    }


}
