/*
ID: alienbob
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

class milk {
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numMilk = Integer.parseInt(st.nextToken());
		int numFarmers = Integer.parseInt(st.nextToken());
		int[][] costs = new int[numFarmers][2];
		for (int x = 0; x < numFarmers; x++) {
			st = new StringTokenizer(f.readLine());
			costs[x][0] = Integer.parseInt(st.nextToken());
			costs[x][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(costs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
		int moneySpent = 0;
		int pos = 0;
		while (numMilk > 0) {
			if (numMilk > costs[pos][1]) {
				moneySpent += costs[pos][1] * costs[pos][0];
				numMilk -= costs[pos][1];
			} else {
				moneySpent += numMilk * costs[pos][0];
				numMilk = 0;
			}
			pos++;
		}
		out.println(moneySpent);
		out.close();
	}
}