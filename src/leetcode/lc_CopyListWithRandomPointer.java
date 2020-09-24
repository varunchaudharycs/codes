// https://leetcode.com/problems/copy-list-with-random-pointer/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class lc_CopyListWithRandomPointer {
    
    // LOGIC- keep each of the corresponding copy node next to the original node. 
    // Update random pointers.
    // Then decouple the copy from the original.
    public Node copyRandomList(Node head) {
        
        Node ptrOld = head;
        Node ptrNew;
        
        if(head == null) return null;
        
        while(ptrOld != null) {
            
            Node tmp = ptrOld.next;
            
            ptrNew = new Node(ptrOld.val);
            ptrOld.next = ptrNew;
            ptrNew.next = tmp;
            
            ptrOld = ptrOld.next.next;
        }
        
        Node headCopy = head.next;
        
        ptrOld = head;
        ptrNew = headCopy;
        
        while(ptrOld != null) {
            
            ptrNew.random = (ptrOld.random != null) ? ptrOld.random.next : null;
            
            ptrOld = ptrOld.next.next;
            ptrNew = (ptrNew.next != null) ? ptrNew.next.next : null;
        }
        
        headCopy = head.next;
        
        ptrOld = head;
        ptrNew = headCopy;
        
        while(ptrOld != null) {
            
            ptrOld.next = ptrOld.next.next;
            ptrNew.next = (ptrNew.next != null) ? ptrNew.next.next : null;
            
            ptrOld = ptrOld.next;
            ptrNew = ptrNew.next;
        }
        
        return headCopy;
    }
    
    
    
    // LOGIC- map old address to new address at SAME position
//     public Node copyRandomList(Node head) {
        
//         Node copy = new Node(-1);
//         Node copyHead = copy;
        
//         Node ptr = head;
        
//         HashMap<Node, Node> ogToCopy = new HashMap<>(); // map old to new address
         
//         while(ptr != null) {
            
//             copy.next = new Node(ptr.val);
//             copy = copy.next;
//             ogToCopy.put(ptr, copy);
            
//             ptr = ptr.next;
//         }
        
//         copyHead = copyHead.next;
        
//         ptr = head;
//         copy = copyHead;
        
//         while(ptr != null) {
            
//             copy.random = ogToCopy.get(ptr.random);
            
//             copy = copy.next;
//             ptr = ptr.next;
//         }
        
//         return copyHead;
//     }
}