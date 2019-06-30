package application;

import java.util.Arrays;
import java.util.Random;

import randomlib.RandomLib;

public class RandomApp {

	private static final int NUM_NUM = 10;
	private static final int BOUND = 10;
	private static final String[] CAR_MODELS = {
			"Pobeda", "Volga", "Moskvich","Zhiguli","Zaporozhets",
			"Ford","Toyota","Kia","Wolkswagen","Fiat"
	};
	static Random gen = new Random();
	
	public static void main(String[] args) {
		
		int[] arr = new int[BOUND];
		for (int i=0; i < NUM_NUM; i++) {
			//System.out.println(gen.nextInt());
			//System.out.println(gen.nextInt(BOUND));
			//arr[gen.nextInt(BOUND)]++;
			//System.out.println(RandomLib.nextIntRange(-30, -40));
			//System.out.println(gen.nextDouble());
			//System.out.println(RandomLib.nextDoubleRange(-30., -40.));
			//System.out.println(Long.toString(gen.nextLong(), 36));
			//System.out.println(RandomLib.nextRandomString(50));
			System.out.println(RandomLib.nextStringFromSet(new String[0]));
		}
		
		//System.out.println(Arrays.toString(arr));
		
	}
}
