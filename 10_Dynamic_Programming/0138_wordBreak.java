import java.util.*;

public class Solution {
    public boolean helper(String s, int start, int[] memo, HashSet<String> set) {
        // if start reaches the end of the string
        // empty string return true
        if (start == s.length()) {
            return true;
        }
        
        // if the value already cached, return from memo
        if (memo[start] == 0) {
            return false;
        }
        if (memo[start] == 1) {
            return true;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            // the begin index, inclusive
            // the end index, exclusive
            // the first part of the string
            String sub = s.substring(start, end);
            
            // check if the first part of the string is in set
            // and recusively check the second part of the string
            // set the memo
            if(set.contains(sub) && helper(s, end, memo, set)) {
                memo[start] = 1;
                return true;
            }
        }
        
        // with this start index, if for all the end doesn't work, return false
        memo[start] = 0;
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        if (wordDict == null || wordDict.size() == 0) return false;
        
        HashSet<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        
        int len = s.length();
        int[] memo = new int[len];
        Arrays.fill(memo, -1);
        
        return helper(s, 0, memo, set);
        
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        boolean r = s.wordBreak("leetcode", dict);
        System.out.println(r);
    }
}