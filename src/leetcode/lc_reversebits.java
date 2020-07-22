// https://leetcode.com/problems/reverse-bits/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_reversebits {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter number");
			n = Integer.parseInt(buf.readLine());
			System.out.println(reverseBits(n));
		}
	}

	// Logic - collect bits from right to left. unsigned int = 32b
	public static int reverseBits(int n) {
        
         int reversedN = 0;

        for(int i = 0; i < 32; ++i) {

        	reversedN = (reversedN << 1) | (n & 1);

        	n = n >> 1;
        }

        return reversedN;
    }
}

// I/O -

// Example 1:

// Input: 00000010100101000001111010011100
// Output: 00111001011110000010100101000000
// Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
// Example 2:

// Input: 11111111111111111111111111111101
// Output: 10111111111111111111111111111111
// Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.

