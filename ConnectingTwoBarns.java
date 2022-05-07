
import java.util.*;
public class ConnectingTwoBarns {
	public static int minimum = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int T = console.nextInt();
		for (int i = 0; i < T; i++) {
			int N = console.nextInt();
			int M = console.nextInt();
			boolean[][] matrix = new boolean[N][N];
			boolean[] visited = new boolean[N];
			boolean[] reachesFinal = new boolean[N];
			boolean[] starts = new boolean[N];
			starts[0] = true;
			reachesFinal[N-1] = true;
			visited[0] = true;
			int temp1, temp2;
			
			for (int ii = 0; ii < M; ii++) {
				temp1 = console.nextInt(); temp2 = console.nextInt();
				matrix[temp1-1][temp2-1] = true;
				matrix[temp2-1][temp1-1] = true;
			}
			recur2(N-1,reachesFinal,matrix);
			recur2(0,starts,matrix);
			recur(0,0,visited,matrix,0,reachesFinal,starts);
			System.out.println(minimum);
			minimum = Integer.MAX_VALUE;
		}		
	}

	public static void recur2(int loc, boolean[] reachesFinal, boolean[][] matrix) {
		for (int i = matrix.length-1; i >= 0; i--) {
			if (matrix[loc][i] == true && reachesFinal[i] == false) {
				reachesFinal[i] = true;
				recur2(i,reachesFinal,matrix);
			}
		}
	}

	public static void recur(int loc, int currentCost, boolean[] visited, boolean[][] matrix, int numPathsMade,boolean[] reachesFinal, boolean[] starts) {
		if (reachesFinal[loc]) {
			if (currentCost < minimum)
				minimum = currentCost;
			return;
		}
		for (int i = 0; i < matrix.length; i++) {
			if (currentCost >= minimum)
				return;
			if (matrix[loc][i] == true && visited[i] == false) {
				visited[i] = true;
				recur(i,currentCost,visited,matrix,numPathsMade, reachesFinal,starts);
				visited[i] = false;
			} else if (numPathsMade < 2 && visited[i] == false && starts[i] == false){
				visited[i] = true;
				recur(i,currentCost + (int)Math.pow(i - loc, 2),visited,matrix,numPathsMade+1,reachesFinal,starts);
				visited[i] = false;
			}
		}
	}
}
