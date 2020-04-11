// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3292/
// TIME - O(1)
package leetcode;
import java.io.*;
import java.util.*;

class lc_minstack {
    
    Stack<Integer> st;
    Stack<Integer> minst;

    public lc_minstack() { //INIT
        minst = new Stack<Integer>();
        st = new Stack<Integer>();
    }
    
    public void push(int x) {
        
        st.push(x);
        if(minst.isEmpty()) minst.push(x);
        else minst.push(Math.min(x, minst.peek())); // NEW MIN ?
    }
    
    public void pop() {

        if(st.isEmpty()) return;

        st.pop(); 
        minst.pop();
    }
    
    public int top() {

        if(st.isEmpty()) 
            return Integer.MIN_VALUE;
        else 
            return st.peek();        
    }
    
    public int getMin() {
        
        if(!minst.isEmpty()) return minst.peek();
        else return Integer.MAX_VALUE;
    }

    public static void main(String[] args)throws IOException {
        lc_minstack minStack = new lc_minstack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());  // --> Returns -3.
        minStack.pop();
        //System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }
}

