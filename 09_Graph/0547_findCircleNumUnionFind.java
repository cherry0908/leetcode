
import java.util.*;

public class Solution {
    
    class UnionFind {
        private int[] root;
        private int[] rank;
        private int numOfArea;
        
        public UnionFind(int size) {
            numOfArea = size;
            root = new int[size];
            rank = new int[size];
            
            for(int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        // find function is to find the root node of x
        public int find(int x) {
            // root node is itself
            if(root[x] == x) {
                return x;
            }
            
            // use recursion to traverse its parent node
            // meanwhile change its parent node to the root node directly
            root[x] = find(root[x]);
            
            //return the root nod of x
            return root[x];
        }
        
        // union function is to connect to node, x and y
        public void union(int x, int y) {
            // use find function to find the root node of both
            int rootX = find(x);
            int rootY = find(y);
            
            // if they don't have the same root node
            // they need to merge
            if(rootX != rootY) {
                // union by rank
                if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                }
                else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                }
                else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                
                numOfArea--;
            }
        }
        
        // check if x and y are connected
        public boolean isConnected(int x, int y) {
            // if x and y have the same root, they are connected
            return find(x) == find(y);
        }
        
        // get the number of disjoint set
        public int getNumOfArea() {
            return numOfArea;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        if(isConnected ==null || isConnected.length == 0) return 0;
        
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        
        return uf.getNumOfArea();
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{1,1,0},{1,1,0},{0,0,1}};
	    int r = s.findCircleNum(grid);
        System.out.println(r);
	}
}


