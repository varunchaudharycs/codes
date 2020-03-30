// https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
class lc_maximumdepthofbinarytree {
    // RECURSIVE
    public int maxDepth(TreeNode root) {
        
        if(root == null) return 0;
        
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        
        return 1 + Math.max(left_height, right_height);
    }
    // ITERATIVE
//     public int maxDepth(TreeNode root) {
//         // increment depth by 1 when all nodes of the corresponding level are visited
//         Queue<TreeNode> nodes = new LinkedList<>();
//         if(root == null) return 0;
//         nodes.add(root);
//         int depth = 0, nodes_count = 0;
//         TreeNode curr_node;
        
//         while(!nodes.isEmpty()) {
//             for(nodes_count = nodes.size(); nodes_count > 0; nodes_count--) {
//                 curr_node = nodes.poll();
//                 if(curr_node.left != null) nodes.add(curr_node.left);
//                 if(curr_node.right != null) nodes.add(curr_node.right);
//             }
//             depth++;
//         }
//        return depth;
//     }
}
