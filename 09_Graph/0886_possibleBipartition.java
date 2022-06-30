
import java.util.*;

public class Solution {
    
    public boolean dfsHelper(int i, HashMap<Integer, List<Integer>> graph, int[] colored, int color) {
        if(colored[i] == color) {
            return true;
        }
        
        if(colored[i] != 0 && colored[i] != color) {
            return false;
        }
        
        colored[i] = color;
        
        // recursive dfs
        // go through all the disliked people 
        List<Integer> list = graph.get(i);
        for(int dislike : list) {
            if(!dfsHelper(dislike, graph, colored, color * -1)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(n == 0 || dislikes == null) return false;
        if(dislikes.length == 0) return true;
        
        // create the graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < dislikes.length; i++) {
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            
            List<Integer> list = new ArrayList<>();
            if(graph.containsKey(a)) {
                list = graph.get(a);
            }
            list.add(b);
            graph.put(a, list);
            
            list = new ArrayList<>();
            if(graph.containsKey(b)) {
                list = graph.get(b);
            }
            list.add(a);
            graph.put(b, list);
        }
        
        // a group of n people (labeled from 1 to n)
        int[] colored = new int[n + 1];
        
        for(int i : graph.keySet()) {
            if(graph.get(i) != null && colored[i] == 0) {
                if(!dfsHelper(i, graph, colored, 1)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{1,2},{1,3},{2,4}};
	    boolean r = s.possibleBipartition(4, grid);
        System.out.println(r);
	}
}
