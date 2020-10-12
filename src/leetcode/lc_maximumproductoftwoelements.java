package leetcode;// https://leetcode.com/contest/weekly-contest-191/problems/maximum-product-of-two-elements-in-an-array/
// TIME - O(n logn)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_maximumproductoftwoelements {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		boolean keepTesting = true;

		while(true) {

			System.out.println("Enter array");
			String inp = buf.readLine();
			StringTokenizer st = new StringTokenizer(inp);

			int n = st.countTokens();
			int[] arr = new int[n];
			for(int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

			System.out.println(maxProduct(arr));
		}
	}

	// Sort array. Multiply the two larges numbers
	public static int maxProduct(int[] nums) {

		int len = nums.length;
		Arrays.sort(nums);
         
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }
}

// I/O -

// Example 1:

// Input: nums = [3,4,5,2]
// Output: 12 
// Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 
// Example 2:

// Input: nums = [1,5,4,5]
// Output: 16
// Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
// Example 3:

// Input: nums = [3,7]
// Output: 12
//  