// https://leetcode.com/problems/single-number/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_singlenumber {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        lc_singlenumber obj = new lc_singlenumber();
        int[] arr = {2,0,2,1,1,0,3};
        System.out.println(obj.singleNumber(arr));
    }

    // ONE-PASS ()
    public int singleNumber(int[] nums) {

        for(int i = 1; i < nums.length; i++) nums[i] ^= nums[i-1];
        
        return nums[nums.length-1];
    }

    // // HASHMAP
    // public int singleNumber(int[] nums) {

    //     HashMap<Integer, Integer> num_count = new HashMap<>();

    //     for(int num : nums) 
    //         num_count.put(num, num_count.getOrDefault(num, 0) + 1);

    //     for(Map.Entry<Integer, Integer> entry : num_count.entrySet()) {

    //         if(entry.getValue() == 1) return entry.getKey();
    //     }
    //     return -1;
    // }
}
