
import java.util.*;

public class Solution {

    public int minMutation(String start, String end, String[] bank) {
        if(start == null || end == null || bank == null || bank.length == 0) return -1;
        
        if(start.equals(end)) return 0;
        
        HashSet<String> set = new HashSet<>();
        for(String str : bank) {
            set.add(str);
        }
        
        if(!set.contains(end)) return -1;
        
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int mutations = 0;
        
        queue.add(start);
        visited.add(start);
                       
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            // for the next index level of BFS
            for(int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if(current.equals(end)) {
                    return mutations;
                }
                
                char[] tmp = current.toCharArray();
                
                // replace every postion of the char[] with the 4 gene characters in 
                for(int j = 0; j < current.length(); j++) {
                    char old = tmp[j];
                    
                    for(char c : chars) {
                        tmp[j] = c;
                        String next = new String(tmp);
                        
                        // if the mutation is valid and is not visited
                        if(set.contains(next) && !visited.contains(next)) {
                            queue.add(next);
                            set.add(next);
                        }
                    }
                    
                    tmp[j] = old;
                }
            }
            
            mutations++;
        }
        
        return -1;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    String[] strings = {"AAAACCCC","AAACCCCC","AACCCCCC"};
	    int r = s.minMutation("AAAAACCC", "AACCCCCC", strings);
        System.out.println(r);
	}
}
