
import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if (times == null || times.length == 0 || n == 0) return -1;
        
        // convert the times array to a directed graph
        // hashmap, key: node, value: a map of all adjacent node
        // inside hashmap, key: adjacent node, value: travel time
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        
        for (int[] time : times) {
            if (!graph.containsKey(time[0])) {
                graph.put(time[0], new HashMap<>());
            }
            graph.get(time[0]).put(time[1], time[2]);
        }
        
        // the distance from node i to node k
        // the final result is the largest of the value in array except the MAX_VALUE
        int[] dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        
        // System.out.println(graph);
        
        // use priority queue so that every time the top one has the shortest path
        // int[]: [0]: the distance from K to node, [1]: the node 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // the first distance in the priority queue is {0, itself}
        pq.add(new int[]{0, k});
        
        boolean[] visited = new boolean[n + 1];
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int currNode = curr[1];
            
            if (visited[currNode]) {
                continue;
            }
            
            if (currDist > dist[currNode]) {
                continue;
            }
            
            if (!graph.containsKey(currNode)) {
                continue;
            }
            
            // visit current
            visited[currNode] = true;
            // find all its adjacent nodes
            HashMap<Integer, Integer> neighbours = graph.get(currNode);
            
            for (int next : neighbours.keySet()) {
                int nextDist = neighbours.get(next) + currDist;
                // currDist is the distance from current node to original target node
                // get(next) is the distance from the next node to the current node
                // add them up is the distance from the next node to the target node
                if (dist[next] > nextDist) {
                    dist[next] = nextDist;
                    pq.add(new int[]{nextDist, next});
                }
            }
        }
        
        // find the max value in the dist[] array
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            result = Math.max(result, dist[i]);
        }
        
        // if there is node cannot be reached, the dist is MAX_VALUE, then return -1
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{2,1,1},{2,3,1},{3,4,1}};
	    int r = s.networkDelayTime(grid, 4, 2);
        System.out.println(r);
	}
}