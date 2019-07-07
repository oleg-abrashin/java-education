
public class Test {
	public static void main(String[] args) {
		
		double val = 7.5;
		double exponent = 3.875;
		double eps = 1.e-15;
		
		System.out.println(myPow(val, exponent, eps));
		System.out.println(Math.pow(val, exponent));
	}
	
	public static double mySqrt(double val, double eps) {
		double x = 1;
		for (; x*x < val; x = x+1.) {}
		if (x*x == val) return x;
		
		double xn = 0.;
		while (true) {
			xn = x - (x*x - val)/2./x;
			if (x -xn < eps) break;
			x = xn;
		}
		return xn;
	}
	
	public static double pow01(double base, double exponent, double eps) {
		
		double result = 1;
		double powHalf = 0.5;
		
		while (powHalf >= eps) {
			
			base = mySqrt(base, eps);
			if (exponent > powHalf) {
				exponent = exponent - powHalf;
				result = result*base;
			}
			powHalf = powHalf/2.;
		}
		
		return result;
	}
	
	public static double powInt(double base, int e) {
		
		double result = 1.;
		for (int i=0; i < e; i++)result = result*base;
		return result;
	}
	
	public static double myPow(double x, double y, double eps) {
		
		boolean sign = y < 0;
		if (sign) y = -y;
		
		int integerY = (int)y;
		double res = powInt(x,integerY)*pow01(x, y-integerY, eps);
		
		return sign ? 1/res : res;
		
	}
}
