
import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }
        
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        
        // add all unique letters in to the map
        // key is the letter, value is a new array list of next letters
        // initial indegree for each letter is 0
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                graph.put(word.charAt(i), new ArrayList<>());
                indegree.put(word.charAt(i), 0);
            }
        }
        
        // System.out.println(graph);
        // System.out.println(indegree);
        
        for(int i = 0; i < words.length - 1; i++) {
            // compare the two words: i and i+1
            String word1 = words[i];
            String word2 = words[i + 1];
            int j;
            int length = Math.min(word1.length(), word2.length());
            for(j = 0; j < length; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2) {
                    // add the next node in the graph
                    graph.get(c1).add(c2);
                    // the indegree of c2 letter increase 1
                    indegree.put(c2, indegree.get(c2) + 1);
                    break;
                }
            }
            
            // if the first word is longer than the second word
            // but the characters are the same
            // the two words are in invalid order
            // e.g {"abcd", "abc"}
            if(j == length && word1.length() > word2.length()) {
                return "";
            }
        }
        
        // System.out.println(graph);
        // System.out.println(Arrays.toString(indegree));
        
        Queue<Character> queue = new LinkedList<>();
        
        // add all the letters with indegree=0 to the queue
        for(char c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                queue.add(c);
            }
        }
        
        StringBuilder str = new StringBuilder();
        
        // go through the queue until it's empty
        while(!queue.isEmpty()) {
            char current = queue.poll();
            str.append(current);
            
            List<Character> nexts = graph.get(current);
            
            for(char next : nexts) {
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        
        //System.out.println(Arrays.toString(indegree));
        
        // if there are still letter's indegree>0, there is loop in the order
        // invalid, return ""
        for(char c : indegree.keySet()) {
            if(indegree.get(c) > 0) {
                return "";
            }
        }
        
        return str.toString();
        
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    String[] ss = {"wrt","wrf","er","ett","rftt"};
	    String r = s.alienOrder(ss);
        System.out.println(r);
	}
}
