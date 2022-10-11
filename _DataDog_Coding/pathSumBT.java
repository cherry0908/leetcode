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
    
    static int maxPathSum;

    public void dfsHelper(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        
        sum = sum + node.val;
        
        // if the current node is a leaf node
        // if it's a n-ary tree
        // check the number of the children
        // if (root.children.size() == 0) 
        if (node.left == null && node.right == null) {
            // check the sum and update the max sum
            maxPathSum = Math.max(maxPathSum, sum);
        }
        
        // if the current node is not a leaf, do recursion with the left and right children
        dfsHelper(node.left, sum);
        dfsHelper(node.right, sum);
        // if it's a n-ary tree
        // Recursive call for all the children nodes
        // iterate through all its children
        // for (int i = 0; i < root.children.size(); i++) {
        //     dfsHelper(node.children.get(i), sum);
        // }
    }
    
    public void pathSum(TreeNode root) {
        if (root == null) return;

        maxPathSum = Integer.MIN_VALUE;

        dfsHelper(root, 0);

        return;
    }
  
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Integer[] array = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        int target = 22;
        
        TreeNode root = solution.insertLevelOrder(array, 0);
        
        solution.pathSum(root);
        
        System.out.println(maxPathSum);
        
    }
}