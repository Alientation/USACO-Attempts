
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ComfortableCows{
	static int count = 0;
	public static void main(String[] args) throws IOException {
		Scanner sc;
		sc = new Scanner(new File("2.in"));
		File file = new File("2.out");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		int n = sc.nextInt();
		
		//Scanner console = new Scanner(System.in);
		//int n = console.nextInt();
		int[][] newmap = new int[3000][3000];
		boolean[][] newboolmap = new boolean[3000][3000];
		for (int xx = 0; xx < n; xx++) {
			
			int[] temp = {sc.nextInt() + 1000, sc.nextInt() + 1000};
			if (newboolmap[temp[0]][temp[1]]) {
				count--;
			} else {
				count--;
				updateAdjacent(newmap, temp[0], temp[1], newboolmap);
			}
			out.println(count);
			System.out.println(count);
		}
		out.close();
	}
	
	public static int[] getEmptyAdjacent(boolean[][] boolmap, int x, int y) {
		int[] pos = new int[2];
		if (!boolmap[x-1][y]) {
			pos[0] = x-1;
			pos[1] = y;
		} else if (!boolmap[x+1][y]) {
			pos[0] = x+1;
			pos[1] = y;
		} else if (!boolmap[x][y-1]) {
			pos[0] = x;
			pos[1] = y-1;
		} else if (!boolmap[x][y+1]){
			pos[0] = x;
			pos[1] = y+1;
		}
		return pos;
	}
	
	public static void updateAdjacent(int[][] map, int x, int y, boolean[][] boolmap) {
		count++;
		map[x-1][y]++;
		map[x+1][y]++;
		map[x][y-1]++;
		map[x][y+1]++;
		boolmap[x][y] = true;
		if (boolmap[x-1][y] && map[x-1][y] == 3) {
			int[] empty = getEmptyAdjacent(boolmap, x-1, y);
			updateAdjacent(map, empty[0], empty[1], boolmap);
		}
		
		if (boolmap[x+1][y] && map[x+1][y] == 3) {
			int[] empty = getEmptyAdjacent(boolmap, x+1, y);
			updateAdjacent(map, empty[0], empty[1], boolmap);
		}
		
		if (boolmap[x][y+1] && map[x][y+1] == 3) {
			int[] empty = getEmptyAdjacent(boolmap, x, y+1);
			updateAdjacent(map, empty[0], empty[1], boolmap);
		}
		
		if (boolmap[x][y-1] && map[x][y-1] == 3) {
			int[] empty = getEmptyAdjacent(boolmap, x, y-1);
			updateAdjacent(map, empty[0], empty[1], boolmap);
		}
		
	}
}
