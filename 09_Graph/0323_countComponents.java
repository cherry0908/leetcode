
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
            for(int i = 0; i < n; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if(root[x] == x) return x;
            
            // recursive find the root and change it
            root[x] = find(root[x]);
            
            return root[x];
        }
        
        public void union(int x, int y) {
            // find the root of each node
            int rootX = find(x);
            int rootY = find(y);
            
            // connect the two node
            if(rootX != rootY) {
                if(rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                }
                else if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                }
                else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                
                // coonect two components
                count--;
            }
        }
        
        public int getCount() {
            return count;
        }
    }
    
    
    public int countComponents(int n, int[][] edges) {
        if(n == 0 || edges == null) return 0;
        
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
        
        return uf.getCount();
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{0,1},{2,1},{2,0},{2,4}};
	    int r = s.countComponents(5, grid);
        System.out.println(r);
	}
}
