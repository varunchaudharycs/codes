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
            // skip index cut from array
            if(i == idx)
                continue;
            // skip comparison with immediate neighbour if cut
            if(i + 1 == idx)
                if(cmp == arr.length - 1) 
                    break;
                else 
                    cmp++;
            // increase
            if(inc) {
                if(arr[cmp] <= arr[i])
                    return i; // failed pattern
                else
                    inc = false;
            }
            // decrease
            else { 
                if(arr[cmp] >= arr[i])
                    return i; // failed pattern
                else
                    inc = true;
            }
        }
        return -1; // all good
    }
    public int solution(int[] A) {
        int idx = helper(A, -1); // index failing pattern(inc or dec)
        if(idx == -1)
            return 0;
        else {
            int ways = 0;
            // cut i from A[]
            for(int i = idx - 1; i < A.length; i++) {
                if(helper(A, i) == -1) // one way found
                    ways++;
            }
            if(ways == 0)
                return -1; // no solution
            else
                return ways;
        }
    }
}
