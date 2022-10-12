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
    
    int count = 0;
    
    public void findSum(List<Integer> path, int target) {        
        int n = path.size();
        
        long[] prefixSum = new long[n];
        prefixSum[0] = path.get(0);
        
        // calculate the prefix sum for the list
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + path.get(i);
        }
        
        // the entire path
        long sum = prefixSum[n - 1];
        if (sum == target) {
            count++;
        }
        
        // delete node from the root
        // always sum up to the end
        for (int i = 0; i < n - 1; i++) {
            if (sum - prefixSum[i] == target) {
                count++;
            }
        }
        
    }
    
    public void dfsHelper(TreeNode node, int target, List<Integer> path) {
        if (node == null) {
            return;
        }
        
        // add current node to the path
        path.add(node.val);
        
        // find if the path sum is equal to target
        findSum(path, target);
        // System.out.println(path);
        // System.out.println(count);
        
        // dfs on the tree
        dfsHelper(node.left, target, path);
        dfsHelper(node.right, target, path);
        
        // remove the last node from the path
        path.remove(path.size() - 1);
        
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        
        dfsHelper(root, targetSum, path);
        
        return count;
    }
}