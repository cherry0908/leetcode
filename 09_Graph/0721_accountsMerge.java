class Solution {
    
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
            if(x == root[x]) return x;
            
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
                else if(rank[rootY] > rank[rootX]) {
                    root[rootX] = rootY;
                }
                else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                
                count--;
            }
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int[] getRoot() {
            return root;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts == null || accounts.size() == 0) return null;
        
        // hash map to store each email with its name
        HashMap<String, String> nameMap = new HashMap<>();
        
        // use id to represent email in union find
        int id = 0;
        ArrayList<String> emails = new ArrayList<>(); 
        
        // email id map
        HashMap<String, Integer> idMap = new HashMap();
        
        int size = accounts.size();
        int n = 0;
        for(int i = 0; i < size; i++) {
            n = n + accounts.get(i).size() - 1;
        }
        
        // init UnionFind
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < size; i++) {
            List<String> account = accounts.get(i);
            int length = account.size();
            String name = account.get(0);
            int rootId = -1;
            for(int j = 1; j < length; j++) {
                String email = account.get(j);
                //System.out.println(email);
                if(j == 1) {
                    if(!idMap.containsKey(email)) {
                        rootId = id;
                    }
                    else {
                        rootId = idMap.get(email);
                    }
                    //System.out.println("i: " + i + ", j: " + j + ", rootId: " + rootId);
                }
                if(!nameMap.containsKey(email)) {
                    //System.out.println("email: " + email + ", id: " + id + ", union with rootId: " + rootId);
                    nameMap.put(email, name);
                    emails.add(id, email);
                    idMap.put(email, id);
                    uf.union(id, rootId);
                    id++;
                }
                else {
                    //System.out.println("exisitnig email: " + email + ", id: " + idMap.get(email) + ", union with rootId: " + rootId);
                    uf.union(idMap.get(email), rootId);
                }
            }
        }
        
        // get the root
        //int[] root = uf.getRoot();
        
        //System.out.println(uf.getCount());
        //System.out.println("is 0 and 1 connected: " + uf.isConnected(0,1));
        
        // the result
        HashMap<Integer, ArrayList<String>> result = new HashMap<Integer, ArrayList<String>>();
        
        // the length of root array is always equals or larger than the actual union find size
        for(int i = 0; i < id; i++) {
            //System.out.println(root[i]);
            // i represent email
            // root[i] represent root email
            int root = uf.find(i);
            String email = emails.get(i);
            if(!result.containsKey(root)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(email);
                result.put(root, list);
            }
            else {
                ArrayList<String> list = result.get(root);
                list.add(email);
                result.put(root, list);
            }
        }
        
        List<List<String>> finalResult = new ArrayList<List<String>>();
        
        // convert to return data structure
        for (Map.Entry mapElement : result.entrySet()) {
            List<String> list = new ArrayList<>();
            List<String> emailList = (ArrayList<String>)mapElement.getValue();
            String name = nameMap.get(emailList.get(0));
            Collections.sort(emailList);
            list.add(name);
            for(String email : emailList) {
                list.add(email);
            }
            
            finalResult.add(list);
        }
        
        //System.out.println(finalResult);
        
        return finalResult;
        
    }
}