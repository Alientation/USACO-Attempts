/*
ID: your_id_here
LANG: JAVA
TASK: sleepy
*/
import java.io.*;
import java.util.*;
public class WordProcessor {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("word.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
		int count = 0;
		int num = sc.nextInt();
		int maxLetters = sc.nextInt();
		for (int x = 0; x < num; x++) {
			String str = sc.next();
			if (count + str.length() > maxLetters) {
				count = str.length();
				out.print("\n" + str);
			} else {
				if (count != 0)
					out.print(" ");
				count+=str.length();
				out.print(str);
			}
		}
		out.close();
	}
}
