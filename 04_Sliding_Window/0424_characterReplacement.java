import java.io.*; 
import java.util.*; 

class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if(s == null || len == 0) return 0;
        
        int start = 0, result = 0, count = 0, maxCount = 0;
        int[] char_count = new int[26];
        
        for(int i = 0; i < len; i++) {
            char_count[s.charAt(i) - 'A']++;
            maxCount = Math.max(maxCount, char_count[s.charAt(i) - 'A']);
            
            // i - start + 1 is the length of the current subarray, aka the window
            // if window length - maxCount is <= k, the subarray meet the requirement
            // if not, keep shrinking from the start
            int window = i - start + 1;
            while(window - maxCount > k) {
                char_count[s.charAt(start) - 'A']--;
                start++;
                window--;
            }
            
            result = Math.max(result, window);
        }
        
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "AABABBA";
        int[] nums = {2,3,1,2,4,3};
        System.out.println("result: " + obj.characterReplacement(s, 1));
	}
}