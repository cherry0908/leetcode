// Find Duplicate Words in a Regular Expression in Java
import java.util.*;
  
public class Solution {
    
    class Node {
        private String word;
        private int count;
        
        public Node(String word, int count){
            this.count = count;
            this.word = word;
        }
    }
    
    public int findDuplpicate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        // convert all the upper case to lower case
        s = s.toLowerCase();
  
        // splitting words using regex
				// \W would match any non-word character
				// so its easy to try to use it to match word boundaries
				// it will split the string by any non-word character
        String[] words = s.split("\\W");
  
        // we are creating a Map for storing
        // strings and it's occurrence"
        Map<String, Integer> word_map = new HashMap<>();
  
        // Here we are iterating in words array and
        // increasing it's occurrence by 1.
        for (String word : words) {
						// skip the empty string
            if (word.length() == 0) {
                continue;
            }
            
            if (word_map.get(word) != null) {
                word_map.put(word, word_map.get(word) + 1);
            }
  
            // if the word came once then occurrence is 1.
            else {
                word_map.put(word, 1);
            }
        }
 
        System.out.println(word_map);
        
        // creating a keyset of word_map
        Set<String> word_set = word_map.keySet();
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (b.count - a.count));
        
        int total = 0;
  
        // We are iterating in word set
        for (String word : word_set) {
            // add each word to the priority queue with its count
            Node node = new Node(word, word_map.get(word));
            pq.add(node);
                
            // if word matched then checking occurrence
            if (word_map.get(word) > 1) {
                total = total + word_map.get(word) - 1;
                
                // here we are printing the duplicate words
                System.out.println(word + ": " + word_map.get(word));
            }
        }
        
        // print the words occurred the most time to least time
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            System.out.println(node.word + ": " + node.count);
        }
        
        return total;
    }
  
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // we have a expression
        String s = "The sun is the largest object in the solar system. It is the only star. And the sun is bright";
        
        int result = solution.findDuplpicate(s);
        
        System.out.println("total count of duplicates: " + result);
        
    }
}