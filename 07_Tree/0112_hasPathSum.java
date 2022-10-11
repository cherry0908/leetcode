// Find Duplicate Words in a Regular Expression in Java
import java.util.*;
  
public class Solution {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean dfsHelper(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        
        int sum = target - node.val;
        
        // if the current node is a leaf node
        if (node.left == null && node.right == null) {
            // check the sum
            if (sum == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        
        // if the current node is not a leaf, do recursion with the left and right children
        return dfsHelper(node.left, sum) || dfsHelper(node.right, sum);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        return dfsHelper(root, targetSum);
    }

    public TreeNode insertLevelOrder(Integer[] array, int index) {
        TreeNode node = new TreeNode();

        // base case
        if (index < array.length) {
            
            if (array[index] == null) {
                node = null;
            }
            else {
                node.val = array[index];
                // insert left child
                node.left = insertLevelOrder(array, index * 2 + 1);
                // insert right child
                node.right = insertLevelOrder(array, index *2 + 2);
            }
        }

        return node;
    }
  
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Integer[] array = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        int target = 22;
        
        TreeNode root = solution.insertLevelOrder(array, 0);
        
        boolean result = solution.hasPathSum(root, target);
        
        System.out.println(result);
        
    }
}