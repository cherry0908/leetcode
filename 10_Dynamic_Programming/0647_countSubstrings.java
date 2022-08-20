import java.util.*;

public class Solution {
    public int countSubstringsExpand(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int count = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < n; i++) {
            // odd number of length, one char in the middle
            int left = i;
            int right = i;
            while (left >= 0 && right < n) {
                if (chars[left] == chars[right]) {
                    count++;
                    left--;
                    right++;
                }
                else {
                    break;
                }
            }
            
            
            // even number of length, two chars in the middle
            left = i;
            right = i + 1;
            while (left >= 0 && right < n) {
                if (chars[left] == chars[right]) {
                    count++;
                    left--;
                    right++;
                }
                else {
                    break;
                }
            }
            
        }
        
        return count;
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        char[] chars = s.toCharArray();
        int count = 0;
        
        // dp initial
        // dp[i][j] means from s[i] to s[j], is it a palindrome
        boolean[][] dp = new boolean[n][n];
        
        // base case
        // dp[i][i] = true, count++
        // dp[i][i + 1] == true if chars[i] == chars[i + 1], count++
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
            if (i < n - 1 && chars[i] == chars[i + 1]) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        
        // dp[i][j] = dp[i + 1][j - 1] && chars[i] == chars[j] (j >= i + 2), count++
        // when length is 1 or 2, dp[][] is already initialized as the base case
        // starts with length is 3;
        // the order of i is from n to 0
        // the order of j is from 0 to n
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && chars[i] == chars[j];
                if (dp[i][j]) {
                   count++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.countSubstrings("abcba");
        System.out.println(r);
    }
}