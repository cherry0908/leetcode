class Solution {
    public int maxCoins(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        
        int n=nums.length;
        //init
        //add nums[-1]=1 and nums[n+1]=1
        int[] a = new int[n + 2];
        for (int i=0;i<n;++i){
            a[i+1]=nums[i];
        }
        a[0]=1;
        a[n+1]=1;
        int[][] f=new int[n+2][n+2];
        
        for(int len=1;len<=n;len++){
            //a[1...n] is the original nums array
            //i starts with 1
            //j=i+len-1
            //j ends with n
            //range of i is 1 to n-len+1
            for(int i=1;i<=n-len+1;i++){
                int j=i+len-1;
                f[i][j]=0;
                //f[i][j] is calculating the value from i to j
                //choose the balloon k to burst from i to j
                for(int k=i;k<=j;k++){
                    f[i][j]=Math.max(f[i][j],f[i][k-1]+f[k+1][j]+a[i-1]*a[k]*a[j+1]);
                }
            }
        }
        return f[1][n];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={3,1,5,8};
        System.out.println("result: " + obj.maxCoins(nums));
	}
}