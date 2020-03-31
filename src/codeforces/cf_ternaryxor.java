// https://codeforces.com/contest/1328/problem/C
// TIME - O(n)
package codeforces;
import java.io.*;
import java.util.*;

public class cf_ternaryxor {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        while(t-- > 0) {

            int n = Integer.parseInt(buf.readLine());
            String x = buf.readLine();
            String a = "1";
            String b = "1";

            for(int i = 1; i < n; i++) {

                int digitX = Character.getNumericValue(x.charAt(i));
                int digitA = 0, digitB = 0;
    
                if(digitX == 2) {
                    digitA = 1;
                    digitB = 1;
                }
                else if(digitX == 1) {
                    
                    a += (digitX + "0".repeat(n - i - 1));
                    b += ("0" + x.substring(i + 1, n));
                    break;
                }

                a += digitA;
                b += digitB;
            }

            System.out.println(a);
            System.out.println(b);
        }
    }
}
