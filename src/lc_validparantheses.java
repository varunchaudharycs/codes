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
