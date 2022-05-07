/*
ID: alienbob
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

class palsquare {
	public static char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		
		int b = Integer.parseInt(f.readLine());
		for (int i = 1; i <= 300; i++) {
			if (isPalindrome(convertBase10(b,i * i))) {
				out.println(convertBase10(b,i) + " " + convertBase10(b,i * i));
			}
			
		}
		out.close();
	}
	
	public static String convertBase10(int b, int n) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		while (n != 0) {
			int rem = n % b;
			al.add(rem);
			n = n / b;
		}
		String str = "";
		for (int x = al.size()-1; x != -1; x--) {
			str = str + chars[al.get(x)];
		}
		return str;
	}
	
	public static boolean isPalindrome(String nn) {
		for (int x = 0; x < nn.length()/2; x++) {
			if (nn.charAt(x) != nn.charAt(nn.length()-1-x)) {
				return false;
			}
		}
		return true;
	}
}