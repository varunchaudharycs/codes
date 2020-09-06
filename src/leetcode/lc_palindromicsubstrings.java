// https://leetcode.com/problems/palindromic-substrings/
// TIME - O(n^3)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_palindromicsubstrings {
	
	private int count = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			System.out.println("Enter string");
			String s = buf.readLine();

			lc_palindromicsubstrings obj = new lc_palindromicsubstrings();

			System.out.println(obj.countSubstrings(s));
		}
	}

	private void expand(String s, int len, int start, int end) {

		while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {

			count++;
			start--;
			end++;
		}
	}

	// Logic- consider each char as middle of EVEN or ODD palin, expand from both ends
	public int countSubstrings(String s) {

		int len = s.length();

		for(int i = 0; i < len; ++i) {

			expand(s, len, i, i); // ODD length
			expand(s, len, i, i + 1); // EVEN length
		}

        return count;
    }



	// public static boolean isPalindrome(String p, int len) {

	// 	boolean flag = true;

	// 	for(int i = 0, j = len - 1; i <= j; ++i, --j) {

	// 		if(p.charAt(i) != p.charAt(j)) return !flag;
	// 	}

	// 	return flag;
	// }

	// // Logic- iterate thru all substrings, check if palindrome.
	// public static int countSubstrings(String s) {

	// 	int len = s.length();
	// 	StringBuilder currSubstring = new StringBuilder();
	// 	int currLength = -1;
	// 	int count = 0;

	// 	for(int i = 0; i < len; ++i) {

	// 		currSubstring.setLength(0);

	// 		for(int j = i; j < len; ++j) {

	// 			currSubstring.append(s.charAt(j));
	// 			currLength = j - i + 1;

	// 			if(isPalindrome(currSubstring.toString(), currLength)) count++;
	// 		}
	// 	}

 //        return count;
 //    }
}

// Example 1:

// Input: "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
 

// Example 2:

// Input: "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

