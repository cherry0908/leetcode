import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean[] f=new boolean[n];
        f[0]=true;
        
        for(int i=1;i<n;i++){
            f[i]=false;
            //loop previous all positions from 0 to j
            //last jump is from j to i
            for(int j=0;j<i;j++){
                //j can be jumped AND j can jump to i means i can be jumped
                //only need to find one and set to true
                if(f[j]&&nums[j]+j>=i){
                    f[i]=true;
                    break;
                }
            }
        }
        return f[n-1];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={2,3,1,1,4};
        System.out.println("result: " + obj.canJump(nums));
	}
}