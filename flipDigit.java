import java.util.*;

class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        
        int n=nums.length;
        //init
        int[][] f=new int[n+1][2];
        f[0][0]=0;
        f[0][1]=0;
        
        //first i digits: nums[0]...nums[i-1]
        for(int i=1;i<n+1;i++){
            for(int j=0;j<2;j++){
                f[i][j]=Integer.MAX_VALUE;
                int t=0;
                //nums[i-1]-->j, should I flip?
                if(nums[i-1]!=j)t=1;
                //nums[i-1]-->k
                for(int k=0;k<2;k++){
                    //"01" is not valid
                    if(k==0&&j==1)continue;
                    else f[i][j]=Math.min(f[i-1][k]+t, f[i][j]);
                }
            }
        }
        return Math.min(f[n][0],f[n][1]);
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1,0,0,1,1,1};
        System.out.println("result: " + obj.flipDigit(nums));
	}
}