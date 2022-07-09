
import java.util.*;

public class Solution {
    
    class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;
        
        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            count = 0;
            
            for(int i = 0; i < n; i++) {
                root[i] = -1;
                rank[i] = 0;
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
                count--;
            }
        }
        
        public void add(int x){
            root[x] = x;
            count++;
        }
        
        public boolean isLand(int x) {
            return root[x] >= 0;
        }
        
        public int getCount() {
            return count;
        }
        
        public void printRoot() {
            for(int i = 0 ; i < root.length; i++) {
                System.out.print(root[i] + ", ");
            }
            System.out.println("");
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if(positions == null || positions.length == 0) return null;
        
        List<Integer> result = new ArrayList<>();
        
        // use i*n+j as the id in UnionFind
        // total number of id will be m*n
        UnionFind uf = new UnionFind(m * n);
        
        // for each position
        for(int[] position : positions) {
            int i = position[0];
            int j = position[1];
            
            List<Integer> list = new ArrayList<>();
            
            // for 4 directions, if the neighbor is a valid land, add to the list
            // within the boundries
            // is a valid land
            if(i - 1 >= 0 && uf.isLand((i - 1) * n + j)) {
                list.add((i - 1) * n + j);
            }
            if(i + 1 < m && uf.isLand((i + 1) * n + j)) {
                list.add((i + 1) * n + j);
            }
            if(j - 1 >= 0 && uf.isLand(i * n + j - 1)) {
                list.add(i * n + j - 1);
            }
            if(j + 1 < n && uf.isLand(i * n + j + 1)) {
                list.add(i * n + j + 1);
            }
            
            // System.out.println(Arrays.toString(list.toArray()));
            
            // add the current position as a new land
            // if the current is already a land, don't add a new land
            int index = i * n + j;
            if(!uf.isLand(index)) {
                uf.add(index);
            }
            
            // union the land around the current position
            for(int l : list) {
                uf.union(l, index);
            }
            
            result.add(uf.getCount());
        }
        
        return result;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[][] grid = {{0,0},{0,1},{1,2},{2,1}};
	    List<Integer> r = s.numIslands2(3, 3, grid);
        System.out.println(Arrays.toString(r.toArray()));
	}
}
