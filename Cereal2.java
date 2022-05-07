import java.util.*;
public class Cereal2 {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		int N = console.nextInt();
		int cerealTypes = console.nextInt();
		
		
		
		
		Cow[] cows = new Cow[N];
		
		
		
	}
}

class Graph {
	HashSet<Cow> set;
	
	public Graph() {
		set = new HashSet<>();
	}
	
	
}

class Cow {
	int id;
	int parentNode, childNode;
	int favorite;
	
	public Cow(int id, int parentNode, int childNode, int favorite) {
		this.id = id;
		this.parentNode = parentNode;
		this.childNode = childNode;
		this.favorite = favorite;
	}
}