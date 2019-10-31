package leetcode;///

import java.io.*;
import java.util.*;
// https://leetcode.com/problems/unique-number-of-occurrences/

public class lc_uniquenumberofoccurences
{
    // store each number and count of occurrences in a hashmap
    // iterate over hashmap to check if the counts are unique
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(hm.get(arr[i]) == null)
                hm.put(arr[i], 1);
            else
                hm.put(arr[i], hm.get(arr[i]) + 1);;
        }
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        for(Map.Entry mapEle : hm.entrySet()) {
            // int key = (int)mapEle.getKey();
            int val = (int)mapEle.getValue();
            if(hm2.get(val) != null)
                return false;
            else
                hm2.put(val, 1);
        }
        return true;
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(uniqueOccurrences(new int[] {1, 2, 2, 1, 1, 3}));
    }
}
