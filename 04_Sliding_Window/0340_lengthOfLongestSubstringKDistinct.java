import java.io.*; 
import java.util.*; 

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if(s == null || len == 0 || k == 0) return 0;

        int[] map  = new int[256];
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        int distCnt = 0;

        for(int i = 0; i < len; i++) {
            // check if the character is distinct in the map
            // if yes, increase the distCnt
            if(map[s.charAt(i)] == 0) {
                distCnt++;
            }
            // add the character in the map
            map[s.charAt(i)]++;

            // if the number of distinct character is smaller than or equals to k
            // update the result
            if(distCnt <= k) {
                maxLen = Math.max(maxLen, i - left + 1);
            }
            
            // when the number of distinc character is larger than k
            while(distCnt > k) {
                // remove the character from the map
                map[s.charAt(left)]--;
                // check if the character is totally removed from the map
                // if yes, decrease the distCnt
                if(map[s.charAt(left)] == 0) {
                    distCnt--;
                }
                //move the left pointer
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
        System.out.println("result: " + obj.lengthOfLongestSubstringKDistinct(s, 2));
	}
}