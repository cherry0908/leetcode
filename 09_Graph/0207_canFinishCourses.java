
import java.util.*;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();;
        int[] indegree = new int[numCourses];
        
        // create the graph
        // assign the indegree
        for(int[] prerequisite : prerequisites) {
            int first = prerequisite[1];
            int second = prerequisite[0];
            
            List<Integer> list = new ArrayList<>();
            
            if(graph.containsKey(first)) {
                list = graph.get(first);
            }
            list.add(second);
            graph.put(first, list);
            
            indegree[second]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        // add node whose indegree is 0 to the queue
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // scan throught the queue until it's empty
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            // get the following courses of the current
            if(graph.containsKey(current)) {
                List<Integer> next = graph.get(current);
                
                // the indegree of the next courses need to minus 1
                // if indegree is 0, add to the queue
                for(int x : next) {
                    indegree[x]--;
                    if(indegree[x] == 0) {
                        queue.add(x);
                    }
                }
            } 
        }
        
        // scan the array
        // if any node has a indegree of 1, means cannot finish the course
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] > 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{0,1}};
	    boolean r = s.canFinish(2, grid);
        System.out.println(r);
	}
}
