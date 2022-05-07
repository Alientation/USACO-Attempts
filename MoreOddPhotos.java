import java.util.Scanner;

public class MoreOddPhotos {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numCows = console.nextInt();
		int evens = 0;
		int odds = 0;
		for (int x = 0; x < numCows; x++) {
			if (console.nextInt() % 2 == 0) {
				evens++;
			} else {
				odds++;
			}
		}
		
		int maxGroups = 0;
		int tCows = evens+odds;
		int totalCows = 0;
		int type = 2;
		
		while (totalCows < tCows && !(odds == 0 && type == 1)) {
			if (type == 2) {
				if (evens != 0) {
					evens--;
					type = 1;
					totalCows++;
					maxGroups++;
					//System.out.println("type == 2 | -1 evens & +1 maxGroups");
				} else {
					if (odds >= 2) {
						odds -= 2;
						totalCows+=2;
						type = 1;
						maxGroups++;
						//System.out.println("type == 2 | -2 odds & +1 maxGroups");
					} else {
						if (odds == 1) {
							totalCows++;
							maxGroups--;
							odds--;
							//System.out.println("type == 2 | -1 odd & -1 maxGroups");
						}
					}
				}
			} else {
				if (odds == 2) {
					if (evens == 0) {
						odds -= 2;
						totalCows+=2;
						//System.out.println("type == 1 | -2 odds");
					} else {
						odds -= 1;
						totalCows++;
						maxGroups++;
						type = 2;
						//System.out.println("type == 1 | -1 odd & +1 maxGroups");
					}
				} else {
					type = 2;
					odds--;
					totalCows++;
					maxGroups++;
					//System.out.println("type == 1 | -1 odd & +1 maxGroups");
				}
			}
		}
		
		System.out.println(maxGroups);
		
	}
}
