// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/
// TIME - O(2n)
package leetcode;
import java.io.*;
import java.util.*;

class lc_productexceptself {

    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        lc_productexceptself obj = new lc_productexceptself();
        while(true) {
            // STRING VARIABLE
             String s = buf.readLine();
             s = s.replaceAll("\"","").replaceAll("\\[","").replaceAll("\\]","");
            // STRING ARRAY
            String[] srr = s.split(",");
            // INT ARRAY
            int[] arr = new int[srr.length];
            for(int i = 0; i < srr.length; i++) arr[i] = Integer.parseInt(srr[i]);

            int[] ans = obj.productExceptSelf(arr);
            for(int i : ans) System.out.print(i + " ");
        }
    }
    // 1 : ITERATE O/P ARRAY FROM RIGHT ACCUMULATING PRODUCTS FROM ORIGINAL ARRAY
    // 2 : OUTPUT[i] = ACCUMULATED PRODUCT OF ORIGINAL[i-1] * OUTPUT[i+1]
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] output = new int[len];
        
        output[len - 1] = nums[len - 1]; // FILL OUTPUT ARRAY (ACCUMULATED PRODUCT FROM ORIGINAL ARRAY)
        for(int i = len - 2; i >=0; i--)
            output[i] = output[i+1] * nums[i];

        for(int i = 0; i < len; i++) { // OUTPUT[i] = NUMS[i-1] * OUTPUT[i+1]

            if(i == 0) {
                output[i] = output[i+1];
            }
            else if(i == len - 1) {
                output[i] = nums[i-1];
            }
            else {
                output[i] = nums[i-1] * output[i+1];
                nums[i] *= nums[i-1];
            }
        }
        return output;
    }
}

