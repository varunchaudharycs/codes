package leetcode;///

import java.io.*;
import java.util.*;
// https://leetcode.com/problems/find-the-duplicate-number/submissions/

// TIME - O(n)
// SPACE - O(n)

public class lc_findtheduplicatenumber
{
    public int findDuplicate(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) {
            if(!hs.add(num))
                return num;
        }
        return -1;
    }
}
