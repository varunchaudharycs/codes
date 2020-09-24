// https://leetcode.com/problems/reorder-list//**

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class lc_ReorderList {
    public void reorderList(ListNode head) {
        
        Stack<ListNode> reversed = new Stack<>();
        ListNode ptr = head, prev = null, tmp = null;
        
        while(ptr != null) {
            
            reversed.push(ptr);
            ptr = ptr.next;
        }
        
        if(reversed.size() > 2) {
        
        ptr = head;
        ListNode ptr2 = reversed.pop();
                
        while(ptr != ptr2 && ptr != prev) {
            
            if(prev != null) prev.next = ptr;
            
            tmp = ptr.next;
            ptr.next = ptr2;
            ptr2.next = null;
            
            prev = ptr2;
            
            ptr = tmp;
            ptr2 = reversed.pop();            
        }
        
         if(ptr == ptr2) {
             prev.next = ptr;
             prev.next.next = null;
         }
        }
    }
}