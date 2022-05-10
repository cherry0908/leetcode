import java.io.*; 
import java.util.*;

class Solution {
    public int minSubArrayLen1(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        int minL = Integer.MAX_VALUE;
        //Initialize j to 0 and sum to 0
        //j is global variable, only move forward
        int j = 0, sum = 0;
        
        for(int i = 0; i < n; i++){
            // while left < n && sum < s
            // doesn't satisfy both condition
            // keep adding nums to sum
            // keep incrementing j
            while(j < n && sum < s){
                sum += nums[j];
                j++;
            }
            // when hitting either condition
            // by now j already ++
            if(sum >= s){
                minL = Math.min(minL, j - i);
            }
            // subtract the first nums[i] from sum to see if it can meet the condition
            sum -= nums[i];
        }
        
        if(minL == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return minL;
        }
    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        int sum = nums[0], result = Integer.MAX_VALUE, start = 0, end = 0;
        while(end < len){
            if(sum < target){
                end++;
                if(end >= len){
                    break;
                }
                sum = sum + nums[end];
            }
            else{
                result = Math.min(result, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
        }
        if(result == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return result;
        }
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println("result: " + obj.minSubArrayLen(target, nums));
	}
}

