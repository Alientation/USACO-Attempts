/*
ID: alienbob
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;

class barn1 {
	public static void main (String [] args) throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		/*
		Scanner console = new Scanner(System.in);
		int M = console.nextInt();
		int S = console.nextInt();
		int C = console.nextInt(); 
		*/
		int[] inputs = new int[C];
		for (int x = 0; x < C; x++) {
			inputs[x] = Integer.parseInt(f.readLine());
		}
		
		Arrays.sort(inputs);
		int[] distance = new int[C-1];
		int prev = inputs[0];
		//int prev = console.nextInt();
		int sum = prev-1;
		for (int x = 1; x < C; x++) {
			int temp = inputs[x];
			//int temp = console.nextInt();
			distance[x-1] = temp - prev - 1;
			prev = temp;
		}
		sum += S - prev;
		//System.out.println(Arrays.toString(distance));
		Arrays.sort(distance);
		int m = 0;
		for (int x = distance.length-1; x >= 0; x--) {
			if (m >= M - 1) {
				break;
			}
			//System.out.println(distance[x]);
			sum+=distance[x];
			m++;
		}
		out.println(S-sum);
		out.close();
		
		//System.out.println(S-sum);
	}
}