/*
ID: alienbob
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    //StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    
    int NP = Integer.parseInt(f.readLine());
    HashMap<String,Integer> hm = new HashMap<String,Integer>();
    ArrayList<String> al = new ArrayList<String>();
    for (int x = 0; x < NP; x++) {
    	String p = f.readLine();
    	hm.put(p, 0);
    	al.add(p);
    }
    
    for (int x = 0; x < NP; x++) {
    	String person = f.readLine();
    	StringTokenizer st = new StringTokenizer(f.readLine());
    	int amountMoney = Integer.parseInt(st.nextToken());
    	int numPeople = Integer.parseInt(st.nextToken());
    	if (numPeople == 0 ) {
    		continue;
    	}
    	for (int y = 0; y < numPeople; y++) {
    		String p = f.readLine();
    		hm.replace(p, hm.get(p) + amountMoney/numPeople);
    	}
    	hm.replace(person, hm.get(person) + amountMoney % numPeople - amountMoney);
    }
    
    for (int x = 0; x < NP; x++) {
    	out.println(al.get(x) + " " + hm.get(al.get(x)));
    }
    
    
    /*
    int i1 = Integer.parseInt(st.nextToken());    // first integer
    int i2 = Integer.parseInt(st.nextToken());    // second integer
    out.println(i1+i2);                           // output result
    */
    
    
    out.close();                                  // close the output file
  }
}