// QUICK SORT
// TIME - O(n logn) || O(n^2)

import java.io.*;
import java.util.*;
package random;
public class quickSort {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();

        int[] arr = {3,2,1,6,7};
        
        obj.quickSort(arr, 0, arr.length - 1);

        for(Integer i : arr) System.out.println(i);
    }
    // FIND ACTUAL PIVOT POSITION
    public int partition(int[] arr, int left, int right) { 

        int i = left, j = right;
        int pivot = arr[left]; // DEFAULT PIVOT = LEFT MOST
        int pivotIdx = left;

        while(i <= j) { // FIND ACTUAL POS

            if(arr[i] <= pivot) i++;
            if(arr[j] >= pivot) j--;
        }

        arr[j] = arr[j] ^ arr[pivotIdx] ^ (arr[pivotIdx] = arr[j]); // UPDATE IN ORIGINAL ARRAY (j is ACTUAL PIVOT POS)

        return j;
    }
    // SPLIT INTO 2 HALVES - LEFT(values <= PIVOT) + RIGHT(values >= PIVOT)
    public void quickSort(int[] arr, int left, int right) {

        if(left < right) {

            int partitionIdx = partition(arr, left, right);

            quickSort(arr, left, partitionIdx);
            quickSort(arr, partitionIdx + 1, right);
        }
    }
}
