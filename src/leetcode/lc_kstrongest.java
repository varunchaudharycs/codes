// https://leetcode.com/problems/the-k-strongest-values-in-an-array/
// TIME - O(nlogn + n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_kstrongest {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter array");
			inp = buf.readLine();
			st = new StringTokenizer(inp);

			n = st.countTokens();
			arr = new int[n];
			for(int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

			System.out.println("Enter k");
			int k = Integer.parseInt(buf.readLine());

			int[] ans = getStrongest(arr, k);
			System.out.println();
			for(int i : ans) System.out.println(i);
		}
	}

	// Sort. Find median. Jump and compare two pointers- from left and right.
	public static int[] getStrongest(int[] arr, int k) {
        
        Arrays.sort(arr);
        
        int len = arr.length;
        
        int medianPos = (len - 1) / 2;
        
        int median = arr[medianPos];
        
        int low = 0;
        int high = len - 1;
        int[] ans = new int[k];
        int c = 0;
        
        //System.out.println("median - " + median);
        
        while(c != k) {
            
            int lowDiff = Math.abs(arr[low] - median);
            int highDiff = Math.abs(arr[high] - median);
            
            // System.out.println("lowD - " + lowDiff);
            // System.out.println("highD - " + highDiff);
            
            if(lowDiff > highDiff) {
                
                ans[c++] = arr[low];
                low++;
            }
            else {
                
                ans[c++] = arr[high];
                high--;
            }
            
        }
        
        return ans;
        
    }
}

// I/O -

// Example 1:

// Input: arr = [1,2,3,4,5], k = 2
// Output: [5,1]
// Explanation: Median is 3, the elements of the array sorted by the strongest are [5,1,4,2,3]. The strongest 2 elements are [5, 1]. [1, 5] is also accepted answer.
// Please note that although |5 - 3| == |1 - 3| but 5 is stronger than 1 because 5 > 1.
// Example 2:

// Input: arr = [1,1,3,5,5], k = 2
// Output: [5,5]
// Explanation: Median is 3, the elements of the array sorted by the strongest are [5,5,1,1,3]. The strongest 2 elements are [5, 5].
// Example 3:

// Input: arr = [6,7,11,7,6,8], k = 5
// Output: [11,8,6,6,7]
// Explanation: Median is 7, the elements of the array sorted by the strongest are [11,8,6,6,7,7].
// Any permutation of [11,8,6,6,7] is accepted.
// Example 4:

// Input: arr = [6,-3,7,2,11], k = 3
// Output: [-3,11,2]
// Example 5:

// Input: arr = [-7,22,17,3], k = 2
// Output: [22,17]