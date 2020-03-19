import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        
        int n=prices.length;
        //init
        int[] hold=new int[n+1];
        int[] sold=new int[n+1];
        int[] rest=new int[n+1];
        hold[0]=Integer.MIN_VALUE;
        sold[0]=0;
        rest[0]=0;
        
        // 0...i-th day max value
        for(int i=1;i<n+1;i++){
            //if i-th day is in hold state
            hold[i]=Math.max(hold[i-1],rest[i-1]-prices[i-1]);
            //if i-th day is in sold state
            if(hold[i-1]!=Integer.MIN_VALUE){
                sold[i]=hold[i-1]+prices[i-1];
            }
            //if i-th day is in rest state
            rest[i]=Math.max(sold[i-1],rest[i-1]);
        }
        
        return Math.max(rest[n], sold[n]);
    }

    public int maxProfitOptimized(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        
        int n=prices.length;
        //init
        int hold=Integer.MIN_VALUE;
        int sold=0;
        int rest=0;
        
        // 0...i-th day max value
        for(int i=1;i<n+1;i++){
            int prev_sold=sold;
            int prev_hold=hold;
            hold=Math.max(hold, rest-prices[i-1]);
            if(prev_hold!=Integer.MIN_VALUE){
                sold=prev_hold+prices[i-1];
            }
            rest=Math.max(prev_sold, rest);   
        }
        
        return Math.max(rest, sold);
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1,2,3,0,2};
        System.out.println("result: " + obj.maxProfit(nums));
	}
}