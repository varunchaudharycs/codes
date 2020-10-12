// Rearrange positives on left and negatives on right
// TIME - O(n logn)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_rearrangePosNeg {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        lc_rearrangePosNeg obj = new lc_rearrangePosNeg();

        int[] arr = {12,11,-13,-5,6,-7,5,-3,-6}; // [-13 -5 -7 -3 -6 12 11 6 5]
        
        obj.rearrange(arr);

        for(Integer i : arr) System.out.println(i);
    }
    
    // COPIES -ve from LEFT & RIGHT -> Then +ve from LEFT & RIGHT
    public void modifiedMerge(int[] arr, int left, int mid, int right) {

        int[] merged = new int[right - left + 1];

        int i, j, k = 0;

        for(i = left; i <= mid; i++) { // COPY -ve FROM LEFT
            if(arr[i] < 0) merged[k++] = arr[i];
        }
        for(j = mid + 1; j <= right; j++) { // COPY -ve FROM RIGHT
            if(arr[j] < 0) merged[k++] = arr[j];
        }
        for(i = left; i <= mid; i++) { // COPY +ve FROM LEFT
            if(arr[i] > 0) merged[k++] = arr[i];
        }
        for(j = mid + 1; j <= right; j++) { // COPY +ve FROM RIGHT
            if(arr[j] > 0) merged[k++] = arr[j];
        }

        for(i = left, k = 0; i <= right; i++, k++) arr[i] = merged[k]; // update ORIGINAL ARRAY
    }

    // MODIFIED merge() 
    public void modifiedMergeSort(int[] arr, int left, int right) {

        if(left < right) {

            int mid = (left + right) / 2;

            modifiedMergeSort(arr, left, mid);
            modifiedMergeSort(arr, mid + 1, right);
            modifiedMerge(arr, left, mid, right);
        }
    }
    
    
    // TIME - O(n^2)
    // REARRANGE ALL (-)ve ON LEFT & (+)ve ON RIGHT
     public void rearrange(int[] arr) {

         int posIdx = 0;
         for(int i = 0; i < arr.length; i++) {

             if(arr[i] < 0) { // FIND -ve
                 int tmp = arr[i];
                 for(int j = i; j > posIdx; j--) arr[j] = arr[j-1]; // SHIFT +ves to RIGHT by 1
                 arr[posIdx] = tmp; // PUT -ve in RIGHT POS
                 posIdx++;
             }
         }

     }
}
