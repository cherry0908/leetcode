import java.io.*; 
import java.util.*; 

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        List<Integer> result = new ArrayList<Integer>();
        if (s == null|| p == null || lenS == 0 || lenP == 0 || lenS < lenP) return result;
        
        //int cnt = lenP, start = 0;
        // create hash map with string p
        int[] char_count = new int[26];
        for (int i = 0; i < lenP;  i++){
            char_count[p.charAt(i) - 'a']++;
        }
        
        int left = 0, right = 0, count = lenP;
        while (right < lenS) {
            
            // expand the sliding window
            if (char_count[s.charAt(right) - 'a'] >= 1) {
                count--;
            }
            char_count[s.charAt(right) - 'a']--;
            right++;
            
            // find the whole anagram
            if (count == 0) {
                result.add(left);
            }
            
            // once the window expends larger than the size of the anagram
            // we need to move one char from the left
            if (right - left == lenP) {
                // if the char is in anagram, add the count back
                if (char_count[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                
                char_count[s.charAt(left) - 'a']++;
                left++;
            }
        }
        
        return result;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        List<Integer> result = new ArrayList<Integer>();
        if (s == null|| p == null || lenS == 0 || lenP == 0 || lenS < lenP) return result;
        
        // create hash map with string p
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0, right = 0, count = lenP;
        
        for(int i = 0; i < lenP;  i++){
            char charP = p.charAt(i);
            map.put(charP, map.getOrDefault(charP, 0) + 1);
        }
        
        while(right < lenS){
            char tmpR = s.charAt(right);
            if(map.containsKey(tmpR) && map.get(tmpR) >= 1) {
                count--;
            }
            map.put(tmpR, map.getOrDefault(tmpR, 0) - 1);
            right++;
            
            // find the anagram
            if(count == 0){
                result.add(left);
            }
            
            // the length is larger than length of p, need to cut the left most character
            if(right - left == lenP){
                char tmpL = s.charAt(left);
                if(map.get(tmpL) >= 0) {
                    count++;
                }
                map.put(tmpL, map.get(tmpL) + 1);
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
        String s ="cbaebabacd";
        String p ="abc";
        int[] nums = {2,3,1,2,4,3};
        //System.out.println(s.substring(3,3+1));
        System.out.println("result: " + obj.findAnagrams(s, p));
	}
}