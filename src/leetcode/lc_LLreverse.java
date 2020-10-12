package leetcode;// https://leetcode.com/problems/reverse-linked-list/
// TIME - O(n)

class lc_LLreverse {
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
