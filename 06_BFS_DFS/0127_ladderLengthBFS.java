import java.util.*;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null || wordList.size() == 0)  return 0;

        if(beginWord.equals(endWord)) return 0;

        HashSet<String> set = new HashSet<>();
        for(String s : wordList) {
            set.add(s);
        }

        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int result = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String curr = queue.poll();

                if(curr.equals(endWord)) {
                    return result;
                }

                char[] chars = curr.toCharArray();

                for(int j = 0; j < chars.length; j++) {
                    char org = chars[j];

                    for(int k = 97; k < 123; k++) {
                        chars[j] = (char) k;
                        String next = new String(chars);

                        if(set.contains(next)) {
                            queue.add(next);
                            set.remove(next);
                        }

                        chars[j] = org;
                    }
                }
            }

            result++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>();
        for(String str : strs) {
            wordList.add(str);
        }

        int r = s.ladderLength("hit", "cog", wordList);
        System.out.println(r);

    }
}