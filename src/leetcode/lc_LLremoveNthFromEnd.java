// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// TIME - O(n)


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
class lc_LLremoveNthFromEnd {

    // logic- start 2 pointers with diff of N nodes. Then jump both by one. When fast ptr reaches end, remove slow ptr node.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode slow = null, fast = null;
        
        while(n != 0) {
            
            if(fast != null) fast = fast.next;
            else fast = head;
            n--;
        }
        
       if(fast.next == null) {
           
           head = head.next;
           return head;
       }
            
        
        while(fast.next != null) {
            
            if(slow != null) slow = slow.next;
            else slow = head;
            
            fast = fast.next;
        }
        
        if(slow.next != null)
            slow.next = slow.next.next;
        else
            slow.next = null;
        
        
        
        return head;
    }
}

// I/O
// Example:

// Given linked list: 1->2->3->4->5, and n = 2.

// After removing the second node from the end, the linked list becomes 1->2->3->5.
