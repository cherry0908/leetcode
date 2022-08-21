import java.io.*; 
import java.util.*; 

class Solution {

    /*
    Dynamic Programming
     */

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        int n = s.length();
        char[] str = s.toCharArray();
        
        // for the result longest palindrome string
        // update the start index and the length of the string
        int start = 0, len = 1;
        
        // dp[i][j] means the substring from i to j is a palindrome or not
        boolean[][] dp = new boolean[n][n];
        
        // initialize
        for (int i = 0; i < n; i++) {
            // one character is always a palindrome
            dp[i][i] = true;
            
            // two charatcters are the same
            if (i < n - 1 && str[i] == str[i + 1]) {
                dp[i][i + 1] = true;
                
                // update the start and length if applicable
                if (len < 2) {
                    start = i;
                    len = 2;
                }
            }
        }
        
        // len starts from 3
        // to calculate dp[i][j], it needs to know dp[i + 1][j - 1]
        // i starts from the end
        // j starts from i + 2
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && str[i] == str[j];
                
                // update the start and the length if applicable
                if (dp[i][j] && len < j - i + 1) {
                    start = i;
                    len = j - i + 1;
                }    
            }
        }
        
        // System.out.println("start=" + start + ", len=" + len);
        return s.substring(start, start + len);
    }

    /*
    Expand the string for each letter
     */
    
    public String getPalindrome(String s, int index) {
        // substring(begin, end), begin is inclusive, end is exclusive
        
        // length of palindrome is odd number
        int left = index, right = index;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            else {
                break;
            }
        }
        String s1 = s.substring(left + 1, right);
        
        // length of palindrome is even number
        if (index + 1 < s.length() && s.charAt(index) == s.charAt(index + 1)) {
            left = index;
            right = index + 1;
        }
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            else {
                break;
            }
        }
        String s2 = s.substring(left + 1, right);
        
        return s1.length() > s2.length() ? s1 : s2;
    }
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            String curr = getPalindrome(s, i);
            if (curr.length() > result.length()) {
                result = curr;
            }
        }
        
        return result;
    }

}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s="sss";
        //System.out.println(s.substring(3,3+1));
        System.out.println("result: " + obj.longestPalindrome(s));
	}
}