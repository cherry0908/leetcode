import java.util.*;

class Solution {
    public int maxProfit(int k, int[] prices) {
        //there are 2*k+1 states
        //0:before the 1st buy
        //1:during the 1st hold
        //2:after the 1st sell before the 2nd buy
        //3:during the 2nd hold
        //4:after the 2nd sell
        //...
        //2*k-1:before k-th sell
        //2*k: after k-th sell
        //序列型,f[0] means the first 0 days, f[0...n], length is n+1
        
        if(prices==null||prices.length==0) return 0;
        int n=prices.length;
        int result=0;
        
        //k>n/2 means you can sell and buy as many times as you want 
        //122. Best Time to Buy and Sell Stock II
        if(k>n/2){
            for(int i=0;i<n-1;i++){
                if(prices[i+1]>prices[i]){
                    result+=prices[i+1]-prices[i];
                }
            }
            return result;
        }
        
        //init
        //0...n
        //0...2*k
        int[][] f=new int[n+1][2*k+1];
        f[0][0]=0;
        for(int j=1;j<2*k+1;j++){
            f[0][j]=Integer.MIN_VALUE;
        }
        
        for(int i=1;i<=n;i++){
            //i-th state 0, 2, 4: doesn't hold a stock
            //f[i][j]=max{f[i][j], f[i-1][j-1]+prices[i-1]-prices[i-2]}
            for(int j=0;j<2*k+1;j+=2){
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
            for(int j=1;j<2*k+1;j+=2){
                //i-1: keep the same state: not buying
                f[i][j]=f[i-1][j-1];
                //make sure the index of array is valid
                if(i>1&&f[i-1][j]!=Integer.MIN_VALUE){
                    //i-1: buy today
                    f[i][j]=Math.max(f[i][j], f[i-1][j]+prices[i-1]-prices[i-2]);
                }
                
            }
        }
        
        for(int j=0;j<2*k+1;j+=2){
            result=Math.max(result, f[n][j]);
        }
        
        return result;
    
    }

    //optimize
    public int maxProfitOptimized(int k, int[] prices) {
        //there are 2*k+1 states
        //0:before the 1st buy
        //1:during the 1st hold
        //2:after the 1st sell before the 2nd buy
        //3:during the 2nd hold
        //4:after the 2nd sell
        //...
        //2*k-1:before k-th sell
        //2*k: after k-th sell
        //序列型,f[0] means the first 0 days, f[0...n], length is n+1
        
        if(prices==null||prices.length==0) return 0;
        int n=prices.length;
        int result=0;
        
        //k>n/2 means you can sell and buy as many times as you want 
        //122. Best Time to Buy and Sell Stock II
        if(k>n/2){
            for(int i=0;i<n-1;i++){
                if(prices[i+1]>prices[i]){
                    result+=prices[i+1]-prices[i];
                }
            }
            return result;
        }
        
        //init
        //0...n
        //0...2*k
        //rolling array
        //because f[i][0...2k] only depends on f[i-1][0...2k]
        int[][] f=new int[2][2*k+1];
        int old, now=0;
        f[now][0]=0;
        for(int j=1;j<2*k+1;j++){
            f[now][j]=Integer.MIN_VALUE;
        }
        
        for(int i=1;i<=n;i++){
            //using rolling array, the first step in the for loop is exchange the value of old and now.
            //f[i][...] => f[now][...]
            //f[i-1][...] => f[old][...]
            old=now;
            now=1-now;
            //i-th state 0, 2, 4: doesn't hold a stock
            //f[i][j]=max{f[i][j], f[i-1][j-1]+prices[i-1]-prices[i-2]}
            for(int j=0;j<2*k+1;j+=2){
                //i-1: keep the same state: not selling
                f[now][j]=f[old][j];
                //make sure the index of array is valid
                if(j>0&&i>1&&f[old][j-1]!=Integer.MIN_VALUE){
                    //i-1: sell today
                    f[now][j]=Math.max(f[now][j], f[old][j-1]+prices[i-1]-prices[i-2]);
                }
            }
            
            //i-th stats 1,3: hold a stock
            //f[i][j]=max{f[i][j], f[i-1][j-1]+prices[i-1]-prices[i-2]}
            for(int j=1;j<2*k+1;j+=2){
                //i-1: keep the same state: not buying
                f[now][j]=f[old][j-1];
                //make sure the index of array is valid
                if(i>1&&f[old][j]!=Integer.MIN_VALUE){
                    //i-1: buy today
                    f[now][j]=Math.max(f[now][j], f[old][j]+prices[i-1]-prices[i-2]);
                }
                
            }
        }
        
        for(int j=0;j<2*k+1;j+=2){
            result=Math.max(result, f[now][j]);
        }
        
        return result;
    
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={2,4,1};
        System.out.println("result: " + obj.maxProfit(2,nums));
	}
}