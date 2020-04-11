// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3292/
// TIME - O(1)
package leetcode;
import java.io.*;
import java.util.*;

class lc_minstack {
    
    int minEle;
    Stack<Integer> st;
    /** initialize your data structure here. */
    public lc_minstack() {
        minEle = Integer.MAX_VALUE;
        st = new Stack<Integer>();
    }
    
    public void push(int x) {
        
        minEle = (x < minEle) ? x : minEle;

        st.push(x);
    }
    
    public void pop() {

        if(st.isEmpty()) return; // EMPTY STACK

        int popEle = st.pop();

        if(popEle == minEle) { // IF POPPED ELEMENT IS MIN ELE, FIND NEW MIN
            minEle = Integer.MAX_VALUE;

            Iterator it = st.iterator();

            while(it.hasNext()) {
                int ele = (int)it.next();
                minEle = (ele < minEle) ? ele: minEle;
            }
        }
    }
    
    public int top() {

        if(st.isEmpty()) 
            return Integer.MIN_VALUE;
        else 
            return st.peek();        
    }
    
    public int getMin() {
        
        return minEle;
    }

    public static void main(String[] args)throws IOException {
        lc_minstack minStack = new lc_minstack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // --> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }
}

