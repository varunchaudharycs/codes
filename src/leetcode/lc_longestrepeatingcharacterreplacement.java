// https://leetcode.com/problems/longest-repeating-character-replacement/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;
 
public class lc_longestrepeatingcharacterreplacement {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter string & number");
			inp = buf.readLine();
			n = Integer.parseInt(buf.readLine());

			System.out.println(characterReplacement(inp, n));
		}
	}

	// Logic- Consider the most populous char of current window. All other chars require K
	// When K is exhausted, shift start. Otherwise, keep pushing end.

	// NOTE - maxCount may be invalid at some points, but this doesn't matter, because it was valid earlier in the string, 
	// and all that matters is finding the max window that occurred anywhere in the string. 
	// Additionally, it will expand if and only if enough repeating characters appear in the window to make it expand. 
	// So whenever it expands, it's a valid expansion.
    public static int characterReplacement(String s, int k) {

    	int len = s.length();
    	int longest = 0; // answer
    	int start = 0, end = 0; // window pointers
    	int mostFreq = 0; // most frequent char in current window
    	int[] alpha = new int[26]; // alpha counts in current window

    	for(; end < len; ++end) {

    		mostFreq = Math.max(mostFreq, ++alpha[s.charAt(end) - 'A']);

    		if(end - start + 1 - mostFreq > k) { // if replacements reqd > K

    			alpha[s.charAt(start) - 'A']--;
    			start++;
    		}

    		longest = Math.max(longest, end - start + 1);
    	}

    	return longest;
    }

	// Logic- slide window till max 'k' is used & update answer w/ start(next avail char).
	// public static int characterReplacement(String s, int k) {

	// 	int len = s.length();
	// 	int longest = 0;
	// 	int start = 0, end = 0, remK = k;

	// 	int[] alpha = new int[26]; // to store aplabet counts for current window

	// 	for(; end < len; ++end) {

	// 		alpha[s.charAt(end) - 'A']++;

	// 		if(s.charAt(end) != s.charAt(start)) remK--; // use K

	// 		while(remK < 0) { // K exhausted => update char & start & remK

	// 			longest = Math.max(longest, end - start); // since k < 0, end has come 1 idx farther. So window size = (end - start) & no +1

	// 			char current = s.charAt(start);

	// 			while(s.charAt(start) == current) {

	// 				alpha[current - 'A']--;
	// 				start++;
	// 			}

	// 			remK = k - ((end - start + 1) - alpha[s.charAt(start) - 'A']);
	// 		}
	// 	}

	// 	longest = Math.max(longest, end - start + Math.min(start, remK));

 //        return longest;
 //    }
}

// I/O -

// Example 1:

// Input:
// s = "ABAB", k = 2

// Output:
// 4

// Explanation:
// Replace the two 'A's with two 'B's or vice versa.
 

// Example 2:

// Input:
// s = "AABABBA", k = 1

// Output:
// 4

// Explanation:
// Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
