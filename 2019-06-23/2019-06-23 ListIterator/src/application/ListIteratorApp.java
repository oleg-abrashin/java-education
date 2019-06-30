package application;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorApp {

	private static final int NUM_NUM = 20;

	public static void main(String[] args) {
		
		ArrayList<Integer> ali = new ArrayList<>();
		//ListIterator<Integer> lit = ali.listIterator();
		
		for (int i=0; i<NUM_NUM; i++)ali.add(10+i);
		System.out.println(ali);
		ListIterator<Integer> lit = ali.listIterator(10);
		
		//System.out.println(lit.hasPrevious());
		/*lit.previous();
		lit.previous();
		lit.previous();
		lit.remove();*/
		/*lit.next();
		lit.next();
		lit.next();
		System.out.println(lit.nextIndex());
		System.out.println(lit.previousIndex());*/
		while(lit.hasNext()) {
			int i = lit.next();
			lit.set(i*i);
		}
		System.out.println(ali);

	}

}
