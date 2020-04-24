import java.util.*;

class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0) return 0;
        int n=s.length();
        int M=1000000007;
        long[] dp = new long[n+1];
        char[] ss =s.toCharArray();
        
        dp[0] = 1;
        if (ss[0] == '0') return 0;
        dp[1] = (ss[0] == '*') ? 9 : 1;
        for (int i = 2; i <= n; ++i) {
            if (ss[i - 1] == '0') {
                if (ss[i - 2] == '1' || ss[i - 2] == '2') {
                    dp[i] += dp[i - 2];
                } else if (ss[i - 2] == '*') {
                    dp[i] += 2 * dp[i - 2];
                } else {
                    return 0;
                }
            } else if (ss[i - 1] >= '1' && ss[i - 1] <= '9') {
                dp[i] += dp[i - 1];
                if (ss[i - 2] == '1' || (ss[i - 2] == '2' && ss[i - 1] <= '6')) {
                    dp[i] += dp[i - 2];
                } else if (ss[i - 2] == '*') {
                    dp[i] += (ss[i - 1] <= '6') ? (2 * dp[i - 2]) : dp[i - 2];
                }
            } else { // s[i - 1] == '*'
                dp[i] += 9 * dp[i - 1];
                if (ss[i - 2] == '1') dp[i] += 9 * dp[i - 2];
                else if (ss[i - 2] == '2') dp[i] += 6 * dp[i - 2];
                else if (ss[i - 2] == '*') dp[i] += 15 * dp[i - 2];
            }
            dp[i] %= M;
        }
        return (int)dp[n];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s="*";
        System.out.println("result: " + obj.numDecodings(s));
	}
}