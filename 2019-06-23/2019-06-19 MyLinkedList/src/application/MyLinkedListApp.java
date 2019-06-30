package application;

import java.util.Iterator;

import model.MyLinkedList;
import model.MyUDLinkedList;

public class MyLinkedListApp {

	public static void main(String[] args) {
		
		MyLinkedList<Integer> mlli = new MyLinkedList<>();
		
		mlli.add(3);
		mlli.add(11);
		mlli.addLast(-8);
		
		mlli.addFirst(4);
		mlli.addFirst(-2);
		mlli.addFirst(6);
		
		mlli.addByIndex(3, 111);
		
		System.out.println(mlli);
		/*System.out.println(mlli.indexOf(11));
		mlli.removeFirst();
		System.out.println("Remove first: "+mlli);
		mlli.removeLast();
		System.out.println("Remove last: "+mlli);
		mlli.remove(1);
		System.out.println("Remove by index(1): "+mlli);
		mlli.remove((Integer)11);
		System.out.println("Remove by value(-2): "+mlli);
		mlli.eliminateAll();
		System.out.println("Eliminate: "+mlli);*/
		
		Iterator<Integer> it = mlli.butterflyIterator();
		while(it.hasNext()) {
			System.out.print(it.next()+"  ");
		}
		
		/*for(Integer i : mlli){
			System.out.print(i + "  ");
		};*/
		
		

	}

}
