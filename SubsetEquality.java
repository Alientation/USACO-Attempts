import java.util.*;
public class SubsetEquality {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int[] char1Count = new int[26];
		int[] char2Count = new int[26];
		char[] str1 = console.nextLine().toCharArray();
		char[] str2 = console.nextLine().toCharArray();
		for (char c : str1)
			char1Count[c-97]++;
		for (char c : str2)
			char2Count[c-97]++;
		char[] str;
		boolean solved = false;
		boolean[] validChar;
		
		HashMap<String,Boolean> hm = new HashMap<>();
		String[] queries = new String[console.nextInt()]; console.nextLine();
		HashMap<String,Integer> ordering = new HashMap<>();
		for (int numQueries = queries.length - 1; numQueries >= 0; numQueries--) {
			queries[numQueries] = console.nextLine();
			ordering.put(queries[numQueries], queries.length - 1 - numQueries);
		}
		Arrays.sort(queries, (a, b)->Integer.compare(b.length(), a.length()));
		
		boolean[] ans = new boolean[queries.length];
		for (int ii = 0; ii < queries.length;ii++) {
			if (hm.containsKey(queries[ii])) {
				ans[ordering.get(queries[ii])] = hm.get(queries[ii]);
			} else {
				solved = false;
				validChar = new boolean[26];
				str = queries[ii].toCharArray();
				for (char c : str)
					validChar[c-97] = true;
				for (int i = 0; i < validChar.length; i++) {
					if (validChar[i]) {
						if (char1Count[i] != char2Count[i]) {
							solved = true;
							break;
						}
					}
				}
				if (!solved) {
					int pointer1 = 0;
					int pointer2 = 0;
					while (pointer1 < str1.length && pointer2 < str2.length) {
						if (validChar[str1[pointer1]-97] && validChar[str2[pointer2]-97])
							if (str1[pointer1] != str2[pointer2]) {
								solved = true;
								break;
							} else {
								pointer1++;
								pointer2++;
								continue;
							}
						if (!validChar[str1[pointer1]-97])
							pointer1++;
						if (!validChar[str2[pointer2]-97])
							pointer2++;
					}
					if (!solved) {
						while (pointer1 < str1.length) {
							if (validChar[str1[pointer1]-97]) {
								solved = true;
								break;
							}
							pointer1++;
						}
						while (pointer2 < str2.length) {
							if (validChar[str2[pointer2]-97]) {
								solved = true;
								break;
							}
							pointer2++;
						}
					}
					if (!solved)
						ans[ordering.get(queries[ii])] = true;
				}
				//set hashmap
				if (ans[ordering.get(queries[ii])])
					recur(hm,"",queries[ii],0);
			}
		}
		for (boolean b : ans)
			System.out.print(b ? "Y":"N");
		console.close();
	}
	
	public static void recur(HashMap<String,Boolean> hm, String cur, String base, int i) {
		hm.put(cur, true);
		if (i < base.length()) {
			recur(hm,cur + base.charAt(i),base,++i);
			recur(hm,cur,base,i);
		}
	}
}
