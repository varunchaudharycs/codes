// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_longestsubstringwithoutrepeatingcharacters {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter string");
			inp = buf.readLine();

			System.out.println(findSubstring(inp));
		}
	}

	// Logic- maintain map of (char) -> (index) & maintain pointers
	public static int findSubstring(String s) {

		int len = s.length();

		int longest = 0;
		int start = 0, i = 0;
		HashMap<Character, Integer> hm = new HashMap<>();
		char ch;

		for(; i < len; ++i) {

			ch = s.charAt(i);

			if(hm.containsKey(ch)) {

				longest = Math.max(longest, i - start);
				start = (hm.get(ch) < start) ? start : hm.get(ch) + 1;
			}

			hm.put(ch, i);
		}

		return Math.max(longest, i - start);
    }

	// // Logic- maintain start and end of substring. check duplicate character in the range to reset
	// public static int findSubstring(String s) {

	// 	int len = s.length();

	// 	int longest = 0;
	// 	int start = 0, i = 0;

	// 	for(; i < len; ++i) {

	// 		if(s.substring(start, i).indexOf(s.charAt(i)) != -1) {

	// 			longest = Math.max(longest, i - start);
	// 			start = start + s.substring(start, i).indexOf(s.charAt(i)) + 1;
	// 		}
	// 	}

 //        return Math.max(longest, i - start);
 //    }
}

// I/O -

// Example 1:

// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 
// Example 2:

// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. 
//              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

