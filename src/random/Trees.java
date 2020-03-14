package random;
import java.io.*;
import java.util.*;

class Node
{
    private Node left, right;
    private int data;

    public Node(int item) {

        data = item;
        left = right = null;

    }

    static public boolean insert(Node parent, int item) {

        Queue<Node> q = new LinkedList<>();
        
        q.add(parent);
        
        while(!q.isEmpty()) {
            
            Node visited_node = q.poll();
            
            if(visited_node.left == null) {
                visited_node.left = new Node(item);
                return true;
            }
            if(visited_node.right == null) {
                visited_node.right = new Node(item);
                return true;
            }
            
            q.add(visited_node.left);
            q.add(visited_node.right);
        }
        
        return false;
    }

    static public void inorder(Node parent) {

        if(parent != null) {
            inorder(parent.left);
            System.out.println(parent.data);
            inorder(parent.right);
        }
    }

    static public void preorder(Node parent) {

        if(parent != null) {
            System.out.println(parent.data);
            preorder(parent.left);
            preorder(parent.right);
        }
    }

    static public void postorder(Node parent) {

        if(parent != null) {
            postorder(parent.left);
            postorder(parent.right);
            System.out.println(parent.data);
        }
    }

    static public void levelorder(Node parent) {

        Queue<Node> q = new LinkedList<>();
        q.add(parent);

        while(!q.isEmpty()) {

            Node visited_node = q.poll();

            System.out.println(visited_node.data);

            if(visited_node.left != null)
                q.add(visited_node.left);
            if(visited_node.right != null)
                q.add(visited_node.right);
        }
    }

    static public boolean bfs(Node root, int item) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {

            Node visited_node = q.poll();

            if(visited_node.data == item) {
                System.out.println("Found : " + visited_node.data);
                return true;
            }

            if(visited_node.left != null)
                q.add(visited_node.left);
            if(visited_node.right != null)
                q.add(visited_node.right);
        }
        System.out.println("Not Found : " + item                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                );
        return false;
    }

    static public boolean dfs(Node root, int item) {

        Stack<Node> s = new Stack<>();

        s.add(root);

        while(!s.isEmpty()) {

             Node visited_node = s.pop();

             if(visited_node.data == item) {
                 System.out.println("Found : " + visited_node.data);
                 return true;
             }
             if(visited_node.left != null)
                 s.add(visited_node.left);
             if(visited_node.right != null)
                 s.add(visited_node.right);

        }
        System.out.println("Not Found : " + item);
        return false;

    }
    
    static public boolean delete(Node parent, int item) {
        
        Node target = null;
        Node last_parent = null;
        Node last_visited = null;
        
        if(parent == null)
            return false;
        if(parent.left == null && parent.right == null && parent.data == item) {
            parent.data = -1;
            return true;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(parent);
        
        while(!q.isEmpty()) {
            
            last_visited = q.poll();
            
            if(last_visited.data == item)
                target = last_visited;
            
            if(last_visited.left != null) {
                q.add(last_visited.left);
                last_parent = last_visited;
            }
            if(last_visited.right != null) {
                q.add(last_visited.right);
                last_parent = last_visited;
            }
        }
        
        if(target == null)
            return false;
        else {
            target.data = last_visited.data;
            if(last_parent.left != null)
                last_parent.left = null;
            if(last_parent.right != null)
                last_parent.right = null;
        }
        
        return false;
    }
    
    static public boolean isBST(Node root) {
        
        if(root == null)
            return true;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            Node visited_node = q.poll();
            
            if(visited_node.left != null) {
                if(visited_node.left.data > visited_node.data)
                    return false;
                else
                    q.add(visited_node.left);
            }
            if(visited_node.right != null) {
                if(visited_node.right.data < visited_node.data)
                    return false;
                else
                    q.add(visited_node.right);
            }
        }
        
        return true;
    }
    
    static public boolean isBalaned(Node root) {
        
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
    
    static public int findHeight(Node parent) {
        
        if(parent == null)
            return 0;
        
        int height_left = findHeight(parent.left);
        int height_right = findHeight(parent.right);
        
        return 1 + Math.max(height_left, height_right);
    }
    
}

class Trees
{
    public static void main(String args[])throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(3);

        Node.insert(root, 2);

        Node.insert(root, 4);

        Node.insert(root, 5);

        Node.insert(root, 5);

        Node.insert(root, 6);
        
        //Node.delete(root, 1);
        
        //System.out.println(Node.isBST(root));
        //Node.levelorder(root);
        //Node.bfs(root, -1);

        //Node.dfs(root, 5);
    
        System.out.println(Node.isBalaned(root));
        
    }
}
