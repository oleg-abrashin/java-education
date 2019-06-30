package application;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

import predicates.MultipleOfFive;
import predicates.MultipleOfN;
import predicates.Range;

public class IntegerPredicateApp {

	private static final int NUM_NUM = 20;
	static Random gen = new Random();
	public static void main(String[] args) {
		
		int[] arr = new int[NUM_NUM];
		for (int i = 0; i < arr.length; i++) 
			arr[i] = gen.nextInt(100);
		System.out.println(Arrays.toString(arr));
		
		//int[] filtered = filterInteger(arr, new MultipleOfFive());
		//int[] filtered = filterInteger(arr, new MultipleOfN(11));
		int[] filtered = filterInteger(arr, new Range(30,60));
		System.out.println(Arrays.toString(filtered));

	}
	
	public static int[] filterInteger(int[] arr, Predicate<Integer> predicate) {
		int[] buffer = new int[arr.length];
		int counter = 0;
		for(int i=0; i < arr.length; i++) {
			if (predicate.test(arr[i])) {
				buffer[counter++] = arr[i];
			}
		}
		
		int[] result = new int[counter];
		for (int i = 0; i < counter; i++) result[i] = buffer[i];
		
		return result;
		
	}

}
