package application;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

import model.MyTreeSet;


public class MyTreeSetApp {

	private static final int NUM_NUM = 1000000;
	static Random gen = new Random();
	
	public static void main(String[] args) {
		MyTreeSet<Integer> mtsi = 
				new MyTreeSet<Integer>();
		
		
		
		//mtsi.unbalanced();
		
		for (int i = 0; i < NUM_NUM; i++) mtsi.add(gen.nextInt());
		//for(Integer i : mtsi)System.out.print(i+"  ");
		//System.out.println();
		
		/*Iterator<Integer> rit = mtsi.recursiveIterator();
		while(rit.hasNext())System.out.print(rit.next()+"  ");
		System.out.println();*/
		
		/*mtsi.remove(-99);
		for(Integer i : mtsi)System.out.print(i+"  ");
		System.out.println();*/
		
		System.out.println("deep "+ mtsi.deep());
	}

}
