
import java.util.*;

public class Solution {

    class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;
        
        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            count = n;
            
            for(int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if(root[x] == x) return x;
            
            root[x] = find(root[x]);
            
            return root[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            // merge the two node
            if(rootX != rootY) {
                if(rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                }
                else if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                }
                else {
                    root[rootX] = rootY;
                    rank[rootX]++;
                }
                
                count--;
            }
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int getCount() {
            return count;
        }
    }
    
    
    public boolean validTree(int n, int[][] edges) {
        if(n == 0 || edges == null) return false;
        
        UnionFind uf = new UnionFind(n);
        
        // connect each node
        for(int i = 0; i < edges.length; i++) {
            // if the edge is already connected, this will make it a loop
            // so not a tree
            if(uf.isConnected(edges[i][0], edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        
        // there are multiple disconnected area
        if(uf.getCount() > 1) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{0,1},{0,2},{0,3},{1,4}};
	    boolean r = s.validTree(5, grid);
        System.out.println(r);
	}
}
