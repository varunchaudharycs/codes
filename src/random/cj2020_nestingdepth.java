// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209a9f
// TIME - O(n)
// Note - String repeat in JAVA 11
package random;
import java.io.*;
import java.util.*;

public class cj2020_nestingdepth {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int test = 1; test <= t; test++ ) {

            String s = buf.readLine();
            String ans = "";
            int open = 0; // count of open braces

            for(int i = 0; i < s.length(); i++) {

                int digit = Character.getNumericValue(s.charAt(i));
                int needed = digit  - open; 

                if(needed == 0) { 
                    ans += digit;
                }
                else if(needed > 0) {
                    ans += "(".repeat(needed) + digit;
                    open += needed;                 
                }
                else {
                    ans += ")".repeat(Math.abs(needed)) + digit;
                    open -= Math.abs(needed);                       
                }
            }
            if(open > 0) ans += ")".repeat(open);
           
            System.out.println("Case #" + test + ": " + ans);
        }
    }

    
}
