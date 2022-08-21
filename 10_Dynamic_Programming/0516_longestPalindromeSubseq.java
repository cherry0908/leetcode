import java.util.*;

public class Solution{

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        char[] str = s.toCharArray();
        
        // dp[i][j] means from i to j, the len of the longest palindromic subsequence
        int[][] dp = new int[n][n];
        
        // initialize
        for (int i = 0; i < n; i++) {
            // one letter
            dp[i][i] = 1;
            
            // two letters
            if (i < n - 1) {
                if (str[i] == str[i + 1]) {
                    dp[i][i + 1] = 2;
                }
                else {
                    dp[i][i + 1] = 1;
                }
            }
        }
        
        // starts with the length is 3
        // j = i + 2
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                // expand one letter on both left and right side of the sequence
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                
                // if the two added letters are the same, it can be a palindromic sequence
                // so add 2 to the dp[i + 1][j - 1]
                if (str[i] == str[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        
        // the result is from 0 to n-1
        return dp[0][n - 1];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.longestPalindromeSubseq("bbbab");
        System.out.println(r);
    }
}