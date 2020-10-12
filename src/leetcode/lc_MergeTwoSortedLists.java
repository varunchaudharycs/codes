package leetcode;// https://leetcode.com/problems/merge-two-sorted-lists/
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
class lc_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        
        ListNode merged = new ListNode();
        
        ListNode head = merged;
        
        while(l1 != null && l2 != null) {
            
            if(l1.val <= l2.val) {
                
                merged.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                
                merged.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            
            merged = merged.next;
        }
        
        if(l1 != null) {
            
            while(l1 != null) {
                
                merged.next = new ListNode(l1.val);
                l1 = l1.next;
                merged = merged.next;
            }
        }
        if(l2 != null) {
            
            while(l2 != null) {
                
                merged.next = new ListNode(l2.val);
                l2 = l2.next;
                merged = merged.next;
            }
        }
        
        return head.next;
    }
}