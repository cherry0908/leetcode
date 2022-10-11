import java.io.*; 
import java.util.*; 

class LRUCache{

    // double linked list
    // create Node class to have pointer to its previous node and next node
    class Node {
        int value;
        Node prev;
        Node next;

        public Node() {};
        public Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    // hashmap to store the cache value
    // key is the number, value is the node in double linked list
    private HashMap<Integer, Node> hashMap;
    private int capacity;

    // I can use a linked list here, remove will take O(n) time complexity
    // double linked list: head and tail
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.hashMap = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();

        // create dummy head and tail node to avoid exceeding the boundry
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node first) {
        first.next = head.next;
        first.prev = head;
        
        head.next.prev = first;
        head.next = first;
    }

    public Node removeLast() {
        Node last = tail.prev;
        remove(last);

        return last;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void get(int num) {
        // if the element is not in the cache
        if (!hashMap.containsKey(num)) {
            // the number is not in cache
            // create a new node
            Node curr = new Node(num);

            // check the cache is full
            // remove the last element in the double linked list
            // add the new element to the front of the double linked list and hashmap
            if (hashMap.size() == capacity) {
                Node last = removeLast();
                hashMap.remove(last.value);
            }
            
            addFirst(curr);
            hashMap.put(num, curr);

        }
        // if the element is in the cache
        else {
            Node curr = hashMap.get(num);
            // move the element to the front of the double linked list
            remove(curr);
            addFirst(curr);
        }
    }

    public void printCache() {
        Node ptr = head.next;
        for (int i = 0; i < hashMap.size(); i++) {
            System.out.print(ptr.value + ",");
            ptr = ptr.next;
        }

        System.out.println("");
    }
}

public class Main {

	public static void main(String[] args) {
        int capacity = 5;
        LRUCache obj = new LRUCache(capacity);
        
        obj.get(1);
        obj.printCache();
        obj.get(2);
        obj.printCache();
        obj.get(3);
        obj.printCache();
        obj.get(4);
        obj.printCache();
        obj.get(1);
        obj.printCache();
        obj.get(5);
        obj.printCache();
        obj.get(6);
        obj.printCache();
	}
}