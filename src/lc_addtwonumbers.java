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
        
        int sum = 0, rem = 0;
        ListNode header= null, prev = null, current = null;
    
        while(l1 != null || l2 != null) {
            
            if(l1 == null && l2 == null) {
                break;
            }
            if(l1 == null) {
            while(l2 != null) {
                sum = l2.val + rem;
                current = new ListNode(sum % 10);  
                rem = sum / 10;
                prev.next = current;
                prev = current;
                l2 = l2.next;
            }
                break;
            }
            if(l2 == null) {
            while(l1 != null) {
                sum = l1.val + rem;
                current = new ListNode(sum % 10); 
                rem = sum / 10;
                prev.next = current;
                prev = current;
                l1 = l1.next;
            }
                break;
            }
            sum = l1.val + l2.val + rem;
            current = new ListNode(sum % 10); 
            rem = sum / 10;
            
            if(header != null) {
                prev.next = current;
            }
            else {
                header = current;
            }
            
            prev = current;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if(rem != 0) {
            current = new ListNode(rem);
            prev.next = current;
        }
        
        return header;
    }
}
