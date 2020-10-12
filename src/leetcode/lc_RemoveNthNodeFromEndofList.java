package leetcode;// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
class lc_RemoveNthNodeFromEndofList {
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