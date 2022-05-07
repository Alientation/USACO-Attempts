/*
ID: alienbob
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    //StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    
    
    String comet = f.readLine();
    String group = f.readLine();
    int cometTotal = 1;
    int groupTotal = 1;
    for (char c : comet.toCharArray()) {
    	cometTotal *= (int) c - 64;
    }
    for (char c : group.toCharArray()) {
    	groupTotal *= (int) c - 64;
    }
    
    if (cometTotal % 47 == groupTotal % 47) {
    	out.println("GO");
    } else {
    	out.println("STAY");
    }
    
    /*
    int i1 = Integer.parseInt(st.nextToken());    // first integer
    int i2 = Integer.parseInt(st.nextToken());    // second integer
    out.println(i1+i2);                           // output result
    */
    out.close();                                  // close the output file
  }
}