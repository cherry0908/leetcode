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
    
    public int  dfs(TreeNode root, TreeMap<Integer, List<Integer>> treemap) {
        if (root == null) return 0;
        
        // post-order traversal: left, right, root
        // the node distance to the leaves are the max of left subree and right subtree + 1
        int left = dfs(root.left, treemap);
        int right = dfs(root.right, treemap);
        int dist = Math.max(left, right) + 1;
        
        if (!treemap.containsKey(dist)) {
            treemap.put(dist, new ArrayList<>());
        }
        List<Integer> list = treemap.get(dist);
        list.add(root.val);
        treemap.put(dist, list);
        
        return dist;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        
        TreeMap<Integer, List<Integer>> treemap = new TreeMap<>();
        
        dfs(root, treemap);
        
        for (int key : treemap.keySet()) {
            result.add(treemap.get(key));
        }
        
        return result;
    }
}