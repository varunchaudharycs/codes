// QUICK SORT
// TIME - O(n logn) || O(n^2)
package random;
import java.io.*;
import java.util.*;

public class quickSort {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();

        int[] arr = {10, 16, 8, 12, 15, 6, 3, 9, 5};

        obj.quickSort(arr, 0, arr.length - 1);

        for(Integer i : arr) System.out.println(i);
    }
    // FIND ACTUAL PIVOT POSITION
    public int partition(int[] arr, int left, int right) { 

        int i = left, j = right;
        int pivot = arr[left]; // DEFAULT PIVOT = LEFT MOST
        int pivotIdx = left;

        while(i < j) { 

            while(arr[i] <= pivot && i < right) i++; // FIND LEFT ELE > PIVOT
            while(arr[j] >= pivot && j > left) j--; // FIND RIGHT ELE < PIVOT

            if(i < j) arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]); // SWAP TO KEEP LEFT LOWER & RIGHT HIGHER
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
