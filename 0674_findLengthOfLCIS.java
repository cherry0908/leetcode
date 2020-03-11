import java.util.*;

class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    //lintcode 397. Longest Continuous Increasing Subsequence
    //Can be from right to left or from left to right.
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if(A==null||A.length==0)return 0;
        int n=A.length;
        int[] f=new int[n];
        int result=1;
        f[0]=1;
        for(int i=1;i<n;i++){
            f[i]=0;
            if(A[i]>A[i-1]){
                f[i]=f[i-1]+1;
            }
            else{
                f[i]=1;
            }
            result=Math.max(result,f[i]);
        }
        
        for(int i=1;i<n;i++){
            f[i]=0;
            if(A[i]<A[i-1]){
                f[i]=f[i-1]+1;
            }
            else{
                f[i]=1;
            }
            result=Math.max(result,f[i]);
        }
        return result;
    }

    //Leetcode 674 Longest Continuous Increasing Subsequence
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int n=nums.length;
        int[] f=new int[n];
        int result=1;
        f[0]=1;
        for(int i=1;i<n;i++){
            f[i]=0;
            if(nums[i]>nums[i-1]){
                f[i]=f[i-1]+1;
            }
            else{
                f[i]=1;
            }
            result=Math.max(result,f[i]);
        }
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1,3,5,4,7};
        System.out.println("result: " + obj.findLengthOfLCIS(nums));
	}
}