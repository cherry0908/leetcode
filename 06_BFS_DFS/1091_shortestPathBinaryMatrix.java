import java.util.*;

public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[0][0] != 0 || grid[m - 1][n - 1] != 0) return -1;
        
        boolean[][] visited = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        int steps = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                if(curr[0] == m - 1 && curr[1] == n - 1) {
                    return steps;
                }
                
                for(int j = 0; j < 8; j++) {
                    int x = curr[0] + dir[j][0];
                    int y = curr[1] + dir[j][1];
                    
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && visited[x][y] == false) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        int r = s.shortestPathBinaryMatrix(grid);
        System.out.println(r);
    }
}