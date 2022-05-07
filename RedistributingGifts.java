
import java.util.Scanner;

public class RedistributingGifts {
	static int maxScore = 0;
	static int[] choice;
	static int[] original;
	static int[][] cowPref;
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		choice = new int[n];
		original = new int[n];
		cowPref = new int[n][n];
		int[] cowChoice = new int[n];
		boolean[] taken = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int ii = 0; ii < n; ii++) {
				cowPref[i][ii] = console.nextInt();
				if (cowPref[i][ii] == i + 1) {
					original[i] = ii;
					if (ii == 0) {
						taken[i] = true;
						choice[i] = cowPref[i][ii];
					}
				}
			}
		}
		
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (x <= original[y] && choice[y] == 0 && !taken[x]) {
					choice[y] = cowPref[y][x];
				}
			}
		}
		
		//recur(cowChoice,0,taken,0);
		for (int i = 0; i < n; i++) {
			System.out.println(choice[i]);
		}
		console.close();
	}
	
	/*
	public static void recur(int[] cowChoice, int cur, boolean[] taken, int score) {
		if (cur == original.length) {
			if (score > maxScore) {
				maxScore = score;
				for (int i = 0; i < cur; i++) {
					choice[i] = cowChoice[i];
				}
			}
			return;
		}
		for (int i = 0; i <= original[cur]; i++) {
			if (taken[cowPref[cur][i] - 1])
				continue;
			taken[cowPref[cur][i] - 1] = true;
			cowChoice[cur] = cowPref[cur][i];
			recur(cowChoice,cur+1,taken,score + original[cur] - i);
			taken[cowPref[cur][i] - 1] = false;
		}
	*/
}
