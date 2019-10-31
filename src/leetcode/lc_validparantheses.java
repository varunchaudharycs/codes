package leetcode;

import java.util.Stack;

class lc_validparantheses {
    public boolean isValid(String s) {
        // String length
        int len = s.length();
        // Stack implementation - open bracket = push(), closed bracket = pop()
        Stack<Character> stack = new Stack<Character>();
        char ch;
        // Traversing string
        for(int i = 0; i < len; i++) {
            
            ch = s.charAt(i);
            // Check if push() or pop() operation
            // push()
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(new Character(ch));
            }
            // pop()
            else {
                // Invalid - empty stack(closing bracket before opening bracket)
                if(stack.empty()) {
                    return false;
                }
                // Valid
                if((ch ==')' && stack.peek() == '(') || (ch =='}' && stack.peek() == '{') || (ch ==']' && stack.peek() == '[')) {
                    stack.pop();
                }
                // Invalid - mismatch brackets
                else {
                    return false;
                }
            }
        }
        // Check - Remaining unclosed brackets
        if(stack.empty()) {
            return true;
        }
        else {
            return false;
        }
            
    }
}


/* VERSION 2
CLEANER (but SLOWER)
class leetcode.lc_validparantheses {
    public boolean isValid(String s) {
        // String length
        int len = s.length();
        // Stack implementation - open bracket = push(), closed bracket = pop()
        Stack<Character> stack = new Stack<Character>();
        // Hashmap to contain matching bracket pairs
        HashMap<Character, Character> hm = new HashMap<Character, Character>() {{ 
            put('}', '{'); 
            put(')', '('); 
            put(']', '[');
            }};
        char ch;
        // Traversing string
        for(int i = 0; i < len; i++) {
            
            ch = s.charAt(i);
            // Check if bracket - open or closed
            // OPEN - push onto stack
            // CLOSED -
            // a. if stack empty - VALID
            // b. if TOS matches bracket - VALID
            // c. if TOS does not match bracket - INVALID
            
            // CLOSED bracket with empty stack - INVALID
            if(hm.containsKey(ch) && stack.empty()) {
                return false;
            }
            // CLOSED bracket - VALID
            else if(hm.containsKey(ch) && stack.peek() == hm.get(ch)) {
                stack.pop();
            }
            // CLOSED bracket mismatch - INVALID
            else if(hm.containsKey(ch) && stack.peek() != hm.get(ch)) {
                return false;
            }
            // OPEN bracket
            else if(!hm.containsKey(ch)) {
                stack.push(ch);
            }
            else {
                System.out.println("Unhandled case");
            }
        }
        // Check - Any remaining unclosed brackets
        if(stack.empty()) {
            return true;
        }
        else {
            return false;
        }
            
    }
}
*/
