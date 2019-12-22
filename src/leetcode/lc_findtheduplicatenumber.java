package leetcode;///

import java.io.*;
import java.util.*;
// https://leetcode.com/problems/find-the-duplicate-number/submissions/

// TIME - O(n)
// SPACE - O(n) or O(1)

public class lc_findtheduplicatenumber
{
    public int findDuplicate(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) {
            if(!hs.add(num))
                return num;
        }
    
        // SPACE - O(1)
//        for(int i = 0; i < nums.length; ++i) {
//            if(nums[Math.abs(nums[i]) - 1] < 0)
//                return Math.abs(nums[i]);
//            else
//                nums[Math.abs(nums[i]) - 1] = 0 - nums[Math.abs(nums[i]) - 1];
//        }
        return -1;
    }
}
