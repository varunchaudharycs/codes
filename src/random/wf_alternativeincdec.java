// TIME - O(n^2)

import java.io.*;
import java.util.*;

class wf_alternativeincdec {
    
    public int helper(int[] arr, int idx) {
        
        boolean inc = true;
        int cmp;
        // define starting pattern- inc or dec
        if(idx != -1)
            for(int i = 0; i < arr.length - 1; i++)
                if(i != idx) {
                    inc = arr[i] < arr[i + 1];
                    break;
                }
        // check
        for(int i = 0; i < arr.length - 1; i++) {
            cmp = i + 1;
            if(i == idx)
                continue;
            if(i + 1 == idx) {
                if(cmp == arr.length - 1) return -1;
                else
                    cmp++;
            }
            // increase
            if(inc) {
                if(arr[cmp] <= arr[i])
                    return i;
                else
                    inc = false;
            }
            // decrease
            else { 
                if(arr[cmp] >= arr[i])
                    return i;
                else
                    inc = true;
            }
        }
        return -1; // all good
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int idx = helper(A, -1);
        if(idx == -1)
            return 0;
        else {
            int ways = 0;
            int len = A.length;
            // cut i from A[]
            for(int i = idx - 1; i < len; i++) {
                int[] arr = new int[len - 1];
                idx = helper(A, i);
                if(idx == -1)
                    ways++;
            }
            if(ways == 0)
                return -1;
            else
                return ways;
        }
    }
}
