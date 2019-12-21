package leetcode;
import java.io.*;
import java.util.*;

//https://leetcode.com/problems/merge-two-sorted-lists/submissions/

// TIME - O(n + m)
// SPACE - O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class lc_mergetwosortedlists
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode l = new ListNode(-1);
        ListNode head = l;
        
        while(l1 != null && l2 != null) {
            
            if(l1.val <= l2.val) {
                l.next = l1;
                l1 = l1.next;
            }
            else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        while(l1 != null) {
            l.next = l1;
            l = l.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            l.next = l2;
            l = l.next;
            l2 = l2.next;
        }
        
        return head.next;
    }
}