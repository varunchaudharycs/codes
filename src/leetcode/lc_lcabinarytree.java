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
package leetcode;
import java.io.*;
import java.util.*;
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
    // ITERATIVE
    
    // Store ANCESTORS OF P & Q
    // FIRST COMMON ANCESTORS(bottom-up) = LCA
    
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
//         TreeNode curr;
//         // store parents
//         HashMap<TreeNode, TreeNode> node_parent = new HashMap<>() {{
//             put(root, null);
//         }}; 
//         // store nodes
//         Stack<TreeNode> nodes = new Stack<>() {{
//            push(root); 
//         }};
//         // store all parents
//         while(!node_parent.containsKey(p) || !node_parent.containsKey(q)) {
//             curr = nodes.pop();
//             // left child
//             if(curr.left != null) {
//                 nodes.push(curr.left);
//                 node_parent.put(curr.left, curr);
//             }
//             // right child
//             if(curr.right != null) {
//                 nodes.push(curr.right);
//                 node_parent.put(curr.right, curr);
//             }
//         }
        
//         HashSet<TreeNode> p_ancestors = new HashSet<>() {{
//             add(p);
//         }};
//         curr = p;
//         while(curr != null) {
//             p_ancestors.add(node_parent.get(curr));
//             curr = node_parent.get(curr);
//         }
//         curr = q;
//         while(!p_ancestors.contains(curr)) {
//             curr = node_parent.get(curr);
//         }
//         return curr;
//     }
}
