/*
ID: your_id_here
LANG: JAVA
TASK: sleepy
*/
import java.io.*;
import java.util.*;
public class MooBuzz {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("moobuzz.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
		int[] nums = {
				1,
				2,
				4,
				7,
				8,
				11,
				13,
				14
		};
		int num = sc.nextInt();
		out.println(nums[(num-1)%8] + (num/8) * 15);
		out.close();
	}
}
