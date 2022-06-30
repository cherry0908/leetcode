class Solution {
    
    class UnionFind{
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
            if(root[x] == x) return x;
            
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
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
    
    public void dfsHelper(int index, String[] words, HashMap<Integer, List<String>> rootSynMap, HashMap<String, Integer> synId, UnionFind uf, StringBuilder str, List<String> result) {
        // reach the end of the sentence
        if(index >= words.length) {
            // convert StringBuilder to string and add to the result
            result.add(str.substring(0, str.length() - 1));
            return;
        }
        
        String word = words[index];
        
        if(!synId.containsKey(word)) {
            // get the entire str length
            int strLength = str.length();
            // get the word length
            int wordLength = word.length();
            
            // append the word at the end of str
            str.append(word).append(" ");
            
            // dfs go to the next word
            dfsHelper(index + 1, words, rootSynMap, synId, uf, str, result);
            
            // when completed the recursion, we need to delete the last appended word
            str = str.delete(strLength, strLength + wordLength + 1);
        }
        else {
            // get the syn id
            int wordId = synId.get(word);
            // get the root of the syn
            int root = uf.find(wordId);
            
            // use root id to get the list of syn
            List<String> list = rootSynMap.get(root);
            
            // iterate through all the syn
            for(String syn : list) {
                int strLength = str.length();
                int synLength = syn.length();
                
                // append the syn at the end of str
                str.append(syn).append(" ");
                
                // dfs go to the next word
                dfsHelper(index + 1, words, rootSynMap, synId, uf, str, result);
                
                // when completed the recursion, we need to delete the last appended word
                str = str.delete(strLength, strLength + synLength + 1);
            }
        }
    }
    
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        if(text == null) return null;
        
        List<String> result = new ArrayList<>();
        
        if(synonyms == null || synonyms.size() == 0) {
            result.add(text);
            return result;
        }
        
        // convert synonyms to ids for union find 
        // a hash map for sysnonyms and its id, key is synonym, value is id
        HashMap<String, Integer> synId = new HashMap<>();
        // an arraylist, index is id, value is sysnonym
        List<String> synList = new ArrayList<>();
        
        int id = 0;
        
        for(List<String> pair : synonyms) {
            String a = pair.get(0);
            String b = pair.get(1);
            
            if(!synId.containsKey(a)){
                synId.put(a, id);
                synList.add(id, a);
                id++;
            }
            
            if(!synId.containsKey(b)){
                synId.put(b, id);
                synList.add(id, b);
                id++;
            }
        }
        
        // initialize union find with total synonyms
        UnionFind uf = new UnionFind(synList.size());
        
        // union all the synonyms
        for(List<String> pair : synonyms) {
            int x = synId.get(pair.get(0));
            int y = synId.get(pair.get(1));
            uf.union(x, y);
        }
        
        // get every syn's root, create a list of syns with the same root
        HashMap<Integer, List<String>> rootSynMap = new HashMap<>();
        for(int i = 0; i < synList.size(); i++) {
            String syn = synList.get(i);
            int root = uf.find(i);
            
            List<String> list = new ArrayList<>();
            if(rootSynMap.containsKey(root)) {
                list = rootSynMap.get(root);
            }
            list.add(syn);
            rootSynMap.put(root, list);
        }
        
        // sort the rootSynMap with lexicographically order
        for(List<String> value : rootSynMap.values()) {
            Collections.sort(value);
        }
        
        // System.out.println(rootSynMap);
        
        // dfs replace all the words with synonyms
        String[] words = text.split(" ");
        
        // use StringBuilder to build the entire sentence
        StringBuilder str = new StringBuilder();
        
        dfsHelper(0, words, rootSynMap, synId, uf, str, result);
        
        return result;
                       
    }
}