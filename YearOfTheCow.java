
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class YearOfTheCow {
	public static void main() {
		Scanner console = new Scanner(System.in);
		int N = console.nextInt();
		int K = console.nextInt();
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(0);
		for (int x = 0; x < N; x++) {
			al.add(console.nextInt());
		}
		Collections.sort(al);
		
		int[][] minmax = new int[K][2];
		int pos = 0;
		for (int x = 0; x < N; x++) {
			if (al.get(x) < pos) {
				
			}
			
		}
		
		
		
		
		
		
		
		console.close();
	}
}
