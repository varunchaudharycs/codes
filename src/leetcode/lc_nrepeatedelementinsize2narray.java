package leetcode;///

import java.io.*;
import java.util.*;
// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

public class lc_nrepeatedelementinsize2narray
{
    // store elements in hashmap
    // if current element already present in hashmap, it is the N-time occurring element
    public static int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            if(hm.get(A[i]) != null)
                return A[i];
            else
                hm.put(A[i], 1);
        }
        return -1;  // problem constraints incorrect
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(repeatedNTimes(new int[]{1, 2, 3, 3}));
    }
}
