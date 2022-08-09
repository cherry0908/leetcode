import java.util.*;

class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            
            // for the last step, try with all the coins
            // get the min of steps
            // dp[i] = min of all [j] {dp[i - coins[j]] + 1}
            for (int j = 0; j < coins.length; j++) {
                int prev = i - coins[j];
                
                // prev needs to >= 0
                // only do when dp[prev] is a number, has solutions
                if (prev >= 0 && dp[prev] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[prev] + 1, dp[i]);
                }
            }
        }
        
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return dp[amount];
        }
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1, 2, 5};
        System.out.println("result: " + obj.coinChange(nums, 11));
	}
}
