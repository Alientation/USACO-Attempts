
import java.util.*;

public class ClosestCowWins {
	
	public static long largest = Long.MIN_VALUE;
	public static long[][] farm;
	public static long[] enemies;
	public static int K,M,N;
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		K = console.nextInt(); //number of grass patches
		M = console.nextInt(); //number cows already placed by enemy
		N = console.nextInt(); //number cows farmer john has to place
		
		farm = new long[K][2];
		enemies = new long[M];
		
		for (int i = 0; i < K; i++) {
			farm[i][0] = console.nextInt(); //pos
			farm[i][1] = console.nextInt(); //tastiness
		}
		for (int i = 0; i < M; i++) {
			enemies[i] = console.nextInt();
		}
		Arrays.sort(enemies);
		
		Arrays.sort(farm,new Comparator<long[]>() {
			@Override
			public int compare(final long[] n1, final long[] n2) {
				return ((Long)n1[0]).compareTo(n2[0]);
			}
		});
		
		long[] distances = new long[farm.length]; //how close is the nearest enemy
		long[] positions = new long[farm.length];
		int enemyCow = 0;
		long distance;
		for (int grassPos = 0; grassPos < distances.length; grassPos++) {
			positions[grassPos] = farm[grassPos][0];
			distance = Math.abs(enemies[enemyCow] - farm[grassPos][0]);
			while(enemyCow + 1 < enemies.length && Math.abs(enemies[enemyCow+1] - farm[grassPos][0]) <= distance) {
				enemyCow++;
				distance = Math.abs(enemies[enemyCow] - farm[grassPos][0]);
			}
			distances[grassPos] = distance;
		}
		System.out.println(Arrays.toString(positions));
		System.out.println(Arrays.toString(distances));
	}
}