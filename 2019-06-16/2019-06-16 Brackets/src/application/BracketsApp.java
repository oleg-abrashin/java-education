package application;

public class BracketsApp {

	public static void main(String[] args) {
		System.out.println(areBracketsOk("(({{}}))()"));

	}
	
	public static boolean areBracketsOk(String str) {
		String buffer = "";
		int strLen = str.length();
		char c = 0;
		int bufferLen = 0;
		int bufferLen1 = 0;
		for (int i = 0; i < strLen; i++) {
			c = str.charAt(i);
			bufferLen = buffer.length();
			bufferLen1 = bufferLen - 1;
			if (c == '{' || c == '[' || c == '(')
				buffer = buffer + c;
			else if (c == '}') {
				if (bufferLen != 0  && buffer.charAt(bufferLen -1) == '{') 
					buffer = buffer.substring(0, bufferLen1);
				else return false;
			}
			else if (c == ']') {
				if (bufferLen != 0  && buffer.charAt(bufferLen -1) == '[') 
					buffer = buffer.substring(0, bufferLen1);
				else return false;
			}
			else if (c == ')') {
				if (bufferLen != 0  && buffer.charAt(bufferLen -1) == '(') 
					buffer = buffer.substring(0, bufferLen1);
				else return false;
			}
		}
		
		return buffer.length() == 0;
	}

}
