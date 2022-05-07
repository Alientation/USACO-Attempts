/*
ID: alienbob
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    
    int N = Integer.parseInt(f.readLine());
    String str = f.readLine();
    str = str + str;
    char[] charArray = str.toCharArray();
    int maxLength = 0;
    
    ArrayList<Integer> al = new ArrayList<Integer>();
    ArrayList<Character> al2 = new ArrayList<Character>();
    al.add(0);
    al2.add(charArray[0]);
    
    for (char c : charArray) {
    	if (al2.get(al.size()-1) == c) {
    		al.set(al.size()-1, al.get(al.size()-1) + 1);
    	} else {
    		al2.add(c);
    		al.add(1);
    	}
    }
    if (al2.size() <= 2) {
    	out.println(str.length()/2);
    } else {
    	for (int x1 = 0; x1 < al.size(); x1++) {
    		char c = al2.get(x1);
    		if (c == 'w') {
    			if (x1 + 1 == al.size())
    				c = al2.get(0);
    			else
    				c = al2.get(x1+1);
    		}
    		int length = al.get(x1);
    		boolean bool = true;
    		for (int pos = x1+1; pos <= x1 || bool; pos++) {
    			if (pos == al.size()) {
    				bool = false;
    				pos = 0;
    			}
    			if (al2.get(pos) == c || al2.get(pos) == 'w') {
    				length += al.get(pos);
    			} else
    				break;
    		}
    		
    		char cc = ' ';
    		bool = true;
    		if (x1 == 0) {
    			cc = al2.get(al2.size()-1);
    			if (cc == 'w')
    				cc = al2.get(al2.size()-2);
    		} else {
    			cc = al2.get(x1-1);
    			if (cc == 'w') {
    				if (x1-2 == -1)
    					cc = al2.get(al.size()-1);
    				else
    					cc = al2.get(x1-2);
    			}
    		}
    		for (int pos = x1-1; pos > x1 || bool; pos-- ) {
    			if (pos == -1) {
    				bool = false;
    				pos = al.size()-1;
    			}
    			if (al2.get(pos) == cc || al2.get(pos) == 'w') {
    				length += al.get(pos);
    			} 	else
    				break;
    		}
    		if (length > maxLength) {
    			maxLength = length;
    		}
    	}
    	if (maxLength > str.length()/2) {
    		maxLength = str.length()/2;
    	}
    	out.println(maxLength);
    }
    out.close();                                  // close the output file
  }
}