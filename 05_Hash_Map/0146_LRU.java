class LRUCache {

    class DLLNode {
        public int key;
        public int value;
        public DLLNode next;
        public DLLNode prev;
        
        public DLLNode(){};
        public DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private HashMap<Integer, DLLNode> cache;
    private DLLNode head;
    private DLLNode tail;
    private int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        
        // create a dummy head node and tail node for double linked list
        this.head = new DLLNode();
        this.tail = new DLLNode();
        
        head.next = tail;
        tail.prev = head;
        // head.prev = null
        // tail.next = null
    }
    
    // remove an existiing node from double linked list
    public void remove(DLLNode node) {
        // get the prev and next of the existing node
        DLLNode prev = node.prev;
        DLLNode next = node.next;
        
        // remove the existing node
        prev.next = next;
        next.prev = prev;
    }
    
    // add a new node after the dummy head of double linked list
    public void addFirst(DLLNode node) {
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }
    
    // remove the last node before dummy tail of double linked list
    public DLLNode removeTail() {
        DLLNode node = tail.prev;
        remove(node);
        
        return node;
    }
    
    public int get(int key) {
        // get node from hashmap
        DLLNode node = cache.get(key);
        
        if (node == null) {
            return -1;
        }
        else {
            // update the node position in double linked list
            // remove the exisitng node from double linked list
            remove(node);
            // add the node to the first of double linked list
            addFirst(node);
            
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        // get node from hashmap
        DLLNode node = cache.get(key);
        
        // if node doesn't exist in hashmap
        if (node == null) {
            // create new node for (key, value)
            DLLNode newNode = new DLLNode(key, value);
            // add newNode to hashmap 
            cache.put(key, newNode);
            // add newNode in the first of double linked list
            addFirst(newNode);
            // increase size
            size++;
            
            // after add the newNode, if the size is larger than capacity
            if (size > capacity) {
                // remove the last of double linked list
                DLLNode tail = removeTail();
                // remove the tail from hashmap
                cache.remove(tail.key);
                size--;
            }
        }
        // if node is in hashmap
        else {
            // update the value in the hashmap
            node.value = value;
            
            // update the node position in double linked list
            // remove the exisitng node from double linked list
            remove(node);
            // add the node to the first of double linked list
            addFirst(node);
        }
    }
    
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */