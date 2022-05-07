/*
ID: your_id_here
LANG: JAVA
TASK: sleepy
*/
import java.io.*;
import java.util.*;
public class WhereAmI {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("whereami.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
		int numHouses = sc.nextInt();
		String str = sc.next();
		int leastInteger = numHouses;
		for (int length = numHouses - 1; length >= 1; length--) {
			boolean bool = true;
			for (int y = 0; y + length <= numHouses; y++) {
				if (str.indexOf(str.substring(y,y+length)) != str.lastIndexOf(str.substring(y,y+length))) {
					bool = false;
					break;
				}  else if (y + length == numHouses){
					leastInteger = length;
				}
			}
			if (!bool)
				break;
		}
		out.println(leastInteger);
		out.close();
	}
}
