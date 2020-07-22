// https://leetcode.com/problems/number-of-1-bits/
// TIME - O(k), k - #1 bits

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_numberof1bits {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter number");
			n = Integer.parseInt(buf.readLine());
			System.out.println(hammingWeight(n));
		}
	}

	// Logic - keep track of rightmost 1s
	public static int hammingWeight(int n) {
        
        int ones = 0;    

        
        while(n != 0) {
            
            n = n & (n - 1);
            ones++;
        }
        
        return ones;
    }

	// Logic - Use AND to find rightmost digit, shift after use. O(N)
	// public int hammingWeight(int n) {
        
 //        int ones = 0;    
        
 //        while(n != 0) {
            
 //            ones += (n & 1);            
 //            n = n >>> 1;
 //        }
        
 //        return ones;
 //    }
}

// I/O -

// Example 1:

// Input: 00000000000000000000000000001011
// Output: 3
// Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
// Example 2:

// Input: 00000000000000000000000010000000
// Output: 1
// Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
// Example 3:

// Input: 11111111111111111111111111111101
// Output: 31
// Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 

// Note:

// Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
// In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
