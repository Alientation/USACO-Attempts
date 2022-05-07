import java.util.Scanner;

public class SpacedOut {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int width = console.nextInt();
		
		int[][] map = new int[width][width];
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < width; y++) {
				map[x][y] = console.nextInt();
			}
		}
		
		//column
		int sumCol = 0;
		for (int y = 0; y < width; y++) {
			int sum1 = 0;
			int sum2 = 0;
			for (int x = 0; x < width; x++) {
				if (x%2 == 0) {
					sum1 += map[x][y];
				} else {
					sum2 += map[x][y];
				}
			}
			sumCol += Math.max(sum1, sum2);
		}
		
		int sumRow = 0;
		
		for (int x = 0; x < width; x++) {
			int sum1 = 0;
			int sum2 = 0;
			for (int y = 0; y < width; y++) {
				if (y%2 == 0) {
					sum1 += map[x][y];
				} else {
					sum2 += map[x][y];
				}
			}
			sumRow += Math.max(sum1, sum2);
		}
		System.out.println(Math.max(sumRow, sumCol));
	}
}
/*

c c x x c
x x c c x
c c x x c
x x c c x
c c x x c

c x c x c
c x c x c
c x c x c
c x c x c
c x c x c


max beauty per row and column, add each individually and compare row total vs column total


*/