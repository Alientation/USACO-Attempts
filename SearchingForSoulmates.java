import java.util.*;
public class SearchingForSoulmates {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		for (int i = console.nextInt(); i > 0; i--) {
			System.out.println(countMoves(console.nextLong(),console.nextLong()));
		}
		console.close();
	}
	
	public static long countMoves(long a, long b) {
		if (a == b)
			return 0;
		if (a > b) {
			if (a % 2L == 1L)
				return countMoves((a + 1L)/2L,b) + 2L;
			return countMoves(a/2L,b) + 1L;
		} else {
			if (b % 2L == 1L)
				return Math.min(countMoves(a,(b - 1L)/2L) + 2L, b - a);
			return Math.min(countMoves(a,b/2L) + 1L, b - a);
		}
	}
	
	/* OLD SOLUTION
	static HashMap<Long,Long> visitedMoveCount;
	static long minMoves;
	static long cow2;
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numPairs = console.nextInt();
		for (int i = 0; i < numPairs; i++) {
			HashMap<Long,Long> visitedMoveCount = new HashMap<>();
			long minMoves = 0L;
			long cow1 = console.nextLong();
			long cow2 = console.nextLong();
			
			if (cow1 == cow2) {
				System.out.println(0);
				continue;
			}
			List<Long> cow1List = new ArrayList<>();
			List<Long> cow2List = new ArrayList<>();
			cow1List.add(cow1);
			cow2List.add(cow2);
			while (cow1 != 1) {
				if (cow1 % 2 == 0)
					cow1 /= 2;
				else
					cow1 += 1;
				cow1List.add(cow1);
			}
			while (cow2 != 1) {
				if (cow2 % 2 == 0)
					cow2 /= 2;
				else
					cow2 -= 1;
				cow2List.add(cow2);
			}
			long sharedElement = -1L;
			while (cow1List.get(cow1List.size()-1) == cow2List.get(cow2List.size()-1)) {
				sharedElement = cow1List.get(cow1List.size()-1);
				cow1List.remove(cow1List.size()-1);
				cow2List.remove(cow2List.size()-1);
			}
			if (sharedElement != -1L)
				cow1List.add(sharedElement);
			Stack<Integer> cow1Pointers = new Stack<>();
			Stack<Integer> cow2Pointers = new Stack<>();
			cow1Pointers.push(cow1List.size()-1);
			cow2Pointers.push(cow1List.size());
			for (int a = cow2List.size() - 1; a >= 0; a--)
				cow1List.add(cow2List.remove(a));
			long maxGain = 0;
			for (int c1 = 0; c1 < cow1List.size() - 1; c1++) {
				for (int c2 = c1 + 1; c2 < cow1List.size(); c2++) {
					if (c2 - c1 > cow1List.get(c2) - cow1List.get(c1)) {//prune and insert
						long range = cow1List.get(c2) - cow1List.get(c1);
						if (range <= 0)
							continue;
						if (maxGain < (c2 - c1) - (cow1List.get(c2) - cow1List.get(c1)))
							maxGain = (c2 - c1) - (cow1List.get(c2) - cow1List.get(c1));
					}
				}
			}
			System.out.println(cow1List.size() - 1 - maxGain);
		}
	}
	
	*/
	
	
	/*
	997
	998
	499
	500
	250
	125
	126
	63
	64
	32
	16
	8
	4 <-
	5
	6 
	7 <-
	14
	15
	30
	60
	120

1) find all numbers from cow1 to 1 by dividing 2 and adding 1 when necessary
2) find all numbers from cow2 to 1 by dividing 2 and subtracting 1 when necessary
3) join the two lists and at the largest common sublist from the end, keep track of the joint location
4) Use the joint location and recursively prune the list by using another location below it
   and finding if it is shorter to continuously add 1 to the original joint location value to get to the new location's
   value, if so remove everything in between and insert incrementing values from the original joint location. recur to
   two futures



	997
	998
	499
	500
	250
	125
	126
	63
	64
	32
	16
	8
	4 <-
	2
	3
	6
	7 <-
	14
	15
	30
	60
	120


	*/
}