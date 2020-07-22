// https://leetcode.com/problems/valid-anagram/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_validanagram {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter strings");
			inp = buf.readLine();
			
			String inp2 = buf.readLine();

			System.out.println(isAnagram(inp, inp2));
		}
	}

	// Logic- create A-Z count array. Compare
	public static boolean isAnagram(String s, String t) {

		int lenS = s.length();
		int lenT = t.length();

		if(lenS != lenT) return false;

		int[] alphabetCount = new int[26];

		s = s.toLowerCase();
		t = t.toLowerCase();

		for(int i = 0; i < lenS; ++i) {

			alphabetCount[s.charAt(i) - 'a']++;
			alphabetCount[t.charAt(i) - 'a']--;
		}

		for(int i : alphabetCount) if(i != 0) return false;

		return true;
    }

	// Logic- sort strings. match each char
	// public static boolean isAnagram(String s, String t) {

	// 	int lenS = s.length();
	// 	int lenT = t.length();

	// 	if(lenS != lenT) return false;

	// 	char[] charS = s.toCharArray();
	// 	char[] charT = t.toCharArray();

	// 	Arrays.sort(charS);
	// 	Arrays.sort(charT);

	// 	for(int i = 0; i < lenS; ++i) {

	// 		if(charS[i] != charT[i]) return false;
	// 	}

	// 	return true;
 //    }
}

// I/O -

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false
