// BUUBLE SORT
// TIME - O(n^2) // BEST O(n), SPACE - O(1)
package random;
import java.io.*;
import java.util.*;

public class bubbleSort {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        bubbleSort obj = new bubbleSort();
        int[] nums = {5,4,3,2,1};
        obj.bubbleSort(nums);
    }

    public void bubbleSort(int[] arr) {

        int len = arr.length;
        boolean isSorted = true;

        for(int i = 0; i < len - 1; i++) {
            for(int j = 0; j < len - 1 - i; j++)
                if(arr[j+1] < arr[j]) {
                    arr[j+1] = arr[j+1] ^ arr[j] ^ (arr[j] = arr[j+1]); // SWAP
                    isSorted = false;
                }
            if(isSorted) break; // SORTED
        }

        for(int n : arr) System.out.print(n + " ");
    }
}
