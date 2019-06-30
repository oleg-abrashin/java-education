package application;

public class MultipleConcatenationApp {
	
	private static final int NUM_HELLOS = 100;

	public static void main(String[] args) {
		String hello = "hello";
		String result = "";
		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < NUM_HELLOS; i++) {
			result = result + hello;
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Concatenation:"+(t2-t1)+ " ms");
		
		t1 = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder("");
		for (int i = 0; i < NUM_HELLOS; i++) {
			stringBuilder.append(hello);
		}
		t2 = System.currentTimeMillis();
		System.out.println("StringBuilder:"+(t2-t1)+ " ms");
	}

}
