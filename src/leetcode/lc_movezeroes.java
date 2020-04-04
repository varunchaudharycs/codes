// https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3286/
// TIME - O(n-k)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_movezeroes {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();
        int[] arr = {0,1,0,3,12};
        obj.moveZeroes(arr);
    }
    // MINIMISE OPS - Double pointers - Slow(for current element's legit pos), Fast(for skipping non-zero ele)
    public void moveZeroes(int[] nums) {

        for(int fast = 0, slow = 0; fast < nums.length; fast++) {

            if(nums[fast] != 0) { // SWAP
                nums[slow] = nums[slow] ^ nums[fast] ^ (nums[fast] = nums[slow]);
                slow++;
            }
        }

        for(Integer v : nums) System.out.println(v);
    }
    // MINIMISE OPS - Swap pairs
//      public void moveZeroes(int[] nums) {
        
//         int len = nums.length;
//         int shifts = 0;

//         for(int i = 0; i < len; i++) {

//             if(nums[i] != 0) {
//                 nums[i - shifts] = nums[i]; // SWAP NUM with 0
//                 if(i != i - shifts) nums[i] = 0;
//             }
//             else
//                 shifts++; // 0 INCREASES SHIFT
//         }

//         for(Integer v : nums) System.out.println(v);
//     }
}
