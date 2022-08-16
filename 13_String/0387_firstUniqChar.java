import java.util.*;

public class Solution{
    
    public int firstUniqChar1(String s) {
        if (s == null) return -1;
        
        char[] chars = s.toCharArray();
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
            }
            else {
                map.put(chars[i], -1);
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (map.get(chars[i]) != -1) {
                return i;
            }
        }
        
        return -1;
    }

    public int firstUniqChar(String s) {
        if (s == null) return -1;
        
        char[] chars = s.toCharArray();
        int len = s.length();
        int[] map = new int[26];
        
        for (int i = 0; i < len; i++) {
            map[chars[i] - 'a']++;
        }
        
        for (int i = 0; i < len; i++) {
            if (map[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.firstUniqChar("leetcode");
        System.out.println(r);
    }
}