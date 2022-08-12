import java.util.*;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (flights == null || flights.length == 0) return -1;
        
        // create a graph for the flights 
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            if (!graph.containsKey(flight[0])) {
                graph.put(flight[0], new ArrayList<>());
            }
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        int result = Integer.MAX_VALUE;
        
        // int[]: {node, cost, steps}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0, k + 1});
        
        // HashMap<>: {node, steps}
        HashMap<Integer, Integer> visited = new HashMap<>();
        
        while (!pq.isEmpty()) {
            // BFS by level, count the number of steps
            int[] top = pq.poll();
            int curr = top[0];
            int cost = top[1];
            int steps = top[2];
            
            if (visited.containsKey(curr) && visited.get(curr) >= steps) {
                continue;
            }
            
            visited.put(curr, steps);

            if (curr == dst) {
                result = Math.min(result, cost);
            }

            if (!graph.containsKey(curr)) {
                continue;
            }
            
            if (steps <= 0) {
                continue;
            }

            // scan all the adjacent nodes
            List<int[]> neighbours = graph.get(curr);
            for (int[] next : neighbours) {
                int newCost = next[1] + cost;

                if(newCost > result) {
                    continue;
                }
                
                // add the number of steps left
                pq.add(new int[]{next[0], newCost, steps - 1});
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
	    int r = s.findCheapestPrice(4, grid, 0, 3, 2);
        System.out.println(r);
	}
}