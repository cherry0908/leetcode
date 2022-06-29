public class Solution {
    class UnionFind {
        
        private int[] root;
        private double[] weight;
        
        public UnionFind(int size) {
            root = new int[size];
            // weight is the value of this node to its root
            weight = new double[size];
            
            for(int i = 0; i < size; i++) {
                // at first, root is itself
                root[i] = i;
                
                // at first, weight is always itself/itself = 1.0
                weight[i] = 1.0;
            }
        }
        
        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            
            // for now, don't implement the union by rank method, just make one as the other's root
            if(rootX != rootY) {
                // make rootY as the root of rootX
                root[rootX] = rootY;
                // update its weight
                // weight on rootX is rootX/rootY
                // weight[x] = x/rootX
                // weight[y] = y/rootY
                // value = x/y
                // weight[rootX] = rootX/rootY = (y/rootY)*(x/y)/(x/rootX) = weight[y]*value/weight[x]
                weight[rootX] = weight[y] * value / weight[x];
            }
        }
        
        public int find(int x) {
            // if x is not it's own root
            if(root[x] != x) {
                // store the intermediate root weigth
                int current = root[x];
                root[x] = find(root[x]);
                // when finished compressed the path, update the weight
                weight[x] = weight[x] * weight[current];
            }
            
            return root[x];
        }
        
        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            // if rootX == rootY means x and y are connected
            // weight[x] = x/rootX
            // weight[y] = y/rootY
            // x/y = weight[x]/weight[y]
            if(rootX == rootY) {
                return weight[x] / weight[y];
            }
            else {
                return -1.0;
            }
        }
    }
    
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if(equations == null || equations.size() == 0 || queries == null || queries.size() == 0) return null;
        
        // get the size of equations, the worst case is that all the pairs are different
        // the union find should be initialized with 2*size
        int size = equations.size();
        UnionFind uf = new UnionFind(2 * size);
        
        // key: variable, value: id
        // use id to represent variables in union find
        HashMap<String, Integer> map = new HashMap<>();
        int id = 0;
        
        for(int i = 0; i < equations.size(); i++) {
            // get the equation
            List<String> equation = equations.get(i);
            String val1 = equation.get(0);
            String val2 = equation.get(1);
            
            // insert the variables to hashmap
            if(!map.containsKey(val1)) {
                map.put(val1, id);
                id++;
            }
            if(!map.containsKey(val2)) {
                map.put(val2, id);
                id++;
            }
            
            // union the pair, with its value
            uf.union(map.get(val1), map.get(val2), values[i]);
        }
        
        // get the size of queries
        int querySize = queries.size();
        double[] result = new double[querySize];
        
        for(int i = 0; i < queries.size(); i++) {
            //get the query
            List<String> query = queries.get(i);
            Integer id1 = map.get(query.get(0));
            Integer id2 = map.get(query.get(1));
            
            if(id1 == null || id2 == null) {
                result[i] = -1.0;
            }
            else {
                result[i] = uf.isConnected(id1, id2);
            }
        }
        
        return result;
    }
}