import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        
        int n=nums.length;
        int result=0;
        int[] f=new int[n];
        //every f[i] can be calculated 
        //no need to init
        for(int i=0;i<n;i++){
            //every integer can be its own subsequence
            //by default 1
            f[i]=1;
            //loop through all previous nums[j], before nums[i]
            //find the longest 
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    f[i]=Math.max(f[j]+1, f[i]);
                }
            }
            result=Math.max(f[i],result);
        }
        return result;
    }
}
public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println("result: " + obj.lengthOfLIS(nums));
	}
}