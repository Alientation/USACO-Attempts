import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Paint {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int fenceLength = console.nextInt();
		int numCandidates = console.nextInt();
		console.nextLine();
		int[] desired = new int[fenceLength];
		boolean[] count = new boolean[26];
		int p = 0;
		for (char c : console.nextLine().toCharArray()) {
			desired[p] = (int) c - 64;
			count[desired[p]-1] = true;
			p++;
		}
		
		int[] strokes = new int[fenceLength];
		int pos = 0;
		int countStrokes = 0;
		for (;;) {
			int lowest = 27;
			for (int x = 0; x < count.length; x++) {
				if (count[x] == true) {
					lowest = x+1;
					break;
				}
			}
			if (lowest == 27)
				break;
			//System.out.println("Character " + lowest);
			boolean bool = true;
			
			int x1 = -1;
			int x2 = -1;
			for (int x = pos; x < fenceLength; x++) {
				if (desired[x] >= lowest) {
					if (lowest == desired[x]) {
						if (x1 == -1) {
							x1 = x;
						}
						x2 = x;
						if (bool)
							pos++;
					} else {
						bool = false;
					}
					
				} else {
					if ((x1 != -1 && x2 != -1)) {
						//System.out.println("+1 Stroke (" + (1+x1) + " - " + (x2+1) + ")");
						countStrokes++;
						for (int xx = x1; xx <= x2; xx++) {
							strokes[xx] = countStrokes;
						}
						x1 = -1;
						x2 = -1;
					}
				}
			}
			if ((x1 != -1 && x2 != -1)) {
				//System.out.println("+1 Stroke (" + (1+x1) + " - " + (x2+1) + ")");
				countStrokes++;
				for (int xx = x1; xx <= x2; xx++) {
					strokes[xx] = countStrokes;
				}
			}
			count[lowest-1] = false;
		}
		
		//System.out.println(Arrays.toString(strokes));
		int[] indexSum = new int[strokes.length + 1];
		int[] revSum = new int[strokes.length + 1];
		HashMap<Integer,Boolean> distinct = new HashMap<Integer,Boolean>(); 
		for (int x = 0; x < strokes.length; x++) {
			if (!distinct.containsKey(strokes[x])) {
				distinct.put(strokes[x], true);
				indexSum[x+1] = indexSum[x] + 1;
			} else {
				indexSum[x+1] = indexSum[x];
			}
		}
		
		HashMap<Integer,Boolean> distinct1 = new HashMap<Integer,Boolean>(); 
		for (int x = strokes.length-1; x >= 0; x--) {
			if (!distinct1.containsKey(strokes[x])) {
				distinct1.put(strokes[x], true);
				revSum[x] = revSum[x+1] + 1;
			} else {
				revSum[x] = revSum[x+1];
			}
		}
		
		
		
		
		
		
		//System.out.println(Arrays.toString(indexSum));
		//System.out.println(Arrays.toString(revSum));
		for (int x = 0; x < numCandidates; x++) {
			int a = console.nextInt();
			int b = console.nextInt();
			int sum = 0;
			
			sum += indexSum[a-1];
			sum += revSum[b];
			
			System.out.println(sum);
		}
	}
}
/*
ABBAABCB
AAAAA---
ABBAA---
ABBAABBB
ABBAABCB
12211343

3 - 6
ABxxxxCB
12xxxx32
12xxxx43
4

1 - 4
xxxxABCB
xxxx1343
3

*/