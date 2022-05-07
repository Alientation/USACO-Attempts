import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RobotInstructions {
	
	static int[] count;
	static HashMap<Long,HashMap<Long,Boolean>> dp;
	//static HashMap<Long,HashMap<Long,List<Integer>>> dp;
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		count = new int[n];
		dp = new HashMap<>();
		long goalX = console.nextLong();
		long goalY = console.nextLong();
		
		long[][] inst = new long[n][2];
		for (int i = 0; i < n; i++) {
			inst[i][0] = console.nextLong();
			inst[i][1] = console.nextLong();
		}
		recur(goalX,goalY,inst,0,0L,0L,0, new LinkedList<long[]>(), false);
		
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
		console.close();
	}
	
	
	public static void recur(long goalX, long goalY, long[][] inst, int numUsed, long curX, long curY, int checkFrom, LinkedList<long[]> path, boolean reached) {
		if (curX == goalX && curY == goalY) {
			count[numUsed-1]++;
			//System.out.println(path.size());
			/*
			for (int i = 0; i < path.size(); i++) {
				//System.out.println(path.get(i)[0] + ", " + path.get(i)[1]);
				HashMap<Long,List<Integer>> hm = dp.getOrDefault(path.get(i)[0], new HashMap<>());
				List<Integer> list = hm.getOrDefault(path.get(i)[1],new ArrayList<Integer>());
				list.add(numUsed - i);
				hm.put(path.get(i)[1], list);
				dp.put(path.get(i)[0], hm);
			}
			return;*/
		}
		if (numUsed == inst.length || checkFrom == inst.length) return;
		/*
		if (goalX != curX && goalY != curY && dp.get(curX) != null && dp.get(curX).get(curY) != null) {
			List<Integer> li = dp.get(curX).get(curY);
			List<Integer> temp = new ArrayList<>();
			
			for (int ii : li) {
				//System.out.println(ii + ", " + numUsed);
				temp.add(ii);
				count[ii + numUsed - 1]++;
			}
			
			for (int ii : temp) {
				for (int i = 0; i < path.size(); i++) {
					HashMap<Long,List<Integer>> hm = dp.getOrDefault(path.get(i)[0], new HashMap<>());
					List<Integer> list = hm.getOrDefault(path.get(i)[1],new ArrayList<Integer>());
					list.add(numUsed - i + ii);
					hm.put(path.get(i)[1], list);
					dp.put(path.get(i)[0], hm);
				}
			}
			return;
		}*/
		
		for (int i = checkFrom; i < inst.length; i++) {
			path.add(new long[] {curX + inst[i][0], curY + inst[i][1]});
			recur(goalX,goalY, inst,numUsed+1,curX + inst[i][0], curY + inst[i][1],i + 1, path, reached || (curX == goalX && curY == goalY));
			path.removeLast();
		}
	}
	
}
