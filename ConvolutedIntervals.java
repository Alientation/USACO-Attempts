
import java.util.*;
public class ConvolutedIntervals {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		int N = console.nextInt();
		int M = console.nextInt();
		int[][] intervals = new int[N][2];
		for (int i = 0; i < N; i++) {
			intervals[i][0] = console.nextInt();
			intervals[i][1] = console.nextInt();
		}
		
		long[] res = new long[M * 2 + 1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < res.length; k++) {
					if (intervals[i][0] + intervals[j][0] <= k && intervals[i][1] + intervals[j][1] >= k)
						res[k]++;
				}
			}
		}
		for (long l : res)
			System.out.println(l);
		
		console.close();
	}
	
}
