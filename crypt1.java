/*
ID: alienbob
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;

class crypt1 {
	
	static int result1;
	static int result2;
	static int result3;
	static int numSolutions = 0;
	static int numDigits;
	static int[] digits;
	static int i;
	static HashMap<Integer,Boolean> hs = new HashMap<Integer,Boolean>();
	static int a, b, c, d, e;
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		numDigits = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		digits = new int[numDigits];
		for (i = 0; i < numDigits; i++) {
			digits[i] = Integer.parseInt(st.nextToken());
			hs.put(digits[i], false);
		}
		Arrays.sort(digits);
		//5 nested for loops, one for each potential digit in the multiplication. early exit when the resulting has more digits than what is allowed
		
		for (a = 0; a < numDigits; a++) {
			for (b = 0; b < numDigits; b++) {
				for (c = 0; c < numDigits; c++) {
					for (d = 0; d < numDigits; d++) {
						for (e = 0; e < numDigits; e++) {
							result1 = (digits[a] * 100 + digits[b] * 10 + digits[c]) * digits[e];
							if (result1 > 999) {
								break;
							}
							if (!validDigits(result1)) {
								continue;
							}
							
							result2 = (digits[a] * 100 + digits[b] * 10 + digits[c]) * digits[d];
							if (result2 > 999) {
								break;
							}
							if (!validDigits(result2)) {
								continue;
							}
							result3 = result1 + result2 * 10;
							if (result3 > 9999) {
								break;
							}
							if (validDigits(result3)) {
								numSolutions++;
							}
						}
					}
				}
			}
		}
		
		out.println(numSolutions);
		out.close();
	}
	
	public static boolean validDigits(int num) {
		while (num > 0) {
			if (hs.getOrDefault(num % 10,true)) {
				return false;
			}
			num /= 10;
		}
		return true;
	}
}