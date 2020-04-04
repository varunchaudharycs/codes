// https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3286/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_movezeroes {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();
        int[] arr = {0,0,1};
        obj.moveZeroes(arr);
    }
    // MINIMISE OPS
     public void moveZeroes(int[] nums) {
        
        int len = nums.length;
        int shifts = 0;

        for(int i = 0; i < len; i++) {

            if(nums[i] != 0) {
                nums[i - shifts] = nums[i]; // SWAP NUM with 0
                if(i != i - shifts) nums[i] = 0;
            }
            else
                shifts++; // 0 INCREASES SHIFT
        }

        for(Integer v : nums) System.out.println(v);
    }


    // NO EXTRA SPACE
    // public void moveZeroes(int[] nums) {
        
    //     int len = nums.length;
    //     int zeroes = 0;

    //     for(int i = 0; i < len - zeroes;) {

    //         if(nums[i] == 0) {
    //             zeroes++;
    //             for(int j = i; j < len - zeroes; j++) { // LEFT SHIFT ELEMENTS
    //                 nums[j] = nums[j + 1];
    //             }
    //             nums[len - zeroes] = 0;
    //         }
    //         else 
    //             i++; // ONLY CHECK NEXT ELEMENT WHEN NO SHIFTING TAKES PLACE
    //     }
    //     for(Integer v : nums) System.out.println(v);
    // }

    // AUXILLARY ARRAY
    // public void moveZeroes(int[] nums) {
        
    //     int len = nums.length;
    //     int zeroes = 0;
    //     int[] newNums = new int[len];

    //     for(int i = 0, j = 0; i < len; i++) {

    //         if(nums[i] != 0) {

    //             newNums[j++] = nums[i];
    //         }
    //     }

    //     for(Integer i : newNums) System.out.println(i);
    // }
}
