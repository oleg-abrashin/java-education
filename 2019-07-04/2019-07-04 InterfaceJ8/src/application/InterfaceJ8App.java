package application;

public class InterfaceJ8App {
	
	public static void main(String[] args) {
		/*User user = new User();
		user.drive();
		ICarDriver.work();
		IPrintDriver.work();*/
		
		System.out.println(solution(23456789,12345678));
		
	}
	
	public static int solution(int a, int b) {
		System.out.println(Integer.toBinaryString(a*b));
		int counter = 0;
		int subj = a*b;
		for (int i=0; i<32; i++) {
			if ((subj & 1<<i)>0)counter++;
		}
		return counter;
	}
}
