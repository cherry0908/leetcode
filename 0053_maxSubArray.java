import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int result=Integer.MIN_VALUE, sum=0;
        for(int num : nums){
            sum=Math.max(sum+num,num);
            result=Math.max(result, sum);
        }
        return result;
    }

    public int maxSubArrayDividConquer(int[] nums){

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
