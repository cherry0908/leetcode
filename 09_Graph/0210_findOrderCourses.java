
import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        
        if(numCourses == 0) return result;
        
        if(prerequisites == null || prerequisites.length == 0) {
            for(int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        // create the directed graph
        // assign indegree
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
        
        // find the node with indegree==0
        // add to a queue
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int index = 0;
        
        // go throught the queue
        while(!queue.isEmpty()) {
            int current = queue.poll();
            result[index] = current;
            index++;
            
            if(graph.containsKey(current)) {
                List<Integer> next = graph.get(current);
                
                for(int x : next) {
                    indegree[x]--;
                    if(indegree[x] == 0) {
                        queue.add(x);
                    }
                }
            }
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] > 0) {
                return new int[0];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{1,0}, {2,0}, {3,1}, {3,2}};
	    int[] r = s.findOrder(4, grid);
        for(int i = 0; i < r.length; i++) {
             System.out.print(i + ",");
        }
        System.out.println("");
	}
}
