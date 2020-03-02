import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class MyLinkedList {

    public ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        ListNode head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode p=head;
        if(head==null) return -1;
        if(index==0) return head.val;
        for(int i=0;i<index;i++){
            p=p.next;
            if(p==null) return -1;
        }
        return p.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode p=head;
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head=newNode;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode p=head;
        ListNode newNode = new ListNode(val);
        if(p==null) {
            head = newNode;
            return;
        }
        while(p.next!=null){
            p=p.next;
        }
        p.next = newNode;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode p=head;
        ListNode newNode = new ListNode(val);
        if(index==0){
            newNode.next=head;
            head=newNode;
            return;
        }
        for(int i=0;i<index-1;i++){
            if(p.next==null){
                return;
            } 
            p=p.next;
        }
        if(p.next==null){
            p.next=newNode;
        }
        else{
            ListNode tmp=p.next;
            p.next=newNode;
            newNode.next=tmp;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode p=head;
        if(head==null) return;
        if(index==0){
            head=head.next;
            return;
        }
        for(int i=0;i<index-1;i++){
            if(p.next==null){
                System.out.println("Invalid index");
                return;
            }
            p=p.next;
        }
        if(p.next==null){
            System.out.println("Invalid index");
        }
        else{
            p.next=p.next.next;
        }
    }

    public void printList(){
        ListNode p = head;
        System.out.print("list: ");
        while(p!=null){
            System.out.print(p.val + " ");
            p=p.next;
        }
        System.out.println("");
    }
}

public class Main
{
	public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtTail(1);
        obj.addAtTail(2);
        obj.addAtTail(3);
        obj.addAtTail(4);
        obj.printList();
        obj.addAtIndex(0,0);
        obj.printList();
        obj.addAtIndex(3,9);
        obj.printList();
        obj.addAtIndex(6,10);
        obj.printList();
        obj.addAtIndex(8,11);
        obj.printList();
        obj.addAtHead(-1);
        obj.printList();
        obj.addAtHead(100);
        obj.printList();
        System.out.println("index: 0, value: " + obj.get(0));
        System.out.println("index: 1, value: " + obj.get(1));
        
	}
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */