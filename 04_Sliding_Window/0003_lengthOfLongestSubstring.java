import java.io.*; 
import java.util.*; 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        char[] chars = s.toCharArray();
        int len = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            char next = chars[i];
            
            // if the next char is not in the map, means it not repeated
            if (!map.containsKey(next)) {
                // add the new char and its index to the map
                map.put(next, i);
            }
            // if the next char is in the map, means it is repeated
            else {
                // get the index of the repeated char in the map
                int index = map.get(next);
                // update the map with the new index of the repeated char
                map.put(next, i);
                
                // find the larger start
                // if the current start is larger than the repeated char index in the map 
                // you can ignore the repeated char and use the current start
                // if the current start is smaller
                // you need to use the repeated char index + 1 ans the start
                start = Math.max(start, index + 1);
            }
            
            len = Math.max(len, i - start + 1);
        }
        
        return len;
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