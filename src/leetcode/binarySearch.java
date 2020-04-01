// BINARY SEARCH
// TIME - O(logn)

import java.io.*;
import java.util.*;

public class binarySearch {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();
        int[] arr = {1,5,6,3,2,7,9};
        System.out.println("Index: " + obj.binarySearch(arr, 7));
    }

    public int binarySearch(int[] arr, int num) {

        Arrays.sort(arr); // sort - pre-requisite
        int l = 0, r = arr.length, mid = (l + r) / 2;

        while(num != arr[mid] && l < r) {

            if(num < arr[mid]) // left sub-array
                r = mid - 1;
            else
                l = mid + 1; // right sub-array

            mid = (l + r) / 2;
        }

        return (num == arr[mid])? mid : -1; // not found default -1
    }
}
