import java.util.*;

public class Solution {
    
    public void print(int[][] array) {
        StringBuilder sb = new StringBuilder();
        
        for (int[] arr : array) {
            sb.append(Arrays.toString(arr));
        }
        
        String s = sb.toString();
        
        System.out.println(s);
    }
    
    public int[][] fillMissingCoordinates(int[][] coordinates, int interval) {
        if (coordinates == null || coordinates.length == 0) return new int[][]{};
        
        int n = coordinates.length;
        
        List<int[]> list = new ArrayList<>();
        list.add(coordinates[0]);
        
        int x1 = coordinates[0][0], y1 = coordinates[0][1];
        
        for (int i = 1; i < n; i++) {
            int x2 = coordinates[i][0], y2 = coordinates[i][1];
            
            // if next coordinates is the missing one
            if (x2 - x1 > interval) {
                // calculate the slope
                int m = (y2 - y1) / (x2 - x1);
                int newX = x1, newY = y1;
                
                // start to fill in the missing coordinates
                while (newX < x2) {
                    newX = newX + interval;
                    newY = m * (newX - x1) + y1;
                    list.add(new int[]{newX, newY});
                }
                
                // (x1, y1) move to the current coordinate
                x1 = newX;
                y1 = newY;
            }
            // if the coordinate is not missing, move to the next
            else {
                x1 = x2;
                y1 = y2;
                list.add(coordinates[i]);
            }
        }
        
        int size = list.size();
        int[][] result = new int[size][2];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[][] coordinates = {{0, 10}, {5, 20}, {20, -10}, {30, 0}};
        int[][] result = solution.fillMissingCoordinates(coordinates, 5);
        
        solution.print(coordinates);
        solution.print(result);
      
    }
}