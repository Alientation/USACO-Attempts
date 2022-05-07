/*
ID: your_id_here
LANG: JAVA
TASK: sleepy
*/
import java.io.*;
import java.util.*;
public class Photoshoot {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("photo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		
		int num = sc.nextInt();
		int[] integers = new int[num-1];
		int[] orig = new int[num];
		for (int x = 0; x < num-1; x++) {
			integers[x] = sc.nextInt();
		}
		for (int x = 1; x < integers[0]; x++) {
			boolean bool = true;
			orig[0] = x;
			for (int y = 1; y < num; y++) {
				orig[y] = integers[y-1] - orig[y-1];
				if (orig[y] < 1 || orig[y] > num) {
					bool = false;
					break;
				}
			}
			if (!bool)
				continue;
			if (check(orig, num)) {
				break;
			}
		}
		
		for (int x = 0; x < orig.length; x++) {
			out.print(orig[x]);
			if (x != orig.length - 1) {
				out.print(" ");
			}
		}
		out.close();
	}
	
	public static boolean check(int[] orig, int num) {
		boolean[] bools = new boolean[num];
		for (int x = 0; x < orig.length; x++) {
			if (bools[orig[x]-1]) {
				return false;
			} else {
				bools[orig[x]-1] = true;
			}
		}
		return true;
	}
}
