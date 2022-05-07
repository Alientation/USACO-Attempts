import java.util.*;
public class MazeTacToe {
	static HashSet<Integer> set = new HashSet<Integer>();
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int N = console.nextInt();
		console.nextLine();
		Cell[][] cells = new Cell[N][N];
		int[][] board = new int[3][3];
		boolean[][][] visited = new boolean[N][N][19683];
		
		int startY = 0,startX = 0;
		String line;
		for (int i = 0; i < N; i++) {
			line = console.nextLine();
			for (int j = 0; j < N; j++) {
				if (line.charAt(j*3) == '#')
					cells[i][j] = new Cell(Cell.WALL);
				else if (line.charAt(j * 3) == 'B') {
					cells[i][j] = new Cell(Cell.START);
					startY = i; startX = j;
				} else if (line.charAt(j * 3) == '.')
					cells[i][j] = new Cell(Cell.SPACE);
				else
					cells[i][j] = new Cell(Cell.PAPER,line.charAt(j*3) == 'M' ? 1 : 2,line.charAt(j*3 + 1) - 48, line.charAt(j*3 + 2) - 48);
			}
		}
		recur(visited,board,cells,startY,startX,convertBoardToInt(board));
		System.out.println(set.size());
		console.close();
	}
	public static void recur(boolean[][][] visited,int[][] board, Cell[][] cells, int i, int j, int b) {
		if (visited[i][j][b]) return;
		visited[i][j][b] = true;
		if (board[cells[i][j].i][cells[i][j].j] == 1 || board[cells[i][j].i][cells[i][j].j] == 2) {
			b = convertBoardToInt(board);
			//b += board[cells[i][j].i][cells[i][j].j] * Math.pow(3, cells[i][j].i * 3 + cells[i][j].j);
			if (hasSpelledMoo(board)) {
				set.add(b);
				return;
			}
		}
		if (inBounds(cells,i+1,j)) {
			if (cells[i+1][j].type == Cell.PAPER && board[cells[i+1][j].i][cells[i+1][j].j] == 0) {
				board[cells[i+1][j].i][cells[i+1][j].j] = cells[i+1][j].letter;
				recur(visited,board,cells,i+1,j,b);
				board[cells[i+1][j].i][cells[i+1][j].j] = 0;
			} else
				recur(visited,board,cells,i+1,j,b);
		}
		if (inBounds(cells,i-1,j)) {
			if (cells[i-1][j].type == Cell.PAPER && board[cells[i-1][j].i][cells[i-1][j].j] == 0) {
				board[cells[i-1][j].i][cells[i-1][j].j] = cells[i-1][j].letter;
				recur(visited,board,cells,i-1,j,b);
				board[cells[i-1][j].i][cells[i-1][j].j] = 0;
			} else
				recur(visited,board,cells,i-1,j,b);
		}
		if (inBounds(cells,i,j+1)) {
			if (cells[i][j+1].type == Cell.PAPER && board[cells[i][j+1].i][cells[i][j+1].j] == 0) {
				board[cells[i][j+1].i][cells[i][j+1].j] = cells[i][j+1].letter;
				recur(visited,board,cells,i,j+1,b);
				board[cells[i][j+1].i][cells[i][j+1].j] = 0;
			} else
				recur(visited,board,cells,i,j+1,b);
		}
		if (inBounds(cells,i,j-1)) {
			if (cells[i][j-1].type == Cell.PAPER && board[cells[i][j-1].i][cells[i][j-1].j] == 0) {
				board[cells[i][j-1].i][cells[i][j-1].j] = cells[i][j-1].letter;
				recur(visited,board,cells,i,j-1,b);
				board[cells[i][j-1].i][cells[i][j-1].j] = 0;
			} else
				recur(visited,board,cells,i,j-1,b);
		}
	}
	
	public static boolean inBounds(Cell[][] cells, int i, int j) {
		if (i >= 0 && i < cells.length && j >= 0 && j < cells[0].length && cells[i][j].type != Cell.WALL)
			return true;
		return false;
	}
	
	public static int convertBoardToInt(int[][] board) {
		int res = 0;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				res += board[i][j] * Math.pow(3, i * 3 + j);
		return res;
	}
	//1 = M  |  2 = O
	static int y, x;
	public static boolean hasSpelledMoo(int[][] board) {
		for (y = 0; y < board.length; y++) {
			if (board[y][1] == board[y][2] && board[y][2] == 2 && board[y][0] == 1) //horizontal
				return true;
			if (board[y][0] == board[y][1] && board[y][1] == 2 && board[y][2] == 1) //reverse horizontal
				return true;
		}
		for (x = 0; x < board[0].length; x++) {
			if (board[2][x] == board[1][x] && board[1][x] == 2 && board[0][x] == 1) //vertical
				return true;
			if (board[0][x] == board[1][x] && board[1][x] == 2 && board[2][x] == 1) //reverse vertical
				return true;
		}
		//diagonals
		if (board[0][0] == board[1][1] && board[1][1] == 2 && board[2][2] == 1)
			return true;
		if (board[2][2] == board[1][1] && board[1][1] == 2 && board[0][0] == 1)
			return true;
		if (board[2][0] == board[1][1] && board[1][1] == 2 && board[0][2] == 1)
			return true;
		if (board[0][2] == board[1][1] && board[1][1] == 2 && board[2][0] == 1)
			return true;
		return false;
	}
}

class Cell {
	public static final int WALL = 1; public static final int SPACE = 0; public static final int START = 10; public static final int PAPER = 100;
	public int type, i, j, letter;
	public Cell(int type) { this.type = type; }
	public Cell(int type, int letter, int i, int j) { this.type = type; this.letter = letter; this.i = i - 1; this.j = j - 1; }
}
