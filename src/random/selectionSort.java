// SELECTION SORT
// TIME - O(n^2), SPACE - O(1)
package random;
import java.io.*;
import java.util.*;

public class selectionSort {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();
        int[] nums = {5,4,3,2,1};
        obj.selectionSort(nums);
    }

    public void selectionSort(int[] arr) {

        int len = arr.length;
        int minIdx = -1, tmp = -1;

        for(int i = 0; i < len; i++) {

            minIdx = i; // current MIN pos
            for(int j = i + 1; j < len; j++) // find MIN from unsorted array
                if(arr[j] < arr[minIdx]) 
                    minIdx = j;

            if(minIdx != i) { // SWAP required
                tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
        }
        for(int n : arr) System.out.print(n + " ");
    }
}
