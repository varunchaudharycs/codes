// https://leetcode.com/problems/reverse-linked-list//**
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class lc_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode tmp;
        
        while(curr != null) {
            
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        return prev;
        
    }
}