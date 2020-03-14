package random;

import java.io.*;
import java.util.*;

class BSTNode {
    
    BSTNode left, right;
    int data;
    
    public BSTNode(int item) {
        
        data = item;
        left = right = null;
    }
    
    public BSTNode() {
        
        left = right = null;
    }
    
    static public boolean insert(BSTNode parent, int item) {
        
        if(parent == null) {
            parent = new BSTNode();
            parent.data = item;
            return true;
        }
        Queue<BSTNode> q = new LinkedList<>();
        q.add(parent);
        
        while(!q.isEmpty()) {
            
            BSTNode visited_node = q.poll();
            
            if(item <= visited_node.data) {
                if(visited_node.left == null) {
                    visited_node.left = new BSTNode(item);
                    return true;
                }
                else
                    q.add(visited_node.left);
            }
            if(item > visited_node.data) {
                if(visited_node.right == null) {
                    visited_node.right = new BSTNode(item);
                    return true;
                }
                else
                    q.add(visited_node.right);
            }
        }
        return false;
    }
    
    static public void levelorder(BSTNode parent) {
        
        if(parent == null) {
            System.out.println("No elements in tree");
        }
        Queue<BSTNode> q = new LinkedList<>();
        q.add(parent);
        
        while(!q.isEmpty()) {
            
            BSTNode visited_node = q.poll();
            
            System.out.println(visited_node.data);
            
            if(visited_node.left != null)
                q.add(visited_node.left);
            if(visited_node.right != null)
                q.add(visited_node.right);
        }
    }
    
    public static int findHeight(BSTNode parent) {
        
        if(parent == null)
            return 0;
        
        int max_height = Math.max(findHeight(parent.left), findHeight(parent.right));
        
        return 1 + max_height;
    }
    
    public static boolean isSame(BSTNode root1, BSTNode root2) {
        
        if(root1 == null & root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        
        Queue<BSTNode> q1 = new LinkedList<>();
        q1.add(root1);
        Queue<BSTNode> q2 = new LinkedList<>();
        q2.add(root2);
        
        while(!q1.isEmpty() && !q2.isEmpty()) {
            
            BSTNode visited_node1 = q1.poll();
            BSTNode visited_node2 = q2.poll();
            
            if(visited_node1.data != visited_node2.data)
                return false;
            if(visited_node1.left != null)
                q1.add(visited_node1.left);
            if(visited_node1.right != null)
                q1.add(visited_node1.right);
            if(visited_node2.left != null)
                q2.add(visited_node2.left);
            if(visited_node2.right != null)
                q2.add(visited_node2.right);
        }
        
        return q1.isEmpty() && q2.isEmpty();
    }
    
    public static BSTNode createBST(int arr[]) {
        
        BSTNode root = null;
        if(arr.length == 0) {
            System.out.println("No elements present.");
        }
        else {
            
            root = new BSTNode(arr[0]);
            Queue<BSTNode> q = new LinkedList<>();
            q.add(root);
            
            for(int i = 1; i < arr.length; ++i)
                BSTNode.insert(root, arr[i]);
        }
        return root;
    }
    
    static public boolean isBalaned(BSTNode root) {
        
        if(root == null)
            return true;
        
        int height_left = findHeight(root.left);
        int height_right = findHeight(root.right);
        
        if(Math.abs(height_left - height_right) > 1)
            return false;
        else {
            isBalaned(root.left);
            isBalaned(root.right);
        }
        return true;
    }
    
    static public int findSize(BSTNode root) {
        
        if(root == null)
            return 0;
        
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);
        int size = 1;
        
        while(!q.isEmpty()) {
            
            BSTNode visited_node = q.poll();
            
            if(visited_node.left != null) {
                q.add(visited_node.left);
                size++;
            }
            if(visited_node.right != null) {
                q.add(visited_node.right);
                size++;
            }
        }
        return size;
    }
    
    public static int findLCA(BSTNode root, int item1, int item2) {
        
        if(root == null)
            throw new IllegalArgumentException("The tree is empty");
        
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            BSTNode visited_node = q.poll();
            
            if(visited_node.data == item1 || visited_node.data == item2)
                return visited_node.data;
            
            if(visited_node.data >= item1 && visited_node.data >= item2) {
                if (visited_node.left != null)
                    q.add(visited_node.left);
            }
            else if(visited_node.data <= item1 && visited_node.data <= item2) {
                if (visited_node.right != null)
                    q.add(visited_node.right);
            }
            else
                return visited_node.data;
        }
        
        throw new IllegalArgumentException("Result not found");
    }
    
    public static int findBreadth(BSTNode parent) {
        
        
        
        return -1;
    }
    
    public static int findDiameter(BSTNode parent) {
        
        
        
        return -1;
    }
}

class BSTs {
    
    public static void main(String args[]) throws IOException {
        
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        BSTNode root = new BSTNode(3);
        
        BSTNode.insert(root, 1);
    
        BSTNode.insert(root, 2);
    
        BSTNode.insert(root, 4);
    
        BSTNode.insert(root, 5);
    
        BSTNode.insert(root, -1);
        
        int[] arr = {3, 4, 5, 6, 7};
        
        BSTNode new_root = BSTNode.createBST(arr);
    
        BSTNode.levelorder(new_root);
        
        System.out.println("Height : " + BSTNode.findHeight(new_root));
        
        System.out.println("Same ? " + BSTNode.isSame(root, new_root));
    
        System.out.println("Balanced? " + BSTNode.isBalaned(root));
        System.out.println("Balanced? " + BSTNode.isBalaned(new_root));
        
        System.out.println("Size : " + BSTNode.findSize(root));
        
        System.out.println("LCA : " + BSTNode.findLCA(root, 4, 5));
    }
}