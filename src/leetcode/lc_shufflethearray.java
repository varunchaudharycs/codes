// https://leetcode.com/problems/shuffle-the-array/
// TIME - O(n)

package leetcode;
import java.io.*;
import java.util.*;

public class lc_shufflethearray {
	
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

			int[] ans = shuffle(arr, n / 2);
			System.out.println();
			for(int i : ans) System.out.println(i);
		}
	}

	// Logic
	public static int[] shuffle(int[] nums, int n) {
        
        int[] arr = new int[2 * n];
        
        for(int i = 0, j = n, k = 0; i < n; ++i, ++j) {
            
            arr[k++] = nums[i];
            arr[k++] = nums[j];
        }
        
        return arr;        
    }
}

// I/O -

// Example 1:

// Input: nums = [2,5,1,3,4,7], n = 3
// Output: [2,3,5,4,1,7] 
// Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
// Example 2:

// Input: nums = [1,2,3,4,4,3,2,1], n = 4
// Output: [1,4,2,3,3,2,4,1]
// Example 3:

// Input: nums = [1,1,2,2], n = 2
// Output: [1,2,1,2]