
import java.util.*;

public class Solution {

    public int findJudge(int n, int[][] trust) {
        if(n == 0 || trust == null) return -1;
        
        // Be aware n=1, trust is empty
        // should return 1
        
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        
        for(int[] pair : trust) {
            in[pair[1]]++;
            out[pair[0]]++;
        }
        
        // System.out.println(Arrays.toString(in));
        // System.out.println(Arrays.toString(out));
        
        for(int i = 1; i <= n; i++) {
            if(in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{1,2}};
	    int r = s.findJudge(2, grid);
        System.out.println(r);
	}
}
