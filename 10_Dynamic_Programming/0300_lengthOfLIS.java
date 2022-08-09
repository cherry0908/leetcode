import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n= nums.length;
        int result = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}


public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("result: " + obj.lengthOfLIS(nums));
	}
}