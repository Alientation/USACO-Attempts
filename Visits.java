import java.util.*;
public class Visits {
	public static int minVal = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int N = console.nextInt();
		HashMap<Integer,Integer> maxPathAtNode = new HashMap<>();
		HashMap<Integer,Node> nodeMap = new HashMap<>();
		int buddy;
		int mooVal;
		boolean visited[] = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			buddy = console.nextInt();
			mooVal = console.nextInt();
			if (!nodeMap.containsKey(buddy))
				nodeMap.put(buddy, new Node());
			if (!nodeMap.containsKey(i))
				nodeMap.put(i, new Node());
			nodeMap.get(i).next = buddy;
			nodeMap.get(i).mooVal = mooVal;
		}
		int sum = 0;
		for (int i = 1; i <= N; i++)
			if (!maxPathAtNode.containsKey(i)) {
				minVal = Integer.MAX_VALUE;
				sum += recur(Integer.MAX_VALUE,i,nodeMap,maxPathAtNode, visited) - minVal;
			}
		System.out.println(sum);
		console.close();
	}
	
	public static int recur(int past,int curNode, HashMap<Integer,Node> nodeMap, HashMap<Integer,Integer> maxPathAtNode, boolean visited[]) {
		if (maxPathAtNode.containsKey(curNode))
			return maxPathAtNode.get(curNode);
		if (visited[curNode])
			return 0;
		visited[curNode] = true;
		int sum1 = recur(nodeMap.get(curNode).mooVal,nodeMap.get(curNode).next,nodeMap,maxPathAtNode,visited);
		int sum2 = recur(nodeMap.get(curNode).mooVal,nodeMap.get(nodeMap.get(curNode).next).next,nodeMap,maxPathAtNode,visited);
		int sum = nodeMap.get(curNode).mooVal + Math.max(sum1,sum2);
		if (sum1 > sum2) {
			if (minVal > nodeMap.get(nodeMap.get(curNode).next).mooVal)
				minVal = nodeMap.get(nodeMap.get(curNode).next).mooVal;
		} else {
			if (minVal > nodeMap.get(nodeMap.get(nodeMap.get(curNode).next).next).mooVal)
				minVal = nodeMap.get(nodeMap.get(nodeMap.get(curNode).next).next).mooVal;
		}
		maxPathAtNode.put(curNode, sum);
		return sum;
	}
}

class Node {
	public int mooVal;
	public int next;
	public Node(int next, int mooVal) {
		this.next = next;
		this.mooVal = mooVal;
	}
	
	public Node() {
		
	}
}
