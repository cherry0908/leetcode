import java.io.*; 
import java.util.*; 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(s == null || len == 0) return 0;
        int start = 0, result = 0;
        // (character, index)
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
            }
            else{
                int index = map.get(c);
                // attention!! choose the larger index for the start
                start = Math.max(start, index + 1);
                map.replace(c, i);
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s="abba";
        System.out.println("result: " + obj.lengthOfLongestSubstring(s));
	}
}