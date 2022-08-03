/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public void dfs(int col, int row, TreeNode node, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if(node == null) return;
        
        // add current node value to the map
        TreeMap<Integer, List<Integer>> rowMap;
        if (map.containsKey(col)) {
            rowMap = map.get(col);
        }
        else {
            rowMap = new TreeMap<>();
        }
        
        List<Integer> list;
        if (rowMap.containsKey(row)) {
            list = rowMap.get(row);
        }
        else {
            list = new ArrayList<>();
        }
        
        list.add(node.val);
        rowMap.put(row, list);
        map.put(col, rowMap);
        
        // move on to left child
        if (node.left != null) {
            dfs(col - 1, row + 1, node.left, map);
        }
        
        // move on to right child
        if (node.right != null) {
            dfs(col + 1, row + 1, node.right, map);
        }
        
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        
        dfs(0, 0, root, map);
        
        // System.out.println(map);
        
        for(TreeMap<Integer, List<Integer>> rowMap : map.values()) {
            List<Integer> list = new ArrayList<Integer>();
            for(List<Integer> value : rowMap.values()) {
                Collections.sort(value);
                list.addAll(value);
            }
            result.add(list);
        }
        
        return result;
    }
    
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public void dfs(int col, int row, TreeNode node, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if(node == null) return;
        
        // add current node value to the map
        TreeMap<Integer, PriorityQueue<Integer>> rowMap;
        if (map.containsKey(col)) {
            rowMap = map.get(col);
        }
        else {
            rowMap = new TreeMap<>();
        }
        
        PriorityQueue<Integer> pq;
        if (rowMap.containsKey(row)) {
            pq = rowMap.get(row);
        }
        else {
            pq = new PriorityQueue<>();
        }
        
        pq.add(node.val);
        rowMap.put(row, pq);
        map.put(col, rowMap);
        
        // move on to left child
        if (node.left != null) {
            dfs(col - 1, row + 1, node.left, map);
        }
        
        // move on to right child
        if (node.right != null) {
            dfs(col + 1, row + 1, node.right, map);
        }
        
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        dfs(0, 0, root, map);
        
        // System.out.println(map);
        
        for(TreeMap<Integer, PriorityQueue<Integer>> rowMap : map.values()) {
            List<Integer> list = new ArrayList<Integer>();
            
            for(PriorityQueue<Integer> pq : rowMap.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            
            result.add(list);
        }
        
        return result;
    }
}