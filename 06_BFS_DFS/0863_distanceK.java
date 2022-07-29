/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void preOrderTravase(TreeNode node, HashMap<Integer, List<Integer>> map){
        if(node == null) return;
        
        preOrderTravase(node.left, map);
        
        // process the current node
        List<Integer> list;
        if(!map.containsKey(node.val)) {
            list = new ArrayList<>();
        }
        else{
            list = map.get(node.val);
        }
        
        if(node.left != null) {
            list.add(node.left.val);
            
            List<Integer> list1;
            if(!map.containsKey(node.left.val)) {
                list1 = new ArrayList<>();
            }
            else{
                list1 = map.get(node.left.val);
            }
            
            list1.add(node.val);
            map.put(node.left.val, list1);
        }
        
        if(node.right != null) {
            list.add(node.right.val);
            
            List<Integer> list1;
            
            if(!map.containsKey(node.right.val)) {
                list1 = new ArrayList<>();
            }
            else{
                list1 = map.get(node.right.val);
            }
            
            list1.add(node.val);
            map.put(node.right.val, list1);
        }
        
        map.put(node.val, list);
        
        preOrderTravase(node.right, map);

    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null || target == null) return null;
        
        List<Integer> result = new ArrayList<>();
        
        // convert tree to a undirected graph using hashmap
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        preOrderTravase(root, map);
                
        //System.out.println(map);
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(target.val);
        
        int level = 0;
        
        // BFS scan the grap
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            if(level == k) {
                for(int i = 0; i < size; i++) {
                    result.add(queue.poll());
                }
                
                return result;
            }
            
            for(int i = 0; i < size; i++) {
                int curr = queue.poll();
                List<Integer> neighbours = map.get(curr);
                for(int next : neighbours) {
                    if(map.containsKey(next)) {
                        queue.add(next);
                    }
                }
                
                map.remove(curr);
            }
            
            level++;
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void dfs(TreeNode node, TreeNode parent, HashMap<TreeNode, TreeNode> map) {
        if(node == null) return;
        
        map.put(node, parent);
        dfs(node.left, node, map);
        dfs(node.right, node, map);
        
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null) return null;
        
        List<Integer> result = new ArrayList<>();
        
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        
        dfs(root, null, map);
        
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(target);
        
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);
        
        int dist = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(dist == k) {
                for(int i = 0; i < size; i++) {
                    TreeNode tmp = queue.poll();
                    result.add(tmp.val);
                }
                
                return result;
            }
            
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                
                if(curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                    visited.add(curr.left);
                }
                
                if(curr.right!= null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                    visited.add(curr.right);
                }
                
                TreeNode parent = map.get(curr);
                if(parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }
                
            }
            
            dist++;
        }
        
        return result;
    }
}