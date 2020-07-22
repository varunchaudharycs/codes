// https://leetcode.com/problems/missing-number/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_missingnumber {
	
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
			for(int i = 0; st.hasNext(); ++i) arr[i] = Integer.parseInt(st.nextToken());

			findMissingNumber(n);
		}
	}

	// Logic - Sort num. Index and value must be same at all places. Use XOR to find
	public static int[] findMissingNumber(int nums) {

		int len = nums.length;
		Arrays.sort(nums);
		int idx = 0;

		for(; idx < len; ++idx) {

			if((idx ^ nums[idx]) != 0) break; // XOR with self = 0
		}

		return idx;
    }
}

// I/O -
// Example 1:

// Input: [3,0,1]
// Output: 2
// Example 2:

// Input: [9,6,4,2,3,5,7,0,1]
// Output: 8
