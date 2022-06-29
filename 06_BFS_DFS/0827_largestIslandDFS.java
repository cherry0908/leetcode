
import java.util.*;

public class Solution {
    // use color island method
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int result = 0;
        int m = grid.length, n = grid[0].length;
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
                    int size = paintIslandDFS(i, j, colorIndex, grid);
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
    
    public int paintIslandDFS(int x, int y, int color, int[][] grid){
        // if out of boundries, if grid is 0, if grid is already visited (overwritten with color)
        // return 0, shouldn't be counted in the size
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        
        // if grid is 1, overwrite with color
        grid[x][y] = color;
        
        // find the neighbour islands using dfs and add up
        return 1 + paintIslandDFS(x + 1, y, color, grid) + paintIslandDFS(x - 1, y, color, grid) + paintIslandDFS(x, y + 1, color, grid) + paintIslandDFS(x, y - 1, color, grid);
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{1,0}, {0,1}};
	    int r = s.largestIsland(grid);
        System.out.println(r);
	}
}
