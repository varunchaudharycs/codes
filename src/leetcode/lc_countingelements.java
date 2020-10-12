// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
// TIME - O(2n)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_countingelements {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        lc_countingelements obj = new lc_countingelements();

        int[] arr = {1,1,2,2};
        
        System.out.println(obj.countElements(arr));
    }
    // FIRST PASS - store qualified nums
    // SECOND PASS - count nums
    public int countElements(int[] arr) {

        int len = arr.length;
        HashSet<Integer> qualified = new HashSet<>();
        int count = 0;

        for(int ele : arr) qualified.add(ele - 1); // ADD QUALIFIED NUMBERS
        for(int ele : arr) if(qualified.contains(ele)) count++; // COUNT QUALIFIED NUMBERS

        return count;         
    }
}
