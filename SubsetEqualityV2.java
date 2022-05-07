import java.util.*;

public class SubsetEqualityV2 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String s = console.nextLine();
		String t = console.nextLine();
		ArrayList<String> queries = new ArrayList<>();
		for (int i = console.nextInt(); i > 0; i--) {
			console.nextLine();
			queries.add(console.next());
		}
		LinkedHashMap<Character, Integer> shm = new LinkedHashMap<>();
		LinkedHashMap<Character, Integer> thm = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++)
			shm.put(s.charAt(i), (!shm.containsKey(s.charAt(i))) ? 1 : (shm.get(s.charAt(i)) + 1));
		for (int i = 0; i < t.length(); i++) {
			thm.put(t.charAt(i), (!thm.containsKey(t.charAt(i))) ? 1 : (thm.get(t.charAt(i)) + 1));
		}
		for (String ss : queries) {
			StringBuilder ssb = new StringBuilder();
			StringBuilder tsb = new StringBuilder();
			for (char ch : shm.keySet()) {
				for (int i = 0; i < ss.length(); i++) {
					if (ch == ss.charAt(i)) {
						ssb.append(ss.charAt(i));
						ssb.append(shm.get(ss.charAt(i)));
					}
				}
			}
			for (char ch : thm.keySet()) {
				for (int i = 0; i < ss.length(); i++) {
					if (ch == ss.charAt(i)) {
						tsb.append(ss.charAt(i));
						tsb.append(thm.get(ss.charAt(i)));
					}
				}
			}
			System.out.print(ssb.toString().equals(tsb.toString()) ? "Y" : "N");
		}
		console.close();
	}
}
