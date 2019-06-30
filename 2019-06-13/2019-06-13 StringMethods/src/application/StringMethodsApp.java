package application;

import java.util.Arrays;

public class StringMethodsApp {
	public static void main(String[] args) {
		/*
		String data = "\n    \t  Vasia \t   ";
		System.out.println(data.length());
		data = data.trim().toUpperCase();
		System.out.println(data.length());
		*/
		System.out.println(reverse("Masha is a good girl"));
		
		String str = "abracadabra";
		/*System.out.println(str.replace('a', 'e'));
		System.out.println(str.replace("aBra", "unhu"));
		
		String nine = "9";
		String eightyNine = "89";
		System.out.println(nine.compareTo(eightyNine));*/
		System.out.println(
				Arrays.toString(getOccurances(str, "z")));
	}
	
	public static boolean myEquals(String str1, String str2) {
		int l1 = str1.length();
		if (l1 != str2.length()) return false;
		
		for(int i = 0; i < l1; i++) {
			if (str1.charAt(i) != str2.charAt(i)) return false;
		}
		
		return true;
	}
	
	public static String reverse(String str) {
		String result = "";
		int sLen = str.length();
		for (int i = 0; i<sLen; i++)result = str.charAt(i)+result;
		return result;
	}
	
	public static String toTitlecase(String str) {
		return str.substring(0, 1).toUpperCase() + 
				str.substring(1).toLowerCase();
	}
	
	public static int compare (String str1, String str2) {
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		int len = len1 > len2 ? len2 : len1;
		
		int diff = 0;
		for (int i = 0; i < len; i++) {
			diff = str1.charAt(i) - str2.charAt(i);
			if (diff != 0)return diff;
		}
		
		return len1 - len2;
	}
	
	public static int countOccurances(String orig, String pattern) {
		int counter = 0;
		int from = 0;
		int res = 0;
		while(true) {
			res = orig.indexOf(pattern, from);
			if (res >= 0) {
				counter++;
				from = res+1;
			}
			else break;
		}
		return counter;
	}
	
	public static int[] getOccurances(String orig, String pattern) {
		int counted = countOccurances(orig, pattern);
		int[] result = new int[counted];
		if (counted == 0) return result;
		
		int counter = 0;
		int from = 0;
		int res = 0;
		while(true) {
			res = orig.indexOf(pattern, from);
			if (res >= 0) {
				result[counter] = res;
				counter++;
				from = res+1;
			}
			else break;
		}
		
		return result;
	}
}
