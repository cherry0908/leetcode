
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
    
    public TreeNode helper(int left, int right, int[] nums) {
        if (left > right) return null;
        
        // choose the left middle node as a root
        int index = (left + right) / 2;
        
        // preorder traversal, root -> left -> right
        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(left, index - 1, nums);
        node.right = helper(index + 1, right, nums);
        
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        
        TreeNode root = helper(0, nums.length - 1, nums);
        
        return root;
    }
}