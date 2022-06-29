
import java.util.*;

public class Solution {
    
    public int swimInWater(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int n = grid.length; 
        //HashSet<Integer> isVisited = new HashSet<>();
        boolean[][] isVisited = new boolean[n][n];
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int result = Integer.MIN_VALUE;
        
        // top has the smalliest grid
        // i * n + j is the position stored in the priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((k1, k2) -> grid[k1 / n][k1 % n] - grid[k2 / n][k2 % n]);
        pq.offer(0);
        
        // always pick the smallest grid value for the next step
        // use priority queue
        // You can swim infinite distances in zero time.
        // it means all the previour neighbors added into the queue can be reached
        // maybe swim back to the same grid, doesn't matter
        // so every time pick the top of the priority queue
        // then add all the unvisited neighbors
        while(!pq.isEmpty()){
            int k = pq.poll();
            int x = k / n;
            int y = k % n;
            result = Math.max(result, grid[x][y]);
            
            if(x == n - 1 && y == n - 1) {
                return result;
            }
            
            for(int i = 0; i < 4; i++) {
                int xx = x + direction[i][0];
                int yy = y + direction[i][1];
                int kk = xx * n + yy;
                
                if(xx >= 0 && xx < n && yy >= 0 && yy < n && isVisited[xx][yy] == false) {
                //if(xx >= 0 && xx < n && yy >= 0 && yy < n && !isVisited.contains(kk)) {
                    pq.offer(kk);
                    isVisited[xx][yy] = true;
                    //isVisited.add(kk);
                }
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
	    int r = s.swimInWater(grid);
        System.out.println(r);
	}
}


