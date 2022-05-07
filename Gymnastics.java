/*
ID: your_id_here
LANG: JAVA
TASK: sleepy
*/
import java.io.*;
import java.util.*;
public class Gymnastics {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("gymnastics.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		int numSessions = sc.nextInt();
		int numCows = sc.nextInt();
		
		int[][] array = new int[numSessions][numCows];
		
		for (int x = 0; x < numSessions; x++) {
			for (int y = 0; y < numCows; y++) {
				array[x][y] = sc.nextInt();
			}
		}
		int count = 0;
		for (int x = 0; x < numCows-1; x++) {
			for (int y = x+1; y < numCows; y++) {
				boolean bool = true;
				for (int z = 1; z < numSessions; z++) {
					if (posOfElement(array[0][x],array[z]) > posOfElement(array[0][y],array[z])) {
						bool = false;
						break;
					}
				}
				if (bool) {
					count++;
				}
			}
		}
		out.println(count);
		out.close();
	}
	
	public static int posOfElement(int num, int[] array) {
		for (int x = 0; x < array.length; x++) {
			if (array[x] == num)
				return x;
		}
		return -1;
	}
}
