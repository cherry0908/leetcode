
import java.util.*;

public class Solution {
    
    class UnionFind {
        private int[] root;
        private int[] rank;
        
        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            
            for(int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) { 
            if(root[x] == x) {
                return x;
            }
            
            root[x] = find(root[x]);
            
            return root[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if(rootX != rootY) {
                if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                }
                else if(rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                }
                else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
    
    
    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0) return false;
        
        // union find basically put the node and its adjacent nodes in two group
        // the node and its adjacent nodes shouldn't have the same root
        // scan all nodes
        // check if the node has the same root as its adjacent nodes
        // if not, then union all the adjacent nodes in the same group, which means they have the same root
        
        int n = graph.length;
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < n; i++) {
            if(graph[i].length != 0) {
                int x = uf.find(i);
                int y = uf.find(graph[i][0]);
                // if the root of the node is the same as the root of its adjacent node
                // it means the are in the same group
                // return false
                if(x == y) {
                    return false;
                }
                
                // if not, this node is in one group, all the adjacent node should be in another group
                for(int j = 1; j < graph[i].length; j++) {
                    int z = uf.find(graph[i][j]);
                    if(x == z) {
                        return false;
                    }
                    
                    // union the adjacent nodes
                    uf.union(graph[i][0], graph[i][j]);
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
