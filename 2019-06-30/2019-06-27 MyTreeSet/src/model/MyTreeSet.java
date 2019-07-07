package model;

import java.util.ArrayList;
import java.util.Comparator;

import java.util.Iterator;

public class MyTreeSet<T> implements ITreeSet<T> {
	
	private static final int MIN_BALANCE = 1000;
	private static final double BALANCE_COEFF = 0.25;
	private Node<T> root;
	private int size;
	private Comparator<T> comparator;
	private boolean balanced = true;

	public MyTreeSet() {
		super();
		comparator = (Comparator<T>)Comparator.naturalOrder();
	}
	
	public MyTreeSet(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public boolean add(T data) {
		int level = 1;
		
		if (root == null) {
			root = new Node<T>(data);
			size++;
			return true;
		}
		
		Node<T> current = root;
		int compareResult;
		while (true) {
			compareResult = comparator.compare(current.getData(), data);
			level++;
			if (compareResult == 0) return false;
			if (compareResult > 0) {
				if (current.getLeft() == null) break;
				current = current.getLeft();
				
			} else {
				if (current.getRight() == null) break;
				current = current.getRight();
			}
		}
		
		Node<T> node = new Node<T>(data);
		node.setParent(current);
		if (compareResult > 0) current.setLeft(node);
		else current.setRight(node);
		size++;
		
		if (needBalance(level)) granBalance();
		
		return true;
	}

	@Override
	public boolean contains(T data) {
		return getNodeByData(data) != null;
	}

	private Node<T> getNodeByData(T data) {
		if (root == null) return null;
		
		Node<T> current = root;
		int compareResult;
		while (true) {
			compareResult = comparator.compare(current.getData(), data);
			if (compareResult == 0) return current;
			if (compareResult > 0) {
				if (current.getLeft() == null) return null;
				current = current.getLeft();
			}else {
				if (current.getRight() == null) return null;
				current = current.getRight();
			}
		}
	}
	
	@Override
	public boolean remove(T data) {
		
		Node<T> toBeRemoved = getNodeByData(data);
		if (toBeRemoved == null) return false;
		
		if (toBeRemoved.getLeft() == null) removeLeftDisabled(toBeRemoved);
		else if (toBeRemoved.getRight() == null) removeRightDisabled(toBeRemoved);
		else {
			Node<T> victim = toBeRemoved.getRight().getLeftmost();
			toBeRemoved.setData(victim.getData());
			removeLeftDisabled(victim);
		}
		size--;
		
		return true;
	}

	private void removeRightDisabled(Node<T> node) {
		if (node == root) root = root.getLeft();
		else {
			Node<T> left = node.getLeft();
			Node<T> parent = node.getParent();
		
			if (node.isLeftChild()) parent.setLeft(left);
			else parent.setRight(left);
		
			if (left != null) left.setParent(parent);
		}
		
	}
	
	private void removeLeftDisabled(Node<T> node) {
		if (node == root)root = root.getRight();
		else {
			Node<T> right = node.getRight();
			Node<T> parent = node.getParent();
			
			if (node.isLeftChild()) parent.setLeft(right);
			else parent.setRight(right);
			
			if (right != null) right.setParent(parent);
		}
	}
	
	private void granBalance() {
		ArrayList<T> alt = new ArrayList<>();
		for (T t : this) alt.add(t);
		root = null;
		size = 0;
		unbalanced();
		putSubArray(alt, 0, alt.size()-1);
		balanced();
	}
	
	private void putSubArray(ArrayList<T> array, int min, int max) {
		if (max - min < 2) {
			add(array.get(min));
			if (max != min) add(array.get(max));
		}
		else {		
			int middle = min + (max - min)/2;
			add(array.get(middle));
			putSubArray(array, min, middle -1);
			putSubArray(array, middle + 1, max);
		}
	}
	
	public void balanced() {
		balanced = true;
	}
	
	public void unbalanced() {
		balanced = false;
	}
	
	private double log2(int num) {
		int i = 0;
		for (; (1 << i) < num; i++) {}
		return (double)i;
	}
	
	private boolean needBalance(int level) {
		return balanced && 
				(size > MIN_BALANCE) && 
				((1.+BALANCE_COEFF)*log2(size) < level);
	}
	
	@Override
	public int deep() {
		return subTreeDeep(root);
	}

	private int subTreeDeep(Node<T> node) {
		return node == null ? 0 :
			Integer.max(subTreeDeep(node.getLeft()), 
				           subTreeDeep(node.getRight())) +1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyTreeSetIteratorI<T>(root);
	}
	
	public Iterator<T> rangeIterator(T min, T max) {
		return new MyTreeSetRangeIteratorI<T>(root, min, max, comparator);
	}
	
	public Iterator<T> recursiveIterator() {
		return new MyTreeSetIteratorR<T>(root);
	}
	

}
