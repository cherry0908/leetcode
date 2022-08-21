import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        
        return max;
    }

    public int maxSubArrayDP(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        
        // dp[i] means the maximum subarray ending with nums[i];
        // be aware, it's not the sum, but the max sum!!!!!
        int[] dp = new int[n];
         
        // initialize
        dp[0] = nums[0];
        int result = dp[0];
        
        // calculate the sum 
        for (int i = 1; i < n; i ++) {
            // If sum till [i-1] is still usefull, take it
            // otherwise take current nums[i] as sum till i
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            
            // update the result
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }

}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("result: " + obj.maxSubArrayDividConquer(nums));
	}
}
