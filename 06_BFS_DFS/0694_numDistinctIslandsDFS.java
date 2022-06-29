
import java.util.*;

public class Solution {
    public void dfsHelper(int i, int j, int x, int y, int[][] grid, boolean[][] isVisited, int[][] direction, ArrayList<String> island) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || isVisited[i][j] == true) {
            return;
        }
        
        isVisited[i][j] = true;
        
        String position = String.valueOf(i - x) + "," + String.valueOf(j - y);
        island.add(position);
        
        for(int k = 0; k < 4; k++) {
            dfsHelper(i + direction[k][0], j + direction[k][1], x, y, grid, isVisited, direction, island);
        }
    }
    
    public int numDistinctIslands(int[][] grid) {
        if(grid == null | grid.length == 0) return 0;
        
        int m = grid.length, n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        HashSet<ArrayList<String>> set = new HashSet<ArrayList<String>>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && isVisited[i][j] == false) {
                    ArrayList<String> island = new ArrayList<String>();
                    dfsHelper(i, j, i, j, grid, isVisited, direction, island);
                    set.add(island);
                }
            }
        }
        
        return set.size();
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
	    int r = s.numDistinctIslands(grid);
        System.out.println(r);
	}
}


