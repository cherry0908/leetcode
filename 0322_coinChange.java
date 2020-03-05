import java.util.*;

class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        // 0...amount
        int[] f=new int[amount+1];
        f[0]=0;
        
        // f[1], f[2], ... f[amount] do in order
        // if<Max, update f[i]
        for(int i=1;i<=amount;i++){
            f[i]=Integer.MAX_VALUE;
            // for the last step, try with all the coins
            // f[i]=min{f[i-coins[0]]+1, f[i-coins[1]]+1, ... f[i-coins[length-1]]+1}
            for(int j=0;j<coins.length;j++){
                // i-coins[j]>=0, only do for f[1] to f[amount]
                // f[i-coins[j]]!=MAX, only do when the previous step has the solution
                if(i-coins[j]>=0&&f[i-coins[j]]!=Integer.MAX_VALUE){
                   f[i]=Math.min(f[i-coins[j]]+1,f[i]); 
                }
            }
        }
        
        // find no solution
        if(f[amount]==Integer.MAX_VALUE) return -1;
        else return f[amount];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1, 2, 5};
        System.out.println("result: " + obj.coinChange(nums, 11));
	}
}
