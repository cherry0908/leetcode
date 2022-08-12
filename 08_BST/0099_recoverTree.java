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
    public void preorder(TreeNode root, List<Integer> value, List<TreeNode> nodes) {
        if (root == null) return;
        
        preorder(root.left, value, nodes);
        value.add(root.val);
        nodes.add(root);
        preorder(root.right, value, nodes);
    }
    
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        
        List<Integer> value = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        
        preorder(root, value, nodes);
        
        Collections.sort(value);   
        
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).val = value.get(i);
        }
        
        return;
    }
}