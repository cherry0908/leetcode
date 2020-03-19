import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        //there are 5 states
        //0:before the 1st buy
        //1:during the 1st hold
        //2:after the 1st sell before the 2nd buy
        //3:during the 2nd hold
        //4:after the 2nd sell
        //序列型,f[0] means the first 0 days, f[0...n], length is n+1
        
        if(prices==null||prices.length==0) return 0;
        int n=prices.length;
        //init
        int[][] f=new int[n+1][5];
        f[0][0]=0;
        for(int k=1;k<5;k++){
            f[0][k]=Integer.MIN_VALUE;
        }
        
        for(int i=1;i<=n;i++){
            //i-th state 0, 2, 4: doesn't hold a stock
            //f[i][j]=max{f[i][j], f[i-1][j-1]+prices[i-1]-prices[i-2]}
            for(int j=0;j<5;j+=2){
                //i-1: keep the same state: not selling
                f[i][j]=f[i-1][j];
                //make sure the index of array is valid
                if(j>0&&i>1&&f[i-1][j-1]!=Integer.MIN_VALUE){
                    //i-1: sell today
                    f[i][j]=Math.max(f[i][j], f[i-1][j-1]+prices[i-1]-prices[i-2]);
                }
            }
            
            //i-th stats 1,3: hold a stock
            //f[i][j]=max{f[i][j], f[i-1][j-1]+prices[i-1]-prices[i-2]}
            for(int j=1;j<5;j+=2){
                //i-1: keep the same state: not buying
                f[i][j]=f[i-1][j-1];
                //make sure the index of array is valid
                if(i>1&&f[i-1][j]!=Integer.MIN_VALUE){
                    //i-1: buy today
                    f[i][j]=Math.max(f[i][j], f[i-1][j]+prices[i-1]-prices[i-2]);
                }
                
            }
        }
        
        return Math.max(Math.max(f[n][0], f[n][2]),f[n][4]);
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={3,3,5,0,0,3,1,4};
        System.out.println("result: " + obj.maxProfit(nums));
	}
}