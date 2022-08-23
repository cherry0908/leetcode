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
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null, curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode prev = null, slow = head, fast = head;
        
        // find the end node of first half and start node of second half
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // pre is the end of first half
        // slow is the start of second
        
        // reverse the second half of the list
        ListNode p2 = reverse(slow);
        ListNode p1 = head;
        
        // compare the two half list
        while (p2 != null) {
            if (p2.val != p1.val) {
                return false;
            }
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
}