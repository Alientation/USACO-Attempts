/*
ID: alienbob
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

class combo {
	static int N, numSolutions;
	static int johnCombo[] = new int[3];
	static int masterCombo[] = new int[3];
	
	public static void main(String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		johnCombo[0] = Integer.parseInt(st.nextToken());
		johnCombo[1] = Integer.parseInt(st.nextToken());
		johnCombo[2] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(f.readLine());
		masterCombo[0] = Integer.parseInt(st.nextToken());
		masterCombo[1] = Integer.parseInt(st.nextToken());
		masterCombo[2] = Integer.parseInt(st.nextToken());
		
		int ssss = 1;
		int mult = 0;
		
		if (Math.abs(masterCombo[0] - johnCombo[0]) <= Math.min(N, 5) - 1) {
			mult += Math.min(N, 5) - Math.abs(masterCombo[0] - johnCombo[0]);
		}
		if (Math.abs(masterCombo[0] + N - johnCombo[0]) <= Math.min(N, 5) - 1) { 
			mult += Math.min(N, 5) - Math.abs(masterCombo[0] + N - johnCombo[0]);
		}
		if (Math.abs(masterCombo[0] - N - johnCombo[0]) <= Math.min(N, 5) - 1) { 
			mult += Math.min(N, 5) - Math.abs(masterCombo[0] - N - johnCombo[0]);
		}
		ssss *= mult;
		mult = 0;
		
		if (Math.abs(masterCombo[1] - johnCombo[1]) <= Math.min(N, 5) - 1) {
			mult *= Math.min(N, 5) - Math.abs(masterCombo[1] - johnCombo[1]);
		}
		if (Math.abs(masterCombo[1] + N - johnCombo[1]) <= Math.min(N, 5) - 1) { 
			mult *= Math.min(N, 5) - Math.abs(masterCombo[1] + N - johnCombo[1]);
		}
		if (Math.abs(masterCombo[1] - N - johnCombo[1]) <= Math.min(N, 5) - 1) { 
			mult *= Math.min(N, 5) - Math.abs(masterCombo[1] - N - johnCombo[1]);
		}
		
		ssss *= mult;
		mult = 0;
		
		if (Math.abs(masterCombo[2] - johnCombo[2]) <= Math.min(N, 5) - 1) {
			mult *= Math.min(N, 5) - Math.abs(masterCombo[2] - johnCombo[2]);
		}
		if (Math.abs(masterCombo[2] + N - johnCombo[2]) <= Math.min(N, 5) - 1) { 
			mult *= Math.min(N, 5) - Math.abs(masterCombo[2] + N - johnCombo[2]);
		}
		if (Math.abs(masterCombo[2] - N - johnCombo[2]) <= Math.min(N, 5) - 1) { 
			mult *= Math.min(N, 5) - Math.abs(masterCombo[2] - N - johnCombo[2]);
		}
		ssss *= mult;
		mult = 0;
		
		numSolutions += 2 * Math.pow(N < 5 ? N : 5, 3) - ssss;
		
		
		out.println(numSolutions);
		out.close();
		
	}
	
}