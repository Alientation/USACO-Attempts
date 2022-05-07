import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class RedGift {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		
		LinkedList<LinkedList<Integer>> cows = new LinkedList<>();
		boolean[][] taken = new boolean[n][n + 1];
		int[] choice = new int[n];
		for (int i = 0; i < n; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			int[] temp = new int[n];
			for (int ii = 0; ii < n; ii++) {
				temp[ii] = console.nextInt();
			}
			
			for (int ii = 0; ii < n; ii++) {
				list.add(temp[ii]);
				if (temp[ii] == i + 1) {
					taken[ii][temp[ii]] = true;
					choice[i] = temp[ii];
					break;
				}
			}
			cows.add(list);
		}
		
		Collections.sort(cows,new Comparator<LinkedList<Integer>>() {
			@Override
			public int compare(LinkedList<Integer> arg0, LinkedList<Integer> arg1) {
				return arg0.size() - arg1.size();
			}
		});
		int cur = 0;
		while (cows.size() != 0) {
			for (int i = 0; i < cows.get(0).size(); i++) {
				if (taken[i][cows.get(0).get(i)]) continue;
				
				choice[cur] = cows.get(0).get(i);
				break;
			}
			cows.remove(0);
			cur++;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(choice[i]);
		}
	}
}
