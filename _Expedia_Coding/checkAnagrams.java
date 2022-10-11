import java.io.*; 
import java.util.*; 

class Solution {

    public boolean match(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();

        int n = char1.length;

        for (char c : char1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : char2) {
            if (!map.containsKey(c)) {
                return false;
            }

            int count = map.get(c) - 1;
            
            if (count == 0) {
                map.remove(c);
            }
        }

        return true;
    }

    public List<String> checkAnagrams(String str) {
        List<String> res = new ArrayList<>();

        str = str.toLowerCase();
        String[] s = str.split("\\W");
        int n = s.length;
        
        System.out.println(Arrays.toString(s));

        for (int i = 0; i < n - 1; i++) {
            if (s[i].length() <= 1) {
                continue;
            }
            
            boolean found = false;
            
            for (int j = i + 1; j < n; j++) {
                if (s[i].length() != s[j].length()) {
                    continue;
                }
                else {
                    found = found || match(s[i], s[j]);
                }
            }

            if (!found) {
                res.add(s[i]);
            }
        }

        return res;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution s = new Solution();
        
        String str = "CAme lAde Edal";
        List<String> res = s.checkAnagrams(str);
        System.out.println("result: " + res);
	}
}