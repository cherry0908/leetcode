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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode curr = head, prev = null;
        
        while (curr != null) {
            // in every iteration, we need to first remember the next node
            ListNode next = curr.next;
            // reverse curr node's pointer
            curr.next = prev;
            // move both curr node and prev node
            prev = curr;
            curr = next;
        }
        
        // at the very end, curr node is the last null, prev node is the last node, aka the new head
        return prev;
    }
}