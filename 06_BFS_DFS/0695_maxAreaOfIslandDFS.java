
import java.util.*;

public class Solution {
    
    public int dfs(int[][] grid, int x, int y, boolean[][] isVisited, int[][] direction) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || isVisited[x][y] == true) {
            return 0;
        }
        
        int area = 1;
        isVisited[x][y] = true;
        
        for(int k = 0; k < 4; k++) {
            area += dfs(grid, x + direction[k][0], y + direction[k][1], isVisited, direction);
        }
        
        return area;
    }
    
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int result = 0;
        int m = grid.length, n = grid[0].length;
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] isVisited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && isVisited[i][j] == false) {
                    result = Math.max(result, dfs(grid, i, j, isVisited, direction));
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
	    int r = s.maxAreaOfIsland(grid);
        System.out.println(r);
	}
}


