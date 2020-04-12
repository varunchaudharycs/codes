// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3293/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

// NOT NECESSARILY PASSES FROM ROOT
class lc_diameterofbinarytree {

    int maxDiameter = 0; // STORES DIAMETER
    
   public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null || (root.left == null && root.right == null)) // LESS THAN 2 NODES in TREE 
            return 0;
       
        helper(root);
       
        return maxDiameter;
    }

    public int helper(TreeNode parent) {

        if(parent.left == null && parent.right == null) // LEAF NODE
            return 1;

        int leftHeight = 0, rightHeight = 0;
        
        if(parent.left != null) leftHeight = helper(parent.left);
        if(parent.right != null) rightHeight = helper(parent.right);
        
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight); // DIAMETER MAY NOT PASS THRU ROOT
        
        return 1 + Math.max(leftHeight, rightHeight); // RETURN THE LONGEST SUBTREE

    }
}

// public class TreeNode {
//       int val;
//      TreeNode left;
//       TreeNode right;
//       TreeNode(int x) { val = x; }
//   }

