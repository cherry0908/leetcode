/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // DFS, recursive
    public Node helper(Node node, HashMap<Node, Node> isVisited) {
        if(isVisited.containsKey(node)) {
            return isVisited.get(node);
        }
        
        Node newNode = new Node(node.val);
        isVisited.put(node, newNode);
        
        for(Node neighbor : node.neighbors) {
            newNode.neighbors.add(helper(neighbor, isVisited));
        }
        
        return newNode;
    }
    
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        HashMap<Node, Node> isVisited = new HashMap<>();
        return helper(node, isVisited);
    }
}

class Solution {
    // use BFS and hash map
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            Node curNode = map.get(tmp);
            
            for(Node neighbor : tmp.neighbors) {
                if(map.containsKey(neighbor)) {
                    curNode.neighbors.add(map.get(neighbor));
                }
                else {
                    Node newNeighbor = new Node(neighbor.val);
                    curNode.neighbors.add(newNeighbor);
                    queue.add(neighbor);
                    map.put(neighbor, newNeighbor);
                }
            }
        }
        
        return newNode;
    }
}