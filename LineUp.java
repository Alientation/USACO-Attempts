/*
ID: your_id_here
LANG: JAVA
TASK: sleepy
*/
import java.io.*;
import java.util.*;
public class LineUp {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("lineup.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		
		
		//Beatrice Belinda Bella Bessie Betsy Blue Buttercup Sue
		ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
		
		
		ArrayList<String> cows = new ArrayList<String>();
		cows.add("Beatrice");
		cows.add("Belinda");
		cows.add("Bella");
		cows.add("Bessie");
		cows.add("Betsy");
		cows.add("Blue");
		cows.add("Buttercup");
		cows.add("Sue");
		al.add(cows);
		
		//Belinda Bessie Betsy
		//Blue Bella Buttercup
		//Beatrice Sue
		
		int numRules = sc.nextInt();
		for (int x = 0; x < numRules; x++) {
			
			
			
			
			
		}
		
		
		
		
		out.println();
		out.close();
	}
}