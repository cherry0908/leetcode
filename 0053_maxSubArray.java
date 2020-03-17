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

    public int maxSubArrayDP(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length;
        int[] f=new int[n];
        f[0]=nums[0];
        int result=f[0];
        for(int i=1;i<n;i++){
            f[i]=Math.max(f[i-1]+nums[i],nums[i]);
            result=Math.max(result,f[i]);
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
