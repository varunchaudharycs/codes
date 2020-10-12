package leetcode;// https://leetcode.com/problems/merge-two-sorted-lists/
// TIME - O(m+n)
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
class lc_LLmergedtwosortedlist {


    private ListNode fillRemaining(ListNode merged, ListNode l) {

        while(l != null) {
           merged.next = l;
           l = l.next;
           merged = merged.next;
        }

        return merged;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode merged = new ListNode();

        if(l1 == null) {
            return l2;
        }
        else if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            merged.val = l1.val;
            l1 = l1.next;
        }
        else {
            merged.val = l2.val;
            l2 = l2.next;
        }

        ListNode head = merged;

        while(l1 != null && l2 != null) {

            if(l1.val < l2.val) {
                merged.next = l1;
                l1 = l1.next;
            }
            else {
                merged.next = l2;
                l2 = l2.next;
            }

            merged = merged.next;
        }

        merged = fillRemaining(merged, l1);
        merged = fillRemaining(merged, l2);

        return head;
    }
}
