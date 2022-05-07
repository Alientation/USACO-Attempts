/*
ID: alienbob
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

class dualpal {
	public static char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int count = 0;
		int num = S + 1;
		while (count < N) {
			int c = 0;
			for (int x = 2; x <= 10; x++) {
				if (isPalindrome(convertBase10(x,num))) {
					c++;
					if (c >= 2) {
						out.println(num);
						count++;
						break;
					}
				}
			}
			num++;
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
		if (nn.length() == 0 || nn.charAt(0) =='0' || nn.charAt(nn.length()-1) == '0')
			return false;
		for (int x = 0; x < nn.length()/2; x++) {
			if (nn.charAt(x) != nn.charAt(nn.length()-1-x)) {
				return false;
			}
		}
		return true;
	}
}