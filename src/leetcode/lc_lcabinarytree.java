// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// TIME - O(n)
// Ref- https://www.youtube.com/watch?v=13m9ZCB8gjw

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class lc_lcabinarytree {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;
        
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode left_subtree = lowestCommonAncestor(root.left, p, q);
        TreeNode right_subtree = lowestCommonAncestor(root.right, p, q);
        
        if(left_subtree == null && right_subtree == null) return null;
        if(left_subtree != null && right_subtree != null) return root;
        
        return (left_subtree != null) ? left_subtree : right_subtree;
    }
}
