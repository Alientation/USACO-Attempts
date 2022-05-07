import java.util.Scanner;

public class DanceMooves {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numCows = console.nextInt();
		int numPairs = console.nextInt();
		int[][] pairs = new int[numPairs][2];
		for (int x = 0; x < numPairs; x++) {
			pairs[x][0] = console.nextInt();
			pairs[x][1] = console.nextInt();
		}
		for (int x = 0; x < numCows; x++) {
			boolean[][] bools = new boolean[numPairs][2];
			boolean[] boolnums = new boolean[numCows];
			System.out.println(traverse(pairs, bools, x+1, -1,boolnums));
		}
		
	}
	
	public static int traverse(int[][] pairs, boolean[][] bools, int num, int loc, boolean[] boolnums) {
		for (int x = loc+1; ;x++) {
			if (loc == -1 && x == pairs.length) {
				return 1;
			}
			if (x == pairs.length)
				x = 0;
			if (pairs[x][0] == num) {
				if (bools[x][0] == true) {
					return 0;
				}
				bools[x][0] = true;
				int sum = 0;
				if (!boolnums[num]) {
					sum = 1;
					boolnums[num] = true;
				}
				if (!bools[x][1])
					return sum + traverse(pairs, bools, pairs[x][1], x,boolnums);
				else
					return traverse(pairs, bools, pairs[x][1], x, boolnums);
			} else if (pairs[x][1] == num) {
				if (bools[x][1] == true) {
					return 0;
				}
				bools[x][1] = true;
				int sum = 0;
				if (!boolnums[num]) {
					sum = 1;
					boolnums[num] = true;
				}
				if (!bools[x][0])
					return sum + traverse(pairs, bools, pairs[x][0], x,boolnums);
				else
					return traverse(pairs, bools, pairs[x][0], x, boolnums);
			}
		}
	}
}
