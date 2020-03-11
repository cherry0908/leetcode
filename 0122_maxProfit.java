import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int result=0;
        int n=prices.length;
        for(int i=0;i<n-1;i++){
            // when tomorrow's price is higher than today's
            // buy today, sell tomorrow
            if(prices[i+1]>prices[i]){
                result+=prices[i+1]-prices[i];
            }
        }
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={7,1,5,3,6,4};
        System.out.println("result: " + obj.maxProfit(nums));
	}
}