
// https://leetcode.com/problems/binary-tree-level-order-traversal/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

//// Definition for a binary tree node.
// public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }

class lc_binarytreelevelordertraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // process nodes in queue level-by-level
        List<Integer> curr_lvl = new LinkedList<>(); // stores nodes of current level
        List<List<Integer>> lvl_order = new LinkedList<>(); // final list
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        if(root == null) return lvl_order;
        
        while(!nodes.isEmpty()) {
            curr_lvl = new LinkedList<>(); 
            // stores nodes of current level
            for(int count = nodes.size(); count > 0; count--) {
                if(nodes.peek().left != null) nodes.add(nodes.peek().left);
                if(nodes.peek().right != null) nodes.add(nodes.peek().right);
                curr_lvl.add(nodes.poll().val);
            }
            lvl_order.add(curr_lvl);
        }
        return lvl_order;
    }
}
