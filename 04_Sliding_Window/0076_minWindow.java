import java.io.*; 
import java.util.*; 

class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        String result = "";
        if(s == null || t == null || sLen == 0 || tLen == 0) return result;
        
        // 128 characters in ASCII
        int[] charCnt = new int[128];
        int left = 0;
        int foundCharCnt = 0;
        int minLeft = -1;
        int minLen = Integer.MAX_VALUE;

        // loop t, charCnt++ when char appears in t
        for(int i = 0; i < tLen; i++) {
            charCnt[t.charAt(i)]++;
        }

        // loop s
        for (int right = 0; right < sLen; right++) {
            // charCnt-- for each char
            charCnt[s.charAt(right)]--;
            // when char is in t (charCnt >= 0), foundCharCnt++
            if (charCnt[s.charAt(right)] >= 0) {
                foundCharCnt++;
            }
            
            // when all chars in t have been found (foundCharCnt == tLen)
            while (foundCharCnt == tLen) {
                // record the minLen and minLeft
                int curLen = right - left + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    minLeft = left;
                    result = s.substring(minLeft, minLeft + minLen);
                }
                
                // charCnt++ for each char when move the left pointer
                charCnt[s.charAt(left)]++;
                // if char at pointer left is in t (charCnt > 0), foundCharCnt--
                if (charCnt[s.charAt(left)] > 0) {
                    foundCharCnt--;
                }
                // shrink left pointer
                left++;
            }
        }
        
        return result;
    }
}


public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("result: " + obj.minWindow(s, t));
	}
}