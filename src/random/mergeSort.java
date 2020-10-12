// MERGE SORT
// TIME - O(n logn)
package random;
import java.io.*;
import java.util.*;

public class mergeSort {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        mergeSort obj = new mergeSort();

        int[] arr = {7,6,4,3,1};
        
        obj.mergeSort(arr, 0, arr.length - 1);

        for(Integer i : arr) System.out.println(i);
    }
    // MERGE TWO SORTED ARRAYS INTO ONE SORTED ARRAY
    public void merge(int[] arr, int left, int mid, int right) { // Can prevent auxillary array by shifting numbers instead BUT then O(n^2) !!

        int[] merged = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while(i <= mid && j <= right) {
            merged[k++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++]; // COMBINE
        }
        for(; i <= mid;) merged[k++] = arr[i++]; // LEFTOVER
        for(; j <= right;) merged[k++] = arr[j++]; // RIGHTOVER

        for(i = left, j = 0; i <= right;) arr[i++] = merged[j++]; // UPDATE ORIGINAL
    }
    // SPLIT ARRAY INTO 2 EQUAL HALVES & COMBINE RESULTS
    public void mergeSort(int[] arr, int left, int right) {

        if(left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }


}
