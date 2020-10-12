package leetcode;// https://leetcode.com/problems/maximum-product-subarray/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_maximumproductsubarray {
	
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

			System.out.println(maximumProduct(arr));
		}
	}

	// Logic - Kadane's algo(modified) - keep local max & min both stored due to neagtive num flipping value at i 
	public static int maximumProduct(int[] nums) {

		int len = nums.length;

		int localMax = 1, localMin = 1;
		int localMaxProd = 1, localMinProd = 1;
		int globalMax = Integer.MIN_VALUE;

		for(int num : nums) {

			localMaxProd = localMax * num;
			localMinProd = localMin * num;

			localMax = Math.max(num, Math.max(localMaxProd, localMinProd));
			localMin = Math.min(num, Math.min(localMaxProd, localMinProd));

			globalMax = Math.max(globalMax, localMax);
		}

        return globalMax;
    }

	// Logic - brute force. check all combos. Compare each possible product with a stored max
	// public static int maximumProduct(int[] nums) {

	// 	int len = nums.length;

	// 	int maxProduct = Integer.MIN_VALUE;
	// 	int product;

	// 	for(int i = 0; i < len; ++i) {

	// 		product = 1;

	// 		for(int j = i; j < len; j++) {

	// 			product *= nums[j];
	// 			maxProduct = (product > maxProduct) ? product : maxProduct;
	// 		}

	// 	}

 //        return maxProduct;
 //    }
}

// I/O -

// Input: [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Input: [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
