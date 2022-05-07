/*
ID: alienbob
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

class namenum {
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader ff = new BufferedReader(new FileReader("dict.txt"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		//StringTokenizer st = new StringTokenizer(f.readLine());
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		hm.put('A', 2);
		hm.put('B', 2);
		hm.put('C', 2);
		hm.put('D', 3);
		hm.put('E', 3);
		hm.put('F', 3);
		hm.put('G', 4);
		hm.put('H', 4);
		hm.put('I', 4);
		hm.put('J', 5);
		hm.put('K', 5);
		hm.put('L', 5);
		hm.put('M', 6);
		hm.put('N', 6);
		hm.put('O', 6);
		hm.put('P', 7);
		hm.put('R', 7);
		hm.put('S', 7);
		hm.put('T', 8);
		hm.put('U', 8);
		hm.put('V', 8);
		hm.put('W', 9);
		hm.put('X', 9);
		hm.put('Y', 9);
		
		ArrayList<String> al = new ArrayList<String>();
		String line = "";
		while ((line = ff.readLine()) != null) {
			if (line.isEmpty()) {
				continue;
			}
			al.add(line.trim());
		}
		System.out.println(al.get(0));
		int count = 0;
		line = f.readLine().trim();
		for (String s : al) {
			String t = "";
			for (char c : s.toCharArray()) {
				t = t + hm.get(c);
			}
			if (line.equals(t)) {
				count++;
				out.println(s);
			}
		}
		if (count == 0) {
			out.println("NONE");
		}
		out.close();
	}
}