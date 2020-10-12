// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// TIME - O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/
package leetcode;
import java.io.*;
import java.util.*;
class lc_lcabst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while(root != null) {

            if(p.val > root.val && q.val > root.val) root = root.right; // both lesser
            else if(p.val < root.val && q.val < root.val) root = root.left; // both greater
            else return root; // split
        }
        return null;
    }
}
