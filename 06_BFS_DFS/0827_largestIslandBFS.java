
import java.util.*;

public class Solution {
    // use color island method
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int result = 0;
        int m = grid.length, n = grid[0].length;
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean hasZero = false;
        
        // 0 and 1 are already used in the grid, colorIndex starts with 2
        int colorIndex = 2;
        HashMap<Integer, Integer> colorMap = new HashMap<Integer, Integer>();
        // colorIndex 0 is size 0
        colorMap.put(0, 0);
        
        // scan every 1 in the grid
        // overwrite the grid with color
        // create the color hash map
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int size = 0;
                    
                    // BFS to find the entire island
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.add(new int[]{i, j});
                    grid[i][j] = colorIndex;
                    
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        size++;
                        
                        for(int k = 0; k < 4; k++){
                            int x = cur[0] + direction[k][0];
                            int y = cur[1] + direction[k][1];
                            if(x >=0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                                queue.add(new int[]{x, y});
                                grid[x][y] = colorIndex;
                            }
                        }
                    }
                    
                    colorMap.put(colorIndex, size);
                    colorIndex++;
                }
            }
        }
        
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(grid[i][j]);
        //     }
        //     System.out.println();
        // }
        
        // System.out.println(colorMap);
        
        // scan every 0
        // find its non-duplicated colored neighbours
        // add up the size of island
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                HashSet<Integer> neighbours = new HashSet<Integer>();
                
                if(grid[i][j] == 0) {
                    hasZero = true;
                    
                    // find the color of each neighbour from the grid
                    // hash set will take care of the duplicates
                    neighbours.add(i > 0 ? grid[i - 1][j] : 0);
                    neighbours.add(i < m - 1 ? grid[i + 1][j] : 0);
                    neighbours.add(j > 0 ? grid[i][j - 1] : 0);
                    neighbours.add(j < n - 1 ? grid[i][j + 1] : 0);
                }
                
                // System.out.println(neighbours);
                
                // including the current 0 if changed to 1
                int area = 1;
                // add up the size of distinct neighbour
                for(int neighbour : neighbours) {
                    area += colorMap.getOrDefault(neighbour, 0);
                }
                
                result = Math.max(result, area);
            }
        }
        
        // if all grid is 1, the max island size is m*n
        return hasZero ? result : m * n;
        
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{1,0}, {0,1}};
	    int r = s.largestIsland(grid);
        System.out.println(r);
	}
}
