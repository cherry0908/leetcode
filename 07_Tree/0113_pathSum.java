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
    
    public void dfsHelper(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        
        // add current node to the path
        int sum = targetSum - node.val;
        path.add(node.val);
        
        // current node is leaf
        if (node.left == null && node.right == null) {
            // the sum of the node values in the path equals targetSum
            if (sum == 0) {
                res.add(new ArrayList<>(path));
            }
        }
        // not leaf, do recursion on both left and right child
        else {
            dfsHelper(node.left, sum, path, res);
            dfsHelper(node.right, sum, path, res);
        }
        
        // remove the last node so that it can return to the upper level
        path.remove(path.size() - 1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;
        
        List<Integer> path = new ArrayList<>();
        
        dfsHelper(root, targetSum, path, res);
        
        return res;
    }
}