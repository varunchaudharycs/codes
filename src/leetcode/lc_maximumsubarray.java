// https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3285/
// TIME - O(n^2)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_maximumsubarray {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();
        //int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr = {-1};
        int sum = obj.maxSubArray(arr);
        //System.out.println(sum);
        // int t = Integer.parseInt(buf.readLine());

        // for(int test = 1; test <= t; test++ ) {

        //     System.out.println("Case #" + test + ": " + new String(ans));
        // }
    }
    // BRUTE
    public int maxSubArray(int[] nums) {

        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < len; i++) {

            ArrayList<Integer> sums = new ArrayList<>();
            int sum = 0;
            for(int j = i; j < len; j++) {

                sum += nums[j];
                sums.add(sum);
            }
            if(Collections.max(sums) > maxSum) {
                maxSum = Collections.max(sums);
            }
        }

        return maxSum;
    }
}
