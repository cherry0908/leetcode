
import java.util.*;

public class Solution {
    
    public boolean isValid(int x, int y, char[][] grid, boolean[][] isVisited) {
        if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && isVisited[x][y] == false) {
            return true;
        }
        return false;
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
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // skip the 0 and visited position on the grid 
                if(grid[i][j] == '1' && isVisited[i][j] == false) {
                    // a new island starts
                    result = result + 1;

                    // add the starting position to the queue and marked as visited
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = true;

                    // bfs go through the queue until empty
                    while(!queue.isEmpty()) {
                        // poll the top of the queue
                        int[] cur = queue.poll();

                        // go to its 4 neighbours
                        for(int k = 0; k < 4; k++) {
                            int x = cur[0] + direction[k][0];
                            int y = cur[1] + direction[k][1];

                            // check the position, if it's valid, add to the queue and marked as visited
                            if(isValid(x, y, grid, isVisited)) {
                                queue.add(new int[]{x, y});
                                isVisited[x][y] = true;
                            }
                        }
                    }
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


