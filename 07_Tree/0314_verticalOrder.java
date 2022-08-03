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
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        
        // level traversal
        // every tree node as an index
        // root is index 0, left child index is root - 1, right child index is root + 1
        // use index as key to store the node as a list in a sorted hashmap, which is a tree map
        // if the same index, it come top to bottom, left to right, the same order as level travesal
        
        TreeMap<Integer, List<Integer>> treemap = new TreeMap<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        TreeNode node = new TreeNode(0);
        List<TreeNode> tmp = new ArrayList<>();
        tmp.add(root);
        tmp.add(node);
        queue.add(tmp);
        
        // BFS
        while (!queue.isEmpty()) {
            
            // get the current tree node and its index
            List<TreeNode> pair = queue.poll();
            TreeNode curr = pair.get(0);
            int index = pair.get(1).val;

            // get the list from the tree map using index
            List<Integer> iList;
            if (treemap.containsKey(index)) {
                iList = treemap.get(index);
            }
            else {
                iList = new ArrayList<>();
            }

            // add the current tree node to the list
            iList.add(curr.val);
            treemap.put(index, iList);

            // move to the left child
            if (curr.left != null) {
                TreeNode indexNode = new TreeNode(index - 1);
                List<TreeNode> nList = new ArrayList<>();
                nList.add(curr.left);
                nList.add(indexNode);
                queue.add(nList);
            }

            // move to the right child
            if (curr.right != null) {
                TreeNode indexNode = new TreeNode(index + 1);
                List<TreeNode> nList = new ArrayList<>();
                nList.add(curr.right);
                nList.add(indexNode);
                queue.add(nList);
            }
        }
        
        //System.out.println(treemap);
        
        for (Map.Entry<Integer, List<Integer>> entry : treemap.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
    }
}