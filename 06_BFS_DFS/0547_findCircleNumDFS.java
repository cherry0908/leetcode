
import java.util.*;

public class Solution {
    
    public void dfsHelper(int[][] isConnected, int i, boolean[] isVisited) {
        isVisited[i] = true;
        for(int k = 0; k < isConnected.length; k++) {
            if(!isVisited[k] && isConnected[k][i] == 1) {
                dfsHelper(isConnected, k, isVisited);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0) return 0;
        
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int result = 0;
        
        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                result++;
                dfsHelper(isConnected, i, isVisited);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{1,1,0},{1,1,0},{0,0,1}};
	    int r = s.findCircleNum(grid);
        System.out.println(r);
	}
}


