import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SocialDistancing{
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("socdist.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
		//Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();     //num of cows
		int m = sc.nextInt();     //grass ranges
		long[][] array = new long[m][2];
		for (int x = 0; x < m; x++) {
			array[x][0] = sc.nextLong();
			array[x][1] = sc.nextLong();
		}
		Arrays.sort(array, new Comparator<long[]>() {

			@Override
			public int compare(long[] arg0, long[] arg1) {
				if (arg0[0] > arg1[0]) {
					return 1;
				} else
					return -1;
			}
		});
		long max = array[array.length-1][1];
		long lowD = 1;
		long maxD = 1 + (max + 1) / n;
		long mid = 1 + (maxD + lowD)/2;
		boolean foundD = false;
		while (!foundD && mid != 1) {
			//StringBuilder sb = new StringBuilder("");
			mid = 1 + (maxD + lowD)/2;
			if (mid == maxD) {
				break;
			}
			int cows = n;
			long prev = 0 - mid;
			for (int x = 0; x < m; x++) {
				
				long sub = array[x][0];
				
				if (array[x][0] < prev + mid) {
					sub = prev + mid;
				}
				if (sub > array[x][1])
					continue;
				long num = 1 + (array[x][1] - sub + 1)/ mid;
				//sb.append(num + " : " + prev + " : " + array[x][0] + ", " + array[x][1] + "\n");
				prev = sub + (num-1) * mid;
				cows -= num;
				if (cows <= 0) {
					lowD = mid;
					//System.out.println(sb.toString());
					break;
				}
			}
			if (cows > 0) {
				maxD = mid;
			}
		}
		//System.out.println(maxD + " , " + mmmaaaxxD);
		out.println(mid);
		out.close();
	}
}
