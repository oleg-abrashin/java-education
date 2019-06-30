package randomlib;

import java.util.Random;

public class RandomLib {
	
	private static final int ALPHABET_LENGTH = 62;
	private static final String ALPHABET = 
			"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static Random gen = new Random();
	
	public static int nextIntRange(int min, int max) {
		return min + gen.nextInt(max - min + 1);
	}
	
	public static double nextDoubleRange(double min, double max) {
		return min + gen.nextDouble()*(max - min);
	}
	
	public static boolean nextRandomBoolean(double trueProbability) {
		return gen.nextDouble() < trueProbability;
	}
	
	public static String nextRandomString(int len) {
		String result = "";
		for (int i = 0; i < len; i++)
			result = result +
				ALPHABET.charAt(gen.nextInt(ALPHABET_LENGTH));
		return result;
	}
	
	public static String nextStringFromSet(String[] set) {
		if (set == null || set.length == 0) return "ha-ha-ha";
		return set[gen.nextInt(set.length)];
	}

}
