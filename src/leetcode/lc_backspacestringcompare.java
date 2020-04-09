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
    // Collect string along the way w/ backspaces
    public boolean backspaceCompare(String S, String T) {
        
        StringBuilder a = new StringBuilder("");
        StringBuilder b = new StringBuilder("");

        for(int i = 0, j = 0; i < S.length() || j < T.length(); i++, j++) {

            if(i < S.length())
                if(S.charAt(i) == '#' && a.length() > 0) 
                    a.setLength(a.length() - 1); // DELETE CHAR
                else if(S.charAt(i) != '#')
                    a.append(S.charAt(i)); // ADD CHAR

            if(j < T.length())
                if(T.charAt(j) == '#' && b.length() > 0) 
                    b.setLength(b.length() - 1); // DELETE CHAR
                else if(T.charAt(j) != '#')
                    b.append(T.charAt(j)); // ADD CHAR
        }

        return a.toString().equals(b.toString()); // MATCH STRINGS
    }
}
