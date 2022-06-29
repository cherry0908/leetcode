/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        // traverse the linked list based on next node
        // create a hash map to store the original node as key and its copied node as value
        // the 2nd time traverse the new linked list, link the random node
        
        Node newNode = new Node(head.val);
        newNode.next = null;
        newNode.random = null;
        
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, newNode);
        
        Node newHead = newNode, newList = newNode;
        // traver the linked list
        Node cur = head.next;
        
        while(cur != null) {
            // create a new node and copy the current node value
            newNode = new Node(cur.val);
            newNode.next = null;
            newNode.random = null;
						
            // add the hash map entry
            map.put(cur, newNode);
            
            // link the new node to the end of the new list
            newList.next = newNode;
            
            // move the new list forward
            newList = newList.next;
            // move the current node forward in the original list
            cur = cur.next;
        }
        
        newList = newHead;
        cur = head;
        while(cur != null) {
            // copy the random node
            newList.random = map.get(cur.random);
						
            newList = newList.next;
            cur = cur.next;
        }
        
        return newHead;
    }
}


class Solution {
    // dfs, recursive
    public Node helper(Node node, HashMap<Node, Node> map) {
        if(node == null) return null;
        
        // if the map already contains the node, return its mnapped node
        if(map.containsKey(node)) return map.get(node);
        
        // if not, create a new node and add to the hashmap
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        
        // for each node, treat it like a graph node
        // do dfs on next and do dfs on random
        newNode.next = helper(node.next, map);
        newNode.random = helper(node.random, map);
        
        return newNode;
    }
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        return helper(head, map);
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        // traverse the linked list based on next node
        // create a new node and insert it to the next of the original node
        // 2nd time traverse, link the random
        // 3rd traverse, break the original linked list and the new linked list
        // no need extra space for hashmap
        
        // create new node for each node in the list and link
        Node cur = head;
        while(cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            newNode.random = null;
            
            cur.next = newNode;
            
            cur = newNode.next;
        }
        
        // link the random
        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            
            cur = cur.next.next;
        }
        
        // seperate the two linked list
        Node newHead = head.next;
        cur = head;
        while(cur != null) {
            Node tmp = cur.next;
            cur.next = tmp.next;
            
            if(tmp.next != null) {
                tmp.next = tmp.next.next;
            }
            
            cur = cur.next;
        }
        
        return newHead;
    }
}