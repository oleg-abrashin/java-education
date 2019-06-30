package application;

public class BinaryNotationApp {

	public static void main(String[] args) {
		
		System.out.println(decToBinary(0.125, 1.e-12));

	}
	
	public static int binaryToDec(String binaryStr) {
		int pow2 = 1;
		int result = 0;
		for (int i = binaryStr.length()-1; i >=0; i--) {
			if (binaryStr.charAt(i) == '1') result = result + pow2;
			pow2 = 2*pow2;
		}
		return result;
	}
	
	public static String decToBinary(int dec) {
		String result = "";
		while(dec != 0) {
			result = dec%2 + result;
			dec = dec/2;
		}
		return result;
	}
	
	public static String decToBinary(double dec, double eps) {
		String result = "";
		double pow2 = 0.5;
		while(pow2 > eps && dec > 1.e-16) {		
			result = result + (dec >= pow2 ? "1" : "0");
			if(dec >= pow2) dec = dec - pow2;
			pow2 = pow2/2.;
		}
		return result;	
	}
}
