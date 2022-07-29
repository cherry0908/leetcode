import java.util.*;

public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        if(n == 0) return null;
        
        // create two hashsets, graph[0] for red, graph[1] for blue
        HashSet<Integer>[][] graph = new HashSet[2][n];
        
        for(int i = 0; i < n; i++) {
            graph[0][i] = new HashSet<>();
            graph[1][i] = new HashSet<>();
        }
        
        // set all the edges with starting node
        // directed graph
        for(int[] red : redEdges){
            graph[0][red[0]].add(red[1]);
        }
        
        for(int[] blue : blueEdges){
            graph[1][blue[0]].add(blue[1]);
        }
        
        // length[0][i] means length of the shortest path from node 0 to node i for red edges
        // length[1][i] means length of the shortest path from node 0 to node i for blue edges
        // Zero edge is always accessible to itself - leave it as 0
        // the length cannot be larger than n*2
        // length[0][0] = 0, length[1][0] = 0
        int[][] length = new int[2][n];
        for(int i = 1; i < n; i++) {
            length[0][i] = n * 2;
            length[1][i] = n * 2;
        }
        
        // queue entries are node with a color
        // queue.poll()[0] means the current node
        // queue.poll()[1] means the color of the edge reaching to the current node
        Queue<int[]> queue = new LinkedList<>();
        // add both red and blue color of reaching node 0
        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int curr = node[0];
            int color = node[1];
            HashSet<Integer> neighbours = graph[1 - color][curr];
            
            // go through the set of nodes connecting to the current node as a different color
            for(int next : neighbours) {
                // the first time reaching this node
                // the length = the length of the current node + 1
                // add the next node to queue
                if(length[1 - color][next] == n * 2) {
                    length[1 - color][next] = length[color][curr] + 1;
                    queue.add(new int[]{next, 1 - color});
                }
            }
        }
        
        int[] result = new int[n];
        
        // get the min between red and blue
        // if the value == n*2, it means such a path does not exist
        for(int i = 0; i < n; i++) {
            int tmp = Math.min(length[0][i], length[1][i]);
            result[i] = (tmp == n * 2) ? -1 : tmp;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{0,1}};
        int[][] b = {{2,1}};

        int[] r = s.shortestAlternatingPaths(3, a, b);
        System.out.println(Arrays.toString(r));

    }
}