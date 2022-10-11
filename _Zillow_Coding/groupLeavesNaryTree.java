// Find Duplicate Words in a Regular Expression in Java
import java.util.*;
  
public class Solution {
    
    class Node {
        String nodeName;
        int nodeValue;;
        List<Node> children;

        Node() {}
        Node(String name, int value) {
            this.nodeName = name;
            this.nodeValue = value;
            this.children = new ArrayList<>();
        }
    }
    
    public void dfsHelper(Node node, HashMap<Integer, List<String>> hashmap) {
        if (node == null) {
            return;
        }
        
        // if the current node is a leaf node
        // if it's a n-ary tree
        // check the number of the children
        if (node.children.size() == 0) {
            
            if (!hashmap.containsKey(node.nodeValue)) {
                hashmap.put(node.nodeValue, new ArrayList<>());
            }

            List<String> list = hashmap.get(node.nodeValue);
            list.add(node.nodeName);
            hashmap.put(node.nodeValue, list);
        }
        
        // if the current node is not a leaf
        // if it's a n-ary tree
        // Recursive call for all the children nodes
        // iterate through all its children
        for (int i = 0; i < node.children.size(); i++) {
            dfsHelper(node.children.get(i), hashmap);
        }
    }
    
    public List<List<String>> groupLeaves(Node root) {
        if (root == null) return new ArrayList<>();

        HashMap<Integer, List<String>> hashmap = new HashMap<>();

        dfsHelper(root, hashmap);
        
        List<List<String>> result = new ArrayList<>();

        for (int key : hashmap.keySet()) {
            List<String> value = hashmap.get(key);
            if (value.size() > 1) {
                result.add(value);
            }
        }

        return result;
    }
    
    public Node createTree() {
        Node root = new Node("n1", 1);
        root.children.add(new Node("n2", 1));
        root.children.add(new Node("n3", 1));
        root.children.add(new Node("n4", 2));
        root.children.add(new Node("n5", 2));
        Node child1 = root.children.get(1);
        child1.children.add(new Node("n6", 1));
        child1.children.add(new Node("n7", 3));
        child1.children.add(new Node("n8", 1));
        Node child2 = root.children.get(2);
        child2.children.add(new Node("n9", 2));
        child2.children.add(new Node("n10", 4));
        
        return root;
    }
  
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Node root = solution.createTree();
        
        List<List<String>> result = solution.groupLeaves(root);
        
        System.out.println(result);
        
    }
}