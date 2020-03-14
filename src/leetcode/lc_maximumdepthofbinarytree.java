// https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
class lc_maximumdepthofbinarytree {
    public int maxDepth(TreeNode root) {
        
        if(root == null) return 0;
        
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        
        return 1 + Math.max(left_height, right_height);
    }
}
