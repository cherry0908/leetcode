import java.io.*; 
import java.util.*; 

class LRUCache{

    private Deque<Integer> doublyList;
    private HashSet<Integer> hashSet;
    private int capacity;

    public LRUCache(int capacity) {
        this.doublyList = new LinkedList<>();
        this.hashSet = new HashSet<>();
        this.capacity = capacity;
    }

    public void get(int num) {
        // if the element is not in the cache
        if (!hashSet.contains(num)) {
            // the number is not in cache
            // check the cache is full
            // remove the last element in the double linked list
            if (doublyList.size() == capacity) {
                int last = doublyList.removeLast();
                hashSet.remove(last);
            }

            // add the new element to the front of the double linked list and hashset
            doublyList.addFirst(num);
            hashSet.add(num);
        }
        // if the element is in the cache
        else {
            // move the element to the front of the double linked list
            doublyList.remove(num);
            doublyList.addFirst(num);
        }
    }

    public void printCache() {
        Iterator<Integer> itr = doublyList.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + ",");
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