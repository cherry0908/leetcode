import java.io.*; 
import java.util.*; 

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(s1 == null || s2 == null || len1 == 0 || len2 == 0) return false;
        
        int[] char_count = new int[26];
        for(int i = 0; i < len1; i++){
            char_count[s1.charAt(i) - 'a']++;
        }
        
        int start = 0, end = 0, count = len1;
        while(end < len2) {
            if(char_count[s2.charAt(end) - 'a'] >= 1) {
                count--;
            }
            char_count[s2.charAt(end) - 'a']--;
            end++;
            
            if(count == 0) {
                return true;
            }
            
            if(end - start == len1) {
                // if this char is in s1
                // its count was decreased in the first if
                // so now if this char appears once in s1, it should ==0
                // if this char appears more than once in s1, it should >0
                if(char_count[s2.charAt(start) - 'a'] >= 0) {
                    count++;
                }
                char_count[s2.charAt(start) - 'a']++;
                start++;
            }
        }
        
        return false;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "ab";
        String p = "eidbaooo";
        int[] nums = {2,3,1,2,4,3};
        //System.out.println(s.substring(3,3+1));
        System.out.println("result: " + obj.checkInclusion(s, p));
	}
}