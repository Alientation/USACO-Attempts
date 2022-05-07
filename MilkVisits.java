/*
ID: your_id_here
LANG: JAVA
TASK: sleepy
*/
import java.io.*;
import java.util.*;
public class MilkVisits {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("milkvisits.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[] milkTypes = sc.next().toCharArray();
		
		int[][] pairs = new int[n-1][2];
		for (int x = 0; x < n-1; x++) {
			pairs[x][0] = sc.nextInt();
			pairs[x][1] = sc.nextInt();
		}
		String str = "";
		for (int x = 0; x < m; x++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			char neededMilk = sc.next().toCharArray()[0];
			if (traverse(pairs, milkTypes, neededMilk, start, end, -1, 0, 0) == 1) {
				str = str + "1";
			} else {
				str = str + "0";
			}
		}
		
		out.println(str);
		out.close();
	}
	
	public static int traverse(int[][] pairs, char[] milkTypes, char neededMilk, int start, int end, int prev, int countH, int countG) {
		if (milkTypes[start-1] == 'G') {
			countG++;
		} else {
			countH++;
		}
		if (end == start) {
			if ((neededMilk == 'G' && countG != 0) || (neededMilk == 'H' && countH != 0)) {
				return 1;
			}
			return 0;
		}
		for (int x = 0; x < pairs.length; x++) {
			if (pairs[x][0] == start && pairs[x][1] != prev) {
				int num = traverse(pairs, milkTypes, neededMilk, pairs[x][1], end, start, countH, countG);
				if (num != -1)
					return num;
			}
			if (pairs[x][1] == start && pairs[x][0] != prev) {
				int num = traverse(pairs, milkTypes, neededMilk, pairs[x][0], end, start, countH, countG);
				if (num != -1)
					return num;
			}
		}
		return -1;
	}
	
}
