import java.util.*;
import java.util.Arrays;

public class Main
{
	private boolean validate(char[][] board, int i, int j, char c) {
		for (int row = 0; row < 9; row++)
			if (board[row][j] == c) return false;

		for (int col = 0; col < 9; col++)
			if (board[i][col] == c) return false;

		int rIdx = i / 3 * 3;
		int cIdx = j / 3 * 3;
		for (int row = rIdx; row < rIdx + 3; row++)
			for (int col = cIdx; col < cIdx + 3; col++)
				if (board[row][col] == c) return false;
 
		return true;
	}

	private boolean dfs(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char num = '1'; num <= '9'; num++) {
						if (validate(board, i, j, num)) {
							board[i][j] = num;
							if (dfs(board))
								return true;
							else
								board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

    private boolean helper(char[][] board, int i, int j){
        if (i == 9) return true;
        if (j == 9) return helper(board, i + 1, 0);
        if (board[i][j] != '.') return helper(board, i, j + 1);
        for (char c = '1'; c <= '9'; ++c) {
            if (!validate(board, i , j, c)) continue;
            board[i][j] = c;
            if (helper(board, i, j + 1)) return true;
            board[i][j] = '.';
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
		dfs(board);
        //helper(board, 0, 0);
	}

	public static void main(String[] args) {
	    Main m = new Main();
	    char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        }
        System.out.println("List: " + m.solveSudoku(board));
	}
}
