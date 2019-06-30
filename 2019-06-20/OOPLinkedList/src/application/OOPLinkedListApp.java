package application;

import model.BLinkedList;
import model.ULinkedList;

public class OOPLinkedListApp {

	public static void main(String[] args) {
		BLinkedList<Integer> mlli = new BLinkedList<>();
		
		mlli.add(3);
		mlli.add(11);
		mlli.addLast(-8);
		
		mlli.addFirst(4);
		mlli.addFirst(-2);
		mlli.addFirst(6);
		
		mlli.addByIndex(3, 111);
		
		System.out.println(mlli);
		System.out.println(mlli.indexOf(11));
		mlli.removeFirst();
		System.out.println("Remove first: "+mlli);
		mlli.removeLast();
		System.out.println("Remove last: "+mlli);
		mlli.remove(1);
		System.out.println("Remove by index(1): "+mlli);
		mlli.remove((Integer)11);
		System.out.println("Remove by value(11): "+mlli);
		mlli.eliminateAll();
		System.out.println("Eliminate: "+mlli);
	}
}
