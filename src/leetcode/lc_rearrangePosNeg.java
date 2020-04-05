// Rearrange positives on left and negatives on right
// TIME - O(n^2)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_rearrangePosNeg {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();

        int[] arr = {12,11,-13,-5,6,-7,5,-3,-6}; // [-13 -5 -7 -3 -6 12 11 6 5]
        
        obj.rearrange(arr);

        for(Integer i : arr) System.out.println(i);
    }
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
