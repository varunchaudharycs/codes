// https://leetcode.com/problems/invert-binary-tree/
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
class lc_invertbinarytree {
    public TreeNode invertTree(TreeNode root) {
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        TreeNode curr, tmp;
        if(root == null) return null;
        
        while(!nodes.isEmpty()) {
            
            curr = nodes.poll();
            if(curr == null) continue;
            // invert left & right children
            if(curr.left != null || curr.right != null) {
                tmp = curr.left;
                curr.left = curr.right;
                curr.right = tmp;
                if(curr.left != null) nodes.add(curr.left);
                if(curr.right != null) nodes.add(curr.right);
            }
        }
        return root;
    }
}
