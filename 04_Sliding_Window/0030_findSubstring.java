import java.io.*; 
import java.util.*; 

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length(), n = words.length;
        if(sLen == 0 || n == 0 || s == null || words == null) return null;

        int wLen = words[0].length();
        List<Integer> result = new ArrayList<Integer>();

        // Create a hashmap with the words list, value is the number of times appearing in the list
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < n; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        // loop through each character
        // when the rest of the s string is shorter than sLen - n* wLen
        // which means the rest of the string cannot consist all the words in the list, stop
        for(int i = 0; i <= sLen - n * wLen; i++) {
            // create a new hashmap to remember the words in s
            HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
            int j = 0;
            // loop through every substring, lenght is wLen, should have n substrings
            for(j = 0; j < n; j++) { 
                String tmp = s.substring(i + wLen * j, i + wLen * (j + 1));
                if(!map.containsKey(tmp)) {
                    break;
                }
                wordsCount.put(tmp, wordsCount.getOrDefault(tmp, 0) + 1);
                if(map.get(tmp) < wordsCount.get(tmp)) {
                    break;
                }
            }
            
            // j == n means every substrings in s matches the words list
            if(j == n) {
                result.add(i);
            }
        }
        
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        System.out.println("result: " + obj.findSubstring(s, words));
	}
}