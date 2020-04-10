// https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/529/week-2/3291/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_backspacestringcompare {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();

        String S = "y#fo##f", T = "y#f#o##f"; // S = "a#c", T = "b"

        System.out.println(obj.backspaceCompare(S, T));

    }
    // USE 2 STACKS - char "#" represents POP operation, else PUSH
    public boolean backspaceCompare(String S, String T) {
        
        Stack<Character> a = new Stack<>();
        Stack<Character> b = new Stack<>();

        for(int i = 0, j = 0; i < S.length() || j < T.length(); i++, j++) {

            if(i < S.length())
                if(S.charAt(i) == '#' && !a.isEmpty()) 
                    a.pop(); // DELETE CHAR
                else if(S.charAt(i) != '#')
                    a.push(S.charAt(i)); // ADD CHAR

            if(j < T.length())
                if(T.charAt(j) == '#' && !b.isEmpty()) 
                    b.pop(); // DELETE CHAR
                else if(T.charAt(j) != '#')
                    b.push(T.charAt(j)); // ADD CHAR
        }

       if(a.size() != b.size()) return false; // UNEQUAL SIZE
        
        while(!a.isEmpty()) { // MATCH ELEMENTS OF THE TWO STACKS
            
            if(a.pop() != b.pop()) return false; // MISMATCH
        }

        return true; // EQUAL STACKS
    }
}
