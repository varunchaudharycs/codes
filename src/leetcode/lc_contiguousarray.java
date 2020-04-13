// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

class lc_contiguousarray {

    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        // STRING VARIABLE
         String s = buf.readLine();
         // INT VARIABLE
      //   int n = Integer.parseInt(s);
        // STRING ARRAY
        String[] srr = s.split(",");
        // INT ARRAY
        int[] arr = new int[srr.length];
        for(int i = 0; i < srr.length; i++) arr[i] = Integer.parseInt(srr[i]);
        
        lc_contiguousarray obj = new lc_contiguousarray();
        int ans = obj.findMaxLength(arr);
        System.out.println(ans);
    }
    // Use COUNT = +1 for 1s, -1 for 0s
    // Use HashMap to track indices where of first COUNT values(0, 1, -1, -2, 2...)
    // FIND LARGEST INTERVAL WHERE COUNT VALUE END-POINTS ARE SAME
    // Viz- plot values on graph. Peaks and valleys. Need to find longest distance between same COUNT values
    // NOTE- In the plot, if the line crosses a point it has previously gone thru = this interval has equal 0S & 1s
    // Eg, count = -1 at Idx 3 then again at Idx 7. So from 3->7 equal 0s & 1s. If again at Idx 9 then 3->9 interval
    public int findMaxLength(int[] nums) {

        int count = 0;
        int maxL = 0;
        HashMap<Integer, Integer> count_idx = new HashMap<>(){{ // DEFAULT COUNT = 0 START
            put(0, -1);
        }};
        for(int i = 0; i < nums.length; i++) {

            count = (nums[i] == 1) ? count + 1 : count - 1;

            if(count_idx.containsKey(count)) // EQUAL COUNT REGION
                maxL = Math.max(maxL, i - count_idx.get(count)); 
            else
                count_idx.put(count, i); // FIRST COUNT ENTRY TO MAP
        }
        return maxL;
    }



    // BRUTE(TLE !!)- Trim search if better answer available
    // public int findMaxLength(int[] nums) {

    //     int len = nums.length, maxL = 0;
    //     for(int i = 0; i < len; i++)
    //         for(int j = len - 1; j >= i + 1; j--) {

    //             int subL = j - i + 1;
    //             if(subL <= maxL) // NOT WORTH IT, BETTER ANSWER AVAILABLE
    //                 break;
    //             if((subL & 1) == 0) { // EVEN
    //                 if(Arrays.stream(nums, i, j + 1).sum() * 2 == subL) { // SUM = LEN / 2
    //                     maxL = Math.max(maxL, subL);
    //                 }
    //             }
    //         }
    //     return maxL;
    // }

    // RECURSIVE(TLE !!)- TAKE ENTIRE ARRAY, TRIM FROM EACH SIDE UNTIL SUM = LENGTH / 2
    // Keep global variable(int maxL = 0;) to terminate recursive calls whose subarray length is < maxL
    // public int findMaxLength(int[] nums) {

    //     int sum = Arrays.stream(nums).sum();
    //     int start = 0, end = nums.length - 1;
    //     return helper(nums, start, end, sum);
    // }

    // public int helper(int[] nums, int start, int end, int sum) {

    //     if((end - start + 1) <= maxL || start >= end) // NO RESULT
    //         return 0;

    //     if(((end - start + 1) & 1) == 0 // EVEN-SIZE SUB-ARRAY
    //         && sum * 2 == (end - start + 1)) { // SUM = LENGTH / 2 (even 0s & 1s)
    //         maxL = Math.max(maxL, (end - start + 1)); // UPDATE MAX SUB ARRAY LENGTH
    //     }

    //     helper(nums, start + 1, end, sum - nums[start]);
    //     helper(nums, start, end - 1, sum - nums[end]);

    //     return maxL;
    // }
}

