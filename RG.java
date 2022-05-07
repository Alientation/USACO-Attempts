import java.util.HashMap;
import java.util.Scanner;

public class RG {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		HashMap<Integer,Integer>[] rows = new HashMap[n];
		int[][] cows = new int[n][n];
		for (int y = 0; y < n; y++) {
			HashMap<Integer,Integer> temp = new HashMap<>();
			for (int x = 0; x < n; x++) {
				cows[y][x] = console.nextInt();
				temp.put(cows[y][x],x);
			}
			rows[y] = temp;
		}
		
		int[] choice = new int[n];
		boolean[] pinned = new boolean[n];
		for (int y = 0; y < n; y++) {
			if (cows[y][0] == y + 1) {
				choice[y] = cows[y][0];
				pinned[y] = true;
			} else {
				int locPrevChoice = rows[y].get(y + 1);
				boolean bool = false;
				for (int t = 0; t < n; t++) {
					if (rows[t].get(y + 1) < locPrevChoice && rows[t].get(y + 1) < rows[t].get(t+1)) {
						bool = true;
						break;
					}
				}
				if (!bool) {
					choice[y] = cows[y][locPrevChoice];
					pinned[y] = true;
				}
			}
		}
		
		for (int y = 0; y < n; y++) {
			if (choice[y] != 0) continue;
			
			for (int x = 0; x <= rows[y].get(y+1);x++) {
				if (!pinned[cows[y][x]-1]) {
					choice[y] = cows[y][x];
					break;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(choice[i]);
		}
		console.close();
	}
}

