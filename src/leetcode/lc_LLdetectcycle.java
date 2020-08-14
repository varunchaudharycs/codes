// https://leetcode.com/problems/linked-list-cycle/
// TIME - O(n)

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
public class lc_LLdetectcycle {
    public boolean hasCycle(ListNode head) {
        
        if(head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null && fast != null) {
            
            slow = slow.next;
            
            if(fast.next == null) return false;
            
            fast = fast.next.next;
            
            if(slow == fast) return true;            
        }
        
        return false;
    }
}
