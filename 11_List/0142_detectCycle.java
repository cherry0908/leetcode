/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode findIntersection(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return slow;
            }
        }
        
        return null;
    }
    
    
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        
        // detect cycle, find the intersection
        ListNode meetNode = findIntersection(head);
        
        // if null, no cycle
        if (meetNode == null) return null;
        
        ListNode startNode = head;
        
        // when in the same speed, head meets intersection, it's the start of cycle
        while (meetNode != startNode) {
            meetNode = meetNode.next;
            startNode = startNode.next;
        }
        
        return startNode;
    }
}