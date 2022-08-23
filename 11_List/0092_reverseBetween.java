/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        
        int len = right - left + 1;
        
        ListNode curr = head, prev = null;
        
        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left--;
        }
        // remember the tail node of first part
        ListNode tail = prev;
        
        // start reversing linked list
        prev = null;
        ListNode tmpTail = curr;
        
        while (len > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            len--;
        }
        
        // the tail node's next is the head of reversed linked list
        // if tail is null, the head is the reversed linked list
        if (tail != null) {
            tail.next = prev;
        }
        else {
            head = prev;
        }
        
        // the tail (of the reversed linked list) 's next is the curr
        // it can be null or node
        tmpTail.next = curr;
        
        return head;
    }
}