// INSERTION SORT
// TIME - O(n2)
package random;
import java.io.*;
import java.util.*;

public class insertionSort {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();

        int[] arr = {12,11,-13,-5,6,-7,5,-3,-6}; // [-13 -5 -7 -3 -6 12 11 6 5]
        
        obj.insertionSort(arr);

        for(Integer i : arr) System.out.println(i);
    }
    // INSERT ELEMENT AT RIGHT POS
    public void insertionSort(int[] arr) {

        for(int i = 1; i < arr.length; i++) {
 
            if(arr[i] < arr[i-1]) { // ORDER
                int key = arr[i];
                int j = 0;
                for(j = 0; j < i && arr[j] < arr[i]; j++) ; // FIND ACTUAL POS OF ARR[i] => j

                for(int k = i; k > j; k--) arr[k] = arr[k-1]; // SHIFT REMAINING ELEMENTS BY 1
                arr[j] = key; // PUT ELE IN ACTUAL POS
            }
        }
    }
}
