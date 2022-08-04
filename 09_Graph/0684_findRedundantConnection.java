import java.util.*;

public class Solution {
    
    public class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;
        
        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
            
            count = n;
        }
        
        public int find(int x) {
            if(root[x] == x) {
                return root[x];
            }
            
            root[x] = find(root[x]);
            
            return root[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return;
            }
            
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            }
            else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            }
            else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
            
            count--;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0) return new int[2];
        
        // calculate n from the edges
        // You are given a graph that started as a tree 
        // with n nodes labeled from 1 to n, 
        // with one additional edge added.
        // total n edges
        
        // System.out.print(n);
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        
        for(int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
            else {
                uf.union(edge[0], edge[1]);
            }
        }
        
        return new int[2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] r = s.findRedundantConnection(edges);
        System.out.println("result: " + r[0] + ", " + r[1]);
    }
}