import java.util.*;

public class Solution {
    
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        
        int n = coins.length;
        int[] dp = new int[amount + 1];
        
        // store the coin used for each amount
        int[] usedCoin = new int[amount + 1];
        
        // initialize
        dp[0] = 0;
        
        // start with i = 1
        for (int i = 1; i < amount + 1; i++) {
            // for every amount number
            // initialize the max number of coins, assume 1 is the smallest
            dp[i] = amount + 1;
            usedCoin[i] = -1;
            
            // for every coin
            for (int j = 0; j < n; j++) {
                
                // use coins[j]
                // check if the amount is out of boundry
                // if we find a better solution
                if (i - coins[j] >= 0 && dp[i - coins[j]] + 1 < dp[i]) {
                    // update the dp[i] with the less number of coins
                    dp[i] = dp[i - coins[j]] + 1;
                    // update the usedCoin with the coin we use at this amount
                    // either store the index or store the coin denomination
                    // usedCoin[i] = coins[j];
                    usedCoin[i] = j;
                }
            }
        }
        
        // the result is dp[amount]
        // if the result is amount + 1, it's the max initialization
        // it means cannot be made up by any combination
        if (dp[amount] == amount + 1) {
            return -1;
        }
        
//         // return a list of coins used
//         List<Integer> list = new ArrayList<>();
        
//         // so we start with the last coin used for amount
//         int i = amount;
//         while (i > 0) {
//             // add the coin used for the current amount to the result list
//             list.add(usedCoin[i]);
            
//             // the current amount minus the coin we use
//             i = i - usedCoin[i];
//         }
        
//         // System.out.println(list);
        
        
//         // return an array the same size as coins
//         // each store the number of coins used
//         int[] count = new int[n];
        
//         int i = amount;
//         while (i > 0) {
//             int index = usedCoin[i];
//             count[index]++;
//             i = i - coins[index];
//         }
        
//         // System.out.println(Arrays.toString(count));
        
//         int count = dp[amount];
//         int[] result = new int[count];
//         int curr = amount;
        
//         for (int i = 0; i < count; i++) {
//             int index = usedCoin[curr];
//             result[i] = coins[index];
//             curr = curr - coins[index];
//         }
        
//         System.out.println(Arrays.toString(result));

        return dp[amount];
        
    }

    // use greedy algorithm
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        
        // Arrays.sort(coins);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = coins.length;
        int[] array = new int[n];
        int curr = amount, total = 0;;
        
        for (int i = 0; i < n; i++) {
            array[i] = curr / coins[i];
            total += array[i];
            
            curr = curr % coins[i];
        }
        
//         while (curr > 0 && i < n) {
//             int count = curr / coins[i];
//             map.put(coins[i], count);
//             total += count;
            
//             curr = curr % coins[i];
//             i++;
//         }
        
        System.out.println(Arrays.toString(array));
        // System.out.println(map);
        
        if (curr != 0) {
            return -1;
        }
        else {
            return total;
        }
    }
    
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[][] coordinates = {{0, 10}, {5, 20}, {20, -10}, {30, 0}};
        int[][] result = solution.fillMissingCoordinates(coordinates, 5);
        
        solution.print(coordinates);
        solution.print(result);
      
    }
}