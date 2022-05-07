import java.util.*;
public class CowFrisbee {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		long sumDistances = 0L;
		Stack<Integer> stack = new Stack<>();
		int[] H = new int[console.nextInt()];
		for (int i = 0; i < H.length; i++)
			H[i] = console.nextInt();
		for (int i = 0; i < H.length; i++) {
			if (!stack.isEmpty() && H[i] > H[stack.peek()]) {
				int prev = i;
				while (!stack.isEmpty() && H[prev] <= H[i]) {
					prev = stack.pop();
					if (i - prev > 1) {
						sumDistances += i - prev + 1;
					}
				}
				if (H[prev] > H[i]) stack.push(prev);
			}
			stack.push(i);
		}
		System.out.println(sumDistances + (H.length - 1) * 2);
		console.close();
	}
}
