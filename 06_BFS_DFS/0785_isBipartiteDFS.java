
import java.util.*;

public class Solution {
    public boolean dfsHelper(int node, int[][] graph, int[] coloredGraph, int color) {
        // the node was colored with the correct color, return true
        if(coloredGraph[node] == color) {
            return true;
        }
        
        //the node was colored with the wrong color, return false
        if(coloredGraph[node] != 0 && coloredGraph[node] != color ) {
            return false;
        }
        
        //the node was not colored, so color the node
        coloredGraph[node] = color;
        
        // scan all the adjacent nodes
        // change the color to color 
        for(int i = 0; i < graph[node].length; i++) {
            if(!dfsHelper(graph[node][i], graph, coloredGraph, color * -1)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        if(graph == null | graph.length == 0) return false;
        
        // graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
        
        // A graph is bipartite if the nodes can be partitioned into two independent sets A and B 
        // such that every edge in the graph connects a node in set A and a node in set B.
        
        // use color method
        // color all the nodes with two colors, either -1 or 1
        
        int n = graph.length;
        int[] coloredGraph = new int[n];
        
        for(int i = 0; i < n; i++) {
            // scan each node that has not been colored
            if(coloredGraph[i] == 0) {
                if(!dfsHelper(i, graph, coloredGraph, 1)) {
                    return false;
                }
            }
        }
        
        return true;
    }


    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{1,2,3},{0,2},{0,1,3},{0,2}};
	    boolean r = s.isBipartite(grid);
        System.out.println(r);
	}
}
