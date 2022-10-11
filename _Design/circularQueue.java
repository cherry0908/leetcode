import java.io.*; 
import java.util.*; 

class Queue {

    private int[] array;
    private int capacity;
    private int count;
    private int front;

    public Queue(int capacity){
        this.capacity = capacity;
        this.count = 0;
        this.array = new int[capacity];
        this.front = 0;
    }

    public void offer(int num) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        else {
            int index = (front + count) % capacity;
            array[index] = num;
            count++;
        }
    }

    public int poll(){
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return 0;
        }
        else {
            int num = array[front];
            front = (front + 1) % capacity;
            count--;

            return num;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return 0;
        }
        else{
            return array[front];
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFull() {
        if (count == capacity) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void printQueue() {
        for (int i = 0; i < count; i++) {
            int index = (front + i) % capacity;
            System.out.print(array[index] + ", ");
        }
        
        System.out.println("");
    }
}

public class Main
{
	public static void main(String[] args) {
        // create a queue of capacity 5
        Queue q = new Queue(5);
 
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println("The front element is " + q.peek());
        q.printQueue();
        
        q.offer(4);
        q.offer(5);
        q.offer(6);
        System.out.println("The front element is " + q.peek());
        q.printQueue();
        
        System.out.println("The queue size is " + q.size());
        
        q.poll();
        System.out.println("The front element is " + q.peek());
        q.printQueue();
 
        q.poll();
        q.printQueue();
        q.poll();
        q.printQueue();
 
        if (q.isEmpty()) {
            System.out.println("The queue is empty");
        }
        else {
            System.out.println("The queue is not empty");
        }
	}
}