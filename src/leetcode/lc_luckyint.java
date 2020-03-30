// https://leetcode.com/contest/weekly-contest-182/problems/find-lucky-integer-in-an-array/
// TIME - O(n)

import java.io.*;
import java.util.*;


class lc_luckyint {
    public int findLucky(int[] arr) {
        
        HashMap<Integer, Integer> num_count = new HashMap<>();
        
        for(Integer i : arr) num_count.put(i, num_count.getOrDefault(i, 0) + 1);
        
        int max = -1;
        for(Map.Entry<Integer, Integer> e : num_count.entrySet()) {
            if(e.getKey() == e.getValue())
                if(e.getKey() > max)
                    max = e.getKey();
        }
        return max;  
    }
}
