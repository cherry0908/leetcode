
import java.util.*;

public class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int result = 0;
        int m = grid.length, n = grid[0].length;
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.add(new int[]{i, j});
                    grid[i][j] = -1;
                    int area = 0;
                    
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        area++;
                        for(int k = 0; k < 4; k++) {
                            int x = cur[0] + direction[k][0];
                            int y = cur[1] + direction[k][1];
                            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                                queue.add(new int[]{x, y});
                                grid[x][y] = -1;
                            }
                        }
                    }
                    
                    result = Math.max(result, area);
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


