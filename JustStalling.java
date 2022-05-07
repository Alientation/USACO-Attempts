import java.util.Arrays;
import java.util.Scanner;

public class JustStalling {
	public static void main (String[] args) {
		Scanner console = new Scanner(System.in);
		int num = console.nextInt();
		int[] cow = new int[num];
		int[] stalls = new int[num];
		for (int x = 0; x < num; x++) {
			cow[x] = console.nextInt();
		}
		
		for (int x = 0; x < num; x++) {
			stalls[x] = console.nextInt();
		}
		
		Arrays.sort(cow);
		Arrays.sort(stalls);
		int[] tot = new int[num];
		long sum = 1;
		for (int x = cow.length-1; x >= 0; x--) {
			int number =0;
			for (int y = cow.length-1; y >= 0; y--) {
				if (cow[x] <= stalls[y])
					number++;
			}
			tot[x] = number;
		}
		
		int count = 0;
		for (int x = tot.length-1; x >= 0; x--) {
			sum *= tot[x] - count;
			count++;
		}
		System.out.println(sum);
	}
}
