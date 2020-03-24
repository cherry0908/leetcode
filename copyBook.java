import java.util.*;

class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooksPreSum(int[] pages, int k) {
        if(pages==null||pages.length==0||k==0) return 0;
        int n=pages.length;
        if(k>n) k=n;
        
        // 前缀和
        int[] preSum = new int[n + 1];
        // 前0个数之和
        preSum[0] = 0;
        for (int i = 1; i <= n; ++i) {
            preSum[i] = preSum[i - 1] + pages[i - 1];
        }
        
        System.out.println(Arrays.toString(preSum));
        
        // 定义：dp[k][i] k个人copy前i本书最少需要的时间
        int[][] dp = new int[k + 1][n + 1];
        
        // 初始化
        // 1. copy 0 本书需要的时间为 0
        for(int i=0;i<=k;i++){
            dp[i][0]=0;
        }
        // 2. 0个人copy (>0) 本书的时间为 Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            dp[0][i]=Integer.MAX_VALUE;
        }
        
        // 转移方程
        for (int a = 1; a <= k; a++)
            for (int i = 1; i <= n; ++i) {
                dp[a][i] = Integer.MAX_VALUE;
                //前a-1个人抄j本书，最后第a个人抄A[j+1]+...+A[i-1]本书
                for (int j=0;j<i;j++) {
                    //preSum[i] - preSum[j] = A[j]+...A[i-1]
                    int time = Math.max(dp[a-1][j], preSum[i] - preSum[j]);
                    dp[a][i] = Math.min(dp[a][i], time);
                }
            }
            
        return dp[k][n];
    }

    public int copyBooks(int[] pages, int k) {
        if(pages==null||pages.length==0||k==0) return 0;
        int n=pages.length;
        if(k>n) k=n;
        
        //init 
        int[][] f=new int[k+1][n+1];
        
        for(int i=0;i<=k;i++){
            f[i][0]=0;
        }
        for(int i=1;i<=n;i++){
            f[0][i]=Integer.MAX_VALUE;
        }
        
        //first k people
        for(int a=1;a<=k;a++){
            //copy first i books
            for(int i=1;i<=n;i++){
                f[a][i]=Integer.MAX_VALUE;
                int s=0;
                for(int j=i;j>=0;j--){
                    //s=A[j]+...+A[i-1]
                    if(f[a-1][j]!=Integer.MAX_VALUE){
                        f[a][i]=Math.min(f[a][i], Math.max(f[a-1][j], s));
                    }
                    if(j>0){
                        s+=pages[j-1];
                    }
                }
            }
        }
        return f[k][n];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={2,3,4};
        System.out.println("result: " + obj.copyBooksPreSum(nums, 2));
	}
}