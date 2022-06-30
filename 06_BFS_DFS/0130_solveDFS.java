
import java.util.*;

public class Solution {
    public int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void dfsHelper(int i, int j, char[][] board, boolean[][] isVisited) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || isVisited[i][j] == true) {
            return;
        }
        
        isVisited[i][j] = true;
        board[i][j] = 'A';
        
        for(int k = 0; k < 4; k ++) {
            dfsHelper(i + direction[k][0], j + direction[k][1], board, isVisited);
        }
        
        return;
    }
    
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        
        // Surrounded regions should not be on the border, 
        // which means that any 'O' on the border of the board are not flipped to 'X'. 
        // Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
        // scan the borders and use DFS to find all island connected to the borders and set to a new character
        // then any O in the board can be flipped.
        
        int m = board.length, n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        
        int i, j;
        for(i = 0; i < m; i++) {
            // left border
            if(board[i][0] == 'O' && isVisited[i][0] == false) {
                dfsHelper(i, 0, board, isVisited);
            }
            
            // right border
            if(board[i][n - 1] == 'O' && isVisited[i][n - 1] == false) {
                dfsHelper(i, n - 1, board, isVisited);
            }
        }
        
        for(j = 0; j < n; j++) {
            // top border
            if(board[0][j] == 'O' && isVisited[0][j] == false) {
                dfsHelper(0, j, board, isVisited);
            }
            
            // bottom border
            if(board[m - 1][j] == 'O' && isVisited[m - 1][j] == false) {
                dfsHelper(m - 1, j, board, isVisited);
            }
        }
        
        for(i = 0; i < m; i ++) {
            for(j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } 
                else if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
        
        return;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
        char[][] grid = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
	    s.solve(grid);
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + ",");
            }
            System.out.println("");
        }
	}
}


