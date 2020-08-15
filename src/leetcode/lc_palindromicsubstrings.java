// https://leetcode.com/problems/palindromic-substrings/
// TIME - O(n^3)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_palindromicsubstrings {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter string");
			inp = buf.readLine();
			

			System.out.println(countSubstrings(inp));
		}
	}

	public static boolean isPalindrome(String p, int len) {

		boolean flag = true;

		for(int i = 0, j = len - 1; i <= j; ++i, --j) {

			if(p.charAt(i) != p.charAt(j)) return !flag;
		}

		return flag;
	}

	// Logic- iterate thru all substrings, check if palindrome.
	public static int countSubstrings(String s) {

		int len = s.length();
		StringBuilder currSubstring = new StringBuilder();
		int currLength = -1;
		int count = 0;

		for(int i = 0; i < len; ++i) {

			currSubstring.setLength(0);

			for(int j = i; j < len; ++j) {

				currSubstring.append(s.charAt(j));
				currLength = j - i + 1;

				if(isPalindrome(currSubstring.toString(), currLength)) count++;
			}
		}

        return count;
    }
}

// Example 1:

// Input: "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
 

// Example 2:

// Input: "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

