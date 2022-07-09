
import java.util.*;

public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n == 0) return result;
        
        // n=1, result={0}
        // n=2, result={0,1}
        if(n < 2) {
            for(int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        
        // build the graph
        List<HashSet<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            graph.add(i, set);
        }
        
        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        // find all the leaves and add to the queue
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() == 1) {
                queue.add(i);
            }
        }
        
        // when the remaining node is 1 or 2, stop
        int remainingNode = n;
        while(remainingNode > 2) {
            // based on each level
            // so you need to get the size of the queue
            // trim the entire batch of leaves
            int size = queue.size();
            remainingNode = remainingNode - size;
            
            // go through each leaf at this level
            for(int i = 0; i < size; i++) {
                // get each leaf
                int leaf = queue.poll();
                
                // find its adjacent nodes in the graph
                HashSet<Integer> neighbors = graph.get(leaf);
                
                // remove the connection
                for(int neighbor : neighbors) {
                    graph.get(leaf).remove(neighbor);
                    graph.get(neighbor).remove(leaf);
                    
                    // after removing the edge, if the node becomes a leaf, add it to the queue
                    if(graph.get(neighbor).size() == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        
        // when there are 1 or 2 nodes left in the queue
        // that's the result
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }
        
        return result;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{1,0},{1,2},{1,3}};
	    List<Integer> r = s.findMinHeightTrees(4, grid);
        System.out.println(Arrays.toString(r.toArray()));
	}
}
