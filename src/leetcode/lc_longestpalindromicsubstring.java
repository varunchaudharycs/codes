package leetcode;// https://leetcode.com/problems/longest-palindromic-substring/
// TIME - O(n^2)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_longestpalindromicsubstring {

	private String longestSubstring = "";
	private int longestLength = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			System.out.println("Enter string");
			String s = buf.readLine();

			lc_longestpalindromicsubstring obj = new lc_longestpalindromicsubstring();

			System.out.println(obj.longestPalindrome(s));
		}
	}

	private void expand(String s, int len, int start, int end) {

		while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {

			start--;
			end++;
		}

		int currLength = end - start - 1;

		if(currLength > longestLength) {

			longestLength = currLength;
			longestSubstring = s.substring(start + 1, end);
		}
	}

	// Logic- consider each char as middle of EVEN or ODD palin, expand from both ends
	public String longestPalindrome(String s) {

		int len = s.length();

		for(int i = 0; i < len; ++i) {

			expand(s, len, i, i); // ODD length
			expand(s, len, i, i + 1); // EVEN length
		}

        return longestSubstring;
    }

	// public static boolean isPalindrome(String p, int len) {

	// 	boolean flag = true;

	// 	for(int i = 0, j = len - 1; i <= j; ++i, --j) {

	// 		if(p.charAt(i) != p.charAt(j)) return !flag;
	// 	}

	// 	return flag;
	// }

	// // Logic- iterate thru all substrings, check only the ones longer than stored palindrome.
	// public static String longestPalindrome(String s) {

	// 	int len = s.length();
	// 	StringBuilder currSubstring = new StringBuilder();
	// 	int currLength = -1;
	// 	int longestLength = 0;
	// 	String longestSubstring = "";

	// 	for(int i = 0; i < len; ++i) {

	// 		currSubstring.setLength(0);

	// 		for(int j = i; j < len; ++j) {

	// 			currLength = j - i + 1;
	// 			currSubstring.append(s.charAt(j));

	// 			if(currLength <= longestLength) continue; // no need to check shorter substrings than current

	// 			if(isPalindrome(currSubstring.toString(), currLength)) {

	// 				longestLength = currLength;
	// 				longestSubstring = currSubstring.toString();
	// 			}
	// 		}
	// 	}

 //        return longestSubstring;
 //    }
}

// I/O -

// Example 1:

// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// Example 2:

// Input: "cbbd"
// Output: "bb"