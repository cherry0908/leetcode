class Solution {
    
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        // 有多少种组合拼出重量i
        for (int i = 0; i <= target; i++) {
            // 最后一个要加上的数字是多少，枚举数组里的所有数字
            for (int j = 0; j < n; j++) {
                if (i - nums[j] >= 0) {
                    // dp[i]这个target的值是用dp[i-nums[j]]这个target能拼出的加上nums[j]
                    dp[i] += dp[i - nums[j]];
                }
                
            }
        }
        
        return dp[target];
    }

}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println("result: " + obj.combinationSum4(nums, 4));
	}
}