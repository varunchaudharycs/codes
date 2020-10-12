// https://leetcode.com/problems/validate-binary-search-tree/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

class lc_validatebinarysearchtree {
    public boolean isValidBST(TreeNode root) {

        if(root == null) return true;
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper) {

        if(root == null) return true;

        if(lower != null && root.val <= lower) return false;
        if(upper != null && root.val >= upper) return false;
        // set upper bound for left sub-tree
        boolean left_helper = helper(root.left, lower, root.val);
        // set lower bound for right sub-tree
        boolean right_helper = helper(root.right, root.val, upper);

        return left_helper && right_helper;
    }
}
