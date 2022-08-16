import java.util.*;

public class Solution{
    public int romanToInt(String s) {
        if (s == null) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int len = s.length();
        char[] chars = s.toCharArray();
        int result = 0;
        int i = 0;
        
        while (i < len) {
            if (i + 1 < len && map.get(chars[i]) < map.get(chars[i + 1])) {
                result = result + map.get(chars[i + 1]) - map.get(chars[i]);
                i = i + 2;
            }
            else {
                result = result + map.get(chars[i]);
                i++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.romanToInt("MCMXCIV");
        System.out.println(r);
    }
}