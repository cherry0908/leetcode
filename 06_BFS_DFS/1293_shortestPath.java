import java.util.*;

public class Solution {
    public int shortestPath(int[][] grid, int k) {
        if(grid == null || grid.length == 0) return -1;
        
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // 0 - the position is not visited
        // 1 - the position is visited regularly
        // 2 - the position is visited by eliminating an obstacle
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        
        // the position on the grid and the number of eliminated obstacles left
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, k});
        
        int steps = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                if(curr[0] == m - 1 && curr[1] == n - 1) {
                    return steps;
                }
                
                // get 4 directions
                for(int j = 0; j < 4; j++) {
                    int x = curr[0] + dir[j][0];
                    int y = curr[1] + dir[j][1];
                    
                    // within the boundries
                    if(x >= 0 && x < m && y >=0 && y < n) {
                        
                        // if the next position is not an obstacle
                        if(grid[x][y] == 0) {
                            // if the next position is not visited yet
                            // and the route to this position does not eliminate any obstacles
                            if(visited[x][y] == 0 && curr[2] == k) {
                                queue.add(new int[]{x, y, curr[2]});
                                visited[x][y] = 1;
                            }
                            
                            // if the next position is not visited yet
                            // and the route to this position eliminated obstacles before
                            else if(visited[x][y] == 0 && curr[2] < k) {
                                queue.add(new int[]{x, y, curr[2]});
                                visited[x][y] = 2;
                            }
                            
                            // if the next position is visited before by eliminating obstacles
                            // it can still be visited by normal route not eliminating 
                            else if(visited[x][y] == 2 && curr[2] == k) {
                                queue.add(new int[]{x, y, curr[2]});
                                visited[x][y] = 1;
                            }
                        }
                        
                        // if the next position is an obstacle, and the obstacle can be eliminated
                        else if(grid[x][y] == 1 && curr[2] > 0) {
                            // if the next position is not visited yet
                            if(visited[x][y] == 0) {
                                queue.add(new int[]{x, y, curr[2] - 1});
                                visited[x][y] = 2;
                            }
                        }
                        
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        int r = s.shortestPath(grid, 1);
        System.out.println(r);
    }
}