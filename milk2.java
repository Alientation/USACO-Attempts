/*
ID: alienbob
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
	
	public static ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>(); 
	public static void main (String [] args) throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		//Scanner f = new Scanner(System.in);
		
		//int N = f.nextInt();
		int N = Integer.parseInt(f.readLine());
		for (int x = 0; x < N; x++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			String[] ints = f.readLine().split(" ");
			temp.add(Integer.parseInt(ints[0]));
			temp.add(Integer.parseInt(ints[1]));
			
			//temp.add(f.nextInt());
			//temp.add(f.nextInt());
			check(temp, false);
		}
		int maxTimeWith = 0;
		int maxTimeBetween = 0;
		
		for (int x = 0; x < al.size(); x++) {
			//System.out.println(al.get(x));
			if (al.get(x).get(1) - al.get(x).get(0) > maxTimeWith) {
				maxTimeWith = al.get(x).get(1) - al.get(x).get(0);
			}
			if (x != 0) {
				if (al.get(x).get(0) - al.get(x-1).get(1) > maxTimeBetween) {
					maxTimeBetween = al.get(x).get(0) - al.get(x-1).get(1);
				}
			}
			
		}
		//System.out.println(maxTimeWith + " " + maxTimeBetween);
		out.println(maxTimeWith + " " + maxTimeBetween);
		
		out.close();                                  // close the output file
	}
	public static void check(ArrayList<Integer> temp, boolean bool) {
		if (al.size() == 0) {
			al.add(temp);
		} else {
			int n1 = temp.get(0);
			int n2 = temp.get(1);
			for (int pos = 0; pos < al.size(); pos++) {
				if (n1 <= al.get(pos).get(0) && n2 >= al.get(pos).get(0)) {
					if (n1 != al.get(pos).get(0) || n2 != al.get(pos).get(1)) {
						al.get(pos).set(0,n1);
						if (n2 >= al.get(pos).get(1))
							al.get(pos).set(1, n2);
						check(al.get(pos), true);
					}
				} else if (n1 <= al.get(pos).get(1) && n2 >= al.get(pos).get(1)) {
					if (n2 != al.get(pos).get(1)) {
						al.get(pos).set(1,n2);
						check(al.get(pos), true);
					}
				} else if (pos == 0 && n2 < al.get(pos).get(0) && !bool) {
					al.add(pos, temp);
				} else if (n1 > al.get(pos).get(1) && !bool) {
					if (pos == al.size()-1)
						al.add(temp);
					else if (n2 < al.get(pos+1).get(0))
						al.add(pos+1,temp);
				}
			}
		}
	}
  
}