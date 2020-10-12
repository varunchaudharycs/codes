// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3290/
// TIME - O(n/2)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_middleoflinkedlist {

    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        lc_middleoflinkedlist obj = new lc_middleoflinkedlist();

        System.out.println(obj.middleNode(new ListNode()));

        // for(List<String> l : list) {
        //     for(String s : l)
        //         System.out.print("word - " + s + ",");
        // }
    }
    // ONE PASS- FAST(>>2) and SLOW(>>1) pointers.
    // When fast reaches end, slow is at mid
    public ListNode middleNode(ListNode head) {
        
        ListNode fast = head, slow = head;
        
        while(fast.next != null) {
            if(fast.next.next != null) // NO NULL ERROR WHEN EVEN ELEMENTS
                fast = fast.next.next;
            else
                return slow.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
