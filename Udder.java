import java.util.Scanner;

public class Udder {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		String alphabet = console.nextLine();
		char[] chars = console.nextLine().toCharArray();
		int pos = 0;
		int numTimes = 1;
		for (int x = 0; x < chars.length; x++) {
			if (alphabet.indexOf(chars[x]) <= pos) {
				numTimes++;
			}
			pos = alphabet.indexOf(chars[x]);
		}
		System.out.println(numTimes);
	}
}
