// https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/529/week-2/3291/
// TIME - O(n), SPACE - O(1) || O(n + m)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_backspacestringcompare {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        lc_backspacestringcompare obj = new lc_backspacestringcompare();

        String S = "y#fo##f", T = "y#f#o##f"; // S = "a#c", T = "b"

        System.out.println(obj.backspaceCompare(S, T));

    }
    // SPACE - O(1)
    // END -> START, CONSIDER # AS JUMPS
    public boolean backspaceCompare(String S, String T) {
        
        boolean Sready = false, Tready = false;
        int Sjumps = 0, Tjumps = 0;
        int i = S.length() - 1, j = T.length() - 1;
        while((i >= 0 || j >= 0)
                && !(Sready && j < 0) //. CHECK IF ONE POINTER IS NOT STUCK
                && !(Tready && i < 0)) { // i - Pointer for S, j - Pointer for T

            if(!Sready && i >= 0) // CHECK WHETHER TO JUMP OR INCLUDE
                if(S.charAt(i) == '#') 
                    Sjumps++;
                else
                    if(Sjumps > 0)
                        Sjumps--;
                    else
                        Sready = true;

            if(!Tready && j >= 0) // CHECK WHETHER TO JUMP OR INCLUDE
                if(T.charAt(j) == '#') 
                    Tjumps++;
                else
                    if(Tjumps > 0)
                        Tjumps--;
                    else
                        Tready = true;

            if(Tready && Sready) // COMPARE
                if(S.charAt(i) != T.charAt(j))
                    return false;
                else {
                    i--; j--; 
                    Sready = false; Tready = false;
                    continue;
                }
            if(!Sready) i--;
            if(!Tready) j--;
        }
        if(!Sready && !Tready) // NOTHING LEFT TO MATCH
            return true;
        else
            return false;
    }
    // SPACE - O(n + m)
    // USE 2 STACKS - char "#" represents POP operation, else PUSH
//    public boolean backspaceCompare(String S, String T) {
//
//        Stack<Character> a = new Stack<>();
//        Stack<Character> b = new Stack<>();
//
//        for(int i = 0, j = 0; i < S.length() || j < T.length(); i++, j++) {
//
//            if(i < S.length())
//                if(S.charAt(i) == '#' && !a.isEmpty())
//                    a.pop(); // DELETE CHAR
//                else if(S.charAt(i) != '#')
//                    a.push(S.charAt(i)); // ADD CHAR
//
//            if(j < T.length())
//                if(T.charAt(j) == '#' && !b.isEmpty())
//                    b.pop(); // DELETE CHAR
//                else if(T.charAt(j) != '#')
//                    b.push(T.charAt(j)); // ADD CHAR
//        }
//
//       if(a.size() != b.size()) return false; // UNEQUAL SIZE
//
//        while(!a.isEmpty()) { // MATCH ELEMENTS OF THE TWO STACKS
//
//            if(a.pop() != b.pop()) return false; // MISMATCH
//        }
//
//        return true; // EQUAL STACKS
//    }
}
