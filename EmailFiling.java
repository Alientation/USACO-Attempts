import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmailFiling {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numTests = console.nextInt();
		for (int j = 0; j < numTests; j++) {
			int M = console.nextInt();
			int N = console.nextInt();
			int K = console.nextInt();
			
			int[] counts = new int[M];
			
			List<Integer> emails = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int l = console.nextInt();
				counts[l-1]++;
				emails.add(l);
			}
			
			int currentEmailLocation = 0;
			int currentFolderLocation = 0;
			
			while (emails.size() != 0) {
				
				boolean bool = false;
				for (int i = 0; i < K && i + currentEmailLocation < emails.size(); i++) {
					if (emails.get(i + currentEmailLocation) - currentFolderLocation - 1 < K) {//can move folder
						//System.out.println(emails.get(i + currentEmailLocation) + " moved");
						counts[emails.get(i + currentEmailLocation) - 1]--;
						emails.remove(i + currentEmailLocation);
						currentEmailLocation = Math.max(Math.min(currentEmailLocation,emails.size() - K),0); //shift folders up if more can be viewed
						bool = true;
					}
				}
				if (!bool) {
					currentEmailLocation++;
					if (currentEmailLocation >= emails.size() - K + 1) { //out of bounds, therefore answer is NO
						break;
					}
				}
				
				while(currentFolderLocation < counts.length && counts[currentFolderLocation] == 0)
					currentFolderLocation++;
			}
			if (emails.size() == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		console.close();
	}
}