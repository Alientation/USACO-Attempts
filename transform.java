/*
ID: alienbob
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;

class transform {
	public static int n;
	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
                                                  // input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		//StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
		n = Integer.parseInt(f.readLine());
    
		boolean[][] bools = new boolean[n][n];
		boolean[][] newBools = new boolean[n][n];
		for (int y = 0; y < n; y++) {
			char[] c = f.readLine().toCharArray();
			for (int x = 0; x < n; x++) {
				if (c[x] == '@')
					bools[y][x] = true;
			}
		}
		for (int y = 0; y < n; y++) {
			char[] c = f.readLine().toCharArray();
			for (int x = 0; x < n; x++) {
				if (c[x] == '@')
					newBools[y][x] = true;
			}
		}
		boolean b = true;
		//1
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				int[] i = rotate90(y,x);
				if (newBools[i[0]][i[1]] == bools[y][x]) {
					continue;
				} else {
					b = false;
					break;
				}
			}
		}
		if (b) {
			out.println(1);
		} else {
			b = true;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					int[] i = rotate90(rotate90(y,x)[0],rotate90(y,x)[1]);
					if (newBools[i[0]][i[1]] == bools[y][x]) {
						continue;
					} else {
						b = false;
						break;
					}
				}
			}
			if (b) {
				out.println(2);
			} else {
				b = true;
				for (int y = 0; y < n; y++) {
					for (int x = 0; x < n; x++) {
						int[] i = rotate90(rotate90(rotate90(y,x)[0],rotate90(y,x)[1])[0],rotate90(rotate90(y,x)[0],rotate90(y,x)[1])[1]);
						if (newBools[i[0]][i[1]] == bools[y][x]) {
							continue;
						} else {
							b = false;
							break;
						}
					}
				}
				if (b) {
					out.println(3);
				} else {
					b = true;
					for (int y = 0; y < n; y++) {
						for (int x = 0; x < n; x++) {
							if (newBools[y][x] == bools[y][x]) {
								continue;
							} else {
								b = false;
								break;
							}
						}
					}
					if (b) {
						out.println(6);
					} else {
						b = true;
						for (int y = 0; y < n; y++) {
							for (int x = 0; x < n; x++) {
								int[] i = reflect(y,x);
								if (newBools[i[0]][i[1]] == bools[y][x]) {
									continue;
								} else {
									b = false;
									break;
								}
							}
						}
						if (b) {
							out.println(4);
						} else {
							b = true;
							for (int y = 0; y < n; y++) {
								for (int x = 0; x < n; x++) {
									int[] j = reflect(y,x);
									int[] i = rotate90(j[0],j[1]);
									if (newBools[i[0]][i[1]] == bools[y][x]) {
										continue;
									} else {
										b = false;
										break;
									}
								}
							}
							if (!b) {
								b = true;
								for (int y = 0; y < n; y++) {
									for (int x = 0; x < n; x++) {
										int[] j = reflect(y,x);
										int[] i = rotate90(rotate90(j[0],j[1])[0],rotate90(j[0],j[1])[1]);
										if (newBools[i[0]][i[1]] == bools[y][x]) {
											continue;
										} else {
											b = false;
											break;
										}
									}
								}
								if (!b) {
									b = true;
									for (int y = 0; y < n; y++) {
										for (int x = 0; x < n; x++) {
											int[] j = reflect(y,x);
											int[] i = rotate90(rotate90(rotate90(j[0],j[1])[0],rotate90(j[0],j[1])[1])[0],rotate90(rotate90(j[0],j[1])[0],rotate90(j[0],j[1])[1])[1]);
											if (newBools[i[0]][i[1]] == bools[y][x]) {
												continue;
											} else {
												b = false;
												break;
											}
										}
									}
									if (!b) {
										out.println(7);
									} else {
										out.println(5);
									}
								} else {
									out.println(5);
								}
							} else {
								out.println(5);
							}
						}
					}
				}
			}
		}
		out.close();                                  // close the output file
	}
  
  public static int[] rotate90(int y, int x) {
	  int[] i = {x, n-1 - y};
	  return i;
  }
  
  public static int[] reflect(int y, int x) {
	  int[] i = {y, n-1 - x};
	  return i;
  }
}