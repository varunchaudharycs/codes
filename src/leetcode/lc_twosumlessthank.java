package leetcode;

import java.io.*;
import java.util.*;

// https://leetcode.com/problems/two-sum-less-than-k/

// TIME - O(n log n)
// SPACE - O(1)

class lc_twosumlessthank{
    
    public int twoSumLessThanK(int[] A, int K) {
        
        int len = A.length;
        int max = -1;
        int sum;
        Arrays.sort(A);
        int left = 0, right = len - 1;
        
        if(len == 1 || A[0] + A[1] >= K)
            return max;
        
        while(left < right) {
            
            sum = A[left] + A[right];
            
            if(sum < K){
                if(sum > max)
                    max = sum;
                left++;
            }
            else
                right--;
            
        }
        
        return max;
    }

// TIME - O(n^2)
// SPACE - O(1)
//     public int twoSumLessThanK(int[] A, int K) {
        
//         int len = A.length;
//         int max = -1;
//         int sum;
        
//         for(int i = 0; i < len - 1; ++i)
//             for(int j = i + 1; j < len; ++j) {
                
//                 sum = A[i] + A[j];
                
//                 if(sum > max && sum < K)
//                     max = sum;
//             }
        
//         return max;
//     }
}
