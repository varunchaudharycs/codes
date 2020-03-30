// https://leetcode.com/problems/same-tree/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class lc_sametree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        TreeNode p_curr, q_curr;
        boolean same = true;
        Queue<TreeNode> p_nodes = new LinkedList<>();
        Queue<TreeNode> q_nodes = new LinkedList<>();
        p_nodes.add(p);
        q_nodes.add(q);
        while(!p_nodes.isEmpty() 
              && !q_nodes.isEmpty()
              && same) {
            
            p_curr = p_nodes.poll();
            q_curr = q_nodes.poll();
            // any one is NULL - NOT SAME
            if(p_curr == null || q_curr == null) {
                if(!(p_curr == null && q_curr == null)) {
                    same = false;
                    break;
                }
            }
            // check corresponding values
            else {
                if(p_curr.val != q_curr.val) {
                    same = false;
                    break;
                }
                else {
                    p_nodes.add(p_curr.left);
                    p_nodes.add(p_curr.right);
                    q_nodes.add(q_curr.left);
                    q_nodes.add(q_curr.right);
                }
            }
            
        }
        // both queues empty & same = true => SAME TREE
        if(p_nodes.isEmpty() && q_nodes.isEmpty())
            return same; // returning 'same' as the last element in queues might be different
        else
            return false;
    }
}
