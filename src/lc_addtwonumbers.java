// https://leetcode.com/problems/add-two-numbers/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // To store sum & carry
        int rem = 0;
        // Dummy node
        ListNode node = new ListNode(-1);
        ListNode header = node;
        
        // Logic - runs until both lists are traversed and forwarded carry is 0
        while(l1 != null || l2 != null || rem != 0) {
            
            // List 1 has remaining items 
            if(l1 != null) {
                rem += l1.val;
                l1 = l1.next;
            }
            // List 2 has remaining items
            if(l2 != null) {
                rem += l2.val;
                l2 = l2.next;
            }
            // Adds List 1 value(if) & List 2 value(if) & forwarded carry(if)
            // Puts value in new node 
            // Computes carry
            // Points to the newly created node
            node.next = new ListNode(rem % 10);
            rem /= 10;
            node = node.next;
        }
        
        return header.next;
    }
}
