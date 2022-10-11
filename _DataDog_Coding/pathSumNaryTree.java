// Find Duplicate Words in a Regular Expression in Java
import java.util.*;
  
public class Solution {
    
    class TreeNode {
        public int val;
        public List<TreeNode> children;
        TreeNode() {}
        
        TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
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
        if (node.children.size() == 0) {
            // check the sum and update the max sum
            maxPathSum = Math.max(maxPathSum, sum);
        }
        
        // if the current node is not a leaf
        // if it's a n-ary tree
        // Recursive call for all the children nodes
        // iterate through all its children
        for (int i = 0; i < node.children.size(); i++) {
            dfsHelper(node.children.get(i), sum);
        }
    }
    
    public void pathSum(TreeNode root) {
        if (root == null) return;

        maxPathSum = Integer.MIN_VALUE;

        dfsHelper(root, 0);

        return;
    }
    
    public TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        TreeNode child0 = root.children.get(0);
        child0.children.add(new TreeNode(4));
        child0.children.add(new TreeNode(5));
        TreeNode child1 = root.children.get(1);
        child1.children.add(new TreeNode(6));
        child1.children.add(new TreeNode(7));
        child1.children.add(new TreeNode(8));
        
        return root;
    }
  
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = solution.createTree();
        
        solution.pathSum(root);
        
        System.out.println(maxPathSum);
        
    }
}