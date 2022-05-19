import java.io.*; 
import java.util.*; 

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if(s == null || len == 0) return 0;
        
        int[] map = new int[256];
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        int distCnt = 0;
        
        for(int i = 0; i < len; i++) {
            // check the character in the map
            if(map[s.charAt(i)] == 0) {
                distCnt++;
            }
            // add the character
            map[s.charAt(i)]++;
            
            // if at most two distinct characters
            // 1 or 2
            if(distCnt <= 2) {
                maxLen = Math.max(maxLen, i - left + 1);
            }
            
            // if more than 2 distinct characters
            // move the left pointer until there's at most two distinct characters
            while(distCnt > 2) {
                map[s.charAt(left)]--;
                // if the character cnt decrease to 0, totally removed
                // distCnt--
                if(map[s.charAt(left)] == 0) {
                    distCnt--;
                }
                
                // move the left pointer
                left++;
            }
        }
        
        return maxLen;
    }
}


public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "eceba";
        String t = "ABC";
        System.out.println("result: " + obj.lengthOfLongestSubstringTwoDistinct(s));
	}
}