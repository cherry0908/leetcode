import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)return 0;
        int n=prices.length;
        //init
        int min=prices[0];
        int result=0;
        //loop through everyday's price
        for(int i=1;i<n;i++){
            //calculate the profit between today's price and the lowest price before
            result=Math.max(prices[i]-min, result);
            //update the lowest price with today's price
            min=Math.min(prices[i], min);
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