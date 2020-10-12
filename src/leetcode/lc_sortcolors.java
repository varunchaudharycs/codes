// https://leetcode.com/problems/sort-colors/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_sortcolors {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        lc_sortcolors obj = new lc_sortcolors();
        obj.dutch_flag(new int[] {2,0,2,1,1,0});
    }
    // ONE-PASS
    public void dutch_flag(int[] nums) {

        int a0 = -1, a1 = -1, a2 = -1;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 0) {
                nums[++a2] = 2;
                nums[++a1] = 1;
                nums[++a0] = 0;
            }
            else if(nums[i] == 1) {
                nums[++a2] = 2;
                nums[++a1] = 1;
            }
            else if(nums[i] == 2) {
                nums[++a2] = 2;
            }

        }

        for(int num : nums) System.out.print(num + " ");
    }

    // COUNTING SORT
    // public void dutch_flag(int[] nums) {

    //     int[] count = new int[3];

    //     for(int i : nums) count[i]++;

    //     for(int i = 0, num = 0; i < nums.length; num++) {
    //         for(int j = 0; j < count[num]; j++) {
    //             nums[i] = num;
    //             i++;
    //         }
    //     }

    //     for(int num : nums) System.out.print(num + " ");
    // }
}
