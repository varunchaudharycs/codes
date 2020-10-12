package leetcode;// https://leetcode.com/problems/sum-of-two-integers/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_sumoftwoints {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter numbers");
			inp = buf.readLine();
			st = new StringTokenizer(inp);

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			System.out.println(getSum(a, b));
		}
	}

	// Logic- carry = AND, sum = XOR. 
	public static int getSum(int a, int b) {

		int carry;
		
		while(b != 0) {

			carry = (a & b) << 1;
			a = a ^ b; // If both bits are 1, this will give us 0
			b = carry; // If both bits are 1, we set the bit to the left (<<1) to 1 -- this is the carry step
			// but the carry should be added to the left bit of the one which genereated it => << 1
		}

		return a;
    }
}

// I/O -

// Example 1:

// Input: a = 1, b = 2
// Output: 3
// Example 2:

// Input: a = -2, b = 3
// Output: 1

