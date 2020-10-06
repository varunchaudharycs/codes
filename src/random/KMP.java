// Aim- IMPLEMENT KMP ALGORITHM FOR STRING PATTERN MATCHING

import java.io.*;
import java.util.*;

class KMP {

	public static void main(String[] args)throws IOException {

		// String pattern = "abc";
		// String text = "abcdabc"; // 2

		String text = "AAAAABAAABA";
		String pattern = "AAAA";

		int[] lps = findLPS(pattern);

		//for(int i : lps) { System.out.println(i); }

		findPattern(text, pattern, lps);
	}

	public static int[] findLPS(String pattern) {

		int n = pattern.length();
		int[] lps = new int[n];
		
		if(n == 0) { return lps; }

		lps[0] = 0;
		int len = 0;

		char[] ch = pattern.toCharArray();

		for(int i = 1; i < n;) {

			if(ch[i] == ch[len]) {

				len++;
				lps[i] = len;
				i++;
			}
			else {

				if(len == 0) { i++; }
				else {

					len = lps[len-1];
				}
			}
		}

		return lps;
	}

	public static void findPattern(String text, String pattern, int[] lps) {

		int m = text.length();
		char[] T = text.toCharArray();

		int n = pattern.length();
		char[] P = pattern.toCharArray();
		int len = 0;

		for(int i = 0; i < m;) {

			if(T[i] == P[len]) {
				i++;
				len++;

				if(len == n) {

					System.out.println("Found at index - " + (i - n));
					len = lps[len-1];
				}
			}
			else {
				if(len == 0) { i++; }
				else { len = lps[len-1]; }
			}
		}
	}
}