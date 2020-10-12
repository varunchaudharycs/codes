// https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3284/
// TIME - 
package leetcode;
import java.io.*;
import java.util.*;

public class lc_happynumber {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        lc_happynumber obj = new lc_happynumber();
        int[] arr = {3, 6, 1, 5, 4};
        System.out.println(obj.isHappy(18));
    }

    public int digitSquareSum(int num) {

        int sum = 0;
        while(num > 0) {
           sum += Math.pow(num % 10, 2);
           num /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {

        int count = 0; // threshold to prevent infinite loop
        while(n != 1 && count < 1000) {
            n = digitSquareSum(n);
            count++;
        } 
            
        if(n == 1) 
            return true;
        else
            return false;
    }
}
