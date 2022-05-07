/*
ID: alienbob
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    //StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    
    int N = Integer.parseInt(f.readLine());
    int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] counts = new int[7];
    int prevDay = 5;
    int prevMonth = 11;
    for (int year = 1900; year <= 1900 + N - 1; year++) {
    	if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
    		months[1]++;
    	}
    	for (int month = 0; month <= 11; month++) {
    		int addDays = months[prevMonth];
    		prevDay = (prevDay + addDays) % 7;
    		counts[prevDay]++;
    		prevMonth = month;
    	}
    	if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
    		months[1]--;
    	}
    }
    
    out.println(counts[1] + " " + counts[2] + " " + counts[3] + " " + counts[4] + " " + counts[5] + " " + counts[6] + " " + counts[0]);
    
    
    out.close();                                  // close the output file
  }
}

//01, 02, 03, 04, 05, 06, 07
//08, 09, 10, 11, 12, 13