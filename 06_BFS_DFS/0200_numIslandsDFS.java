
import java.util.*;

public class Solution {
    public int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void dfs(int x, int y, char[][] grid, boolean[][] isVisited) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || isVisited[x][y] == true) {
            return;
        }
        
        isVisited[x][y] = true;
        
        for(int k = 0; k < 4; k++) { 
            dfs(x + direction[k][0], y + direction[k][1], grid, isVisited);
        }
        
        return;
    }
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        // check every number in the grid in a for loop
        // create a new boolean grid to manage if the number is checked or not
        // if it's 1 and it's not checked, start with this number
        // do a full bfs until hitting the boundries or 0
        // whenn a bfs is done, return and continue the checking for loop
        // bfs usually use a queue to store the neighbours
        
        int m = grid.length, n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int result = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // skip the 0 and visited position on the grid 
                if(grid[i][j] == '1' && isVisited[i][j] == false) {
                    // a new island starts
                    result = result + 1;

                    // dfs
                    dfs(i, j, grid, isVisited);
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
	    int r = s.numIslands(grid);
        System.out.println(r);
	}
}


