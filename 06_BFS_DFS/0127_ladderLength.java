
import java.util.*;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null) return 0;
        
        if(beginWord.equals(endWord)) return 0;
        
        HashSet<String> wordSet = new HashSet<>();
        for(String s : wordList) {
            wordSet.add(s);
        }
        
        if(!wordSet.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        //HashSet<String> visited = new HashSet<>();
        int steps = 1;
        
        queue.add(beginWord);
        //visited.add(beginWord);
        if(wordSet.contains(beginWord)) {
            wordSet.remove(beginWord);
        }
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                String current = queue.poll();
                // System.out.println("current=" + current);
                // System.out.println("steps=" + steps);
                
                if(current.equals(endWord)) {
                    return steps;
                }
                
                char[] tmp = current.toCharArray();
                
                // for each character in the string
                for(int j = 0; j < tmp.length; j++) {
                    char old = tmp[j];
                    for(int k = 97; k < 123; k++) {
                        tmp[j] = (char) k;
                        String next = new String(tmp);
                        
                        if(wordSet.contains(next)) {
                            queue.add(next);
                            wordSet.remove(next);
                        }
                    }
                    
                    tmp[j] = old;
                }
            }
            
            steps++;
        }
        
        return 0;
    }


    public static void main(String[] args) {
	    Solution s = new Solution();
	    String[] strings = {"hot","dot","dog","lot","log","cog"};
        List<String> list = new ArrayList<>();
        for(String str : strings) {
            list.add(str);
        }
	    int r = s.ladderLength("hit", "cog", list);
        System.out.println(r);
	}
}
