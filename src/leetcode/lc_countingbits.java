// https://leetcode.com/problems/counting-bits/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_countingbits {
	
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

			countBits(n);
		}
	}

	// Logic - find pattern
	public static int[] countBits(int num) {

		int[] numOfOnes = new int[num + 1];

		for(int i = 0; i <= num; ++i) {

			numOfOnes[i] = numOfOnes[i >> 1] + (i & 1);
		}

		return numOfOnes;
    }
}

// I/O -
// Example 1:

// Input: 2
// Output: [0,1,1]
// Example 2:

// Input: 5
// Output: [0,1,1,2,1,2]
