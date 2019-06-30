package application;

import java.util.Arrays;

public class MaskingApp {
	
	public static void main(String[] args) {
		/*int x = 17;
		System.out.println(x << 3);*/
		
		/*boolean[] info = {false, true, true, true, true, true, false, true};
		byte encodedInfo = encode(info);
		System.out.println(encodedInfo);
		System.out.println(Arrays.toString(decode(encodedInfo)));*/
		
		int x = 245;
		int n = 3;
		
		int res = x&((1 << n) - 1);
		
		System.out.println(res);
	}
	
	public static byte encode(boolean[] info) {
		byte result = 0;
		for (int i=0; i<8; i++) {
			if (info[i]) result = (byte) (result | (1<<i));
		}
		return result;
	}
	
	public static boolean[] decode(byte encoded) {
		boolean[] result = new boolean[8];
		for (int i = 0; i < 8; i++) {
			result[i] = (encoded & (1<<i)) != 0;
		}
		return result;
	}

}
