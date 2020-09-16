// Aim- IMPLEMENT KMP ALGORITHM FOR STRING PATTERN MATCHING

import java.io.*;
import java.util.*;

class KMP {

	public static void main(String[] args)throws IOException {


		String pattern = "AABA";
		String text = "AABAACAADAABAABA";

		int[] lps = findLPS(pattern);

		List<Integer> matchingIndices = findPattern(text, pattern, lps);

		System.out.println(matchingIndices);
		System.out.println(matchingIndices.size());
	}

	public static int[] findLPS(String pattern) {

		int len = pattern.length();
		int[] lps = new int[len];
		char[] chars = pattern.toCharArray();

		for(int j = 0, i = 1; i < len;) {

			if(chars[j] == chars[i]) {

				lps[i] = j + 1;
				++j;
				++i;
			}
			else {

				if(j != 0) { j = lps[j-1]; }
				else { ++i; }
			}
		}

		return lps;
	}

	public static List<Integer> findPattern(String text, String pattern, int[] lps) {

		int totalChars = text.length();
		int len = lps.length;

		char[] textChars = text.toCharArray();
		char[] patternChars = pattern.toCharArray();

		List<Integer> matchingIndices = new LinkedList<>();

		for(int i = 0, j = -1; i < totalChars; ++i) {

			if(textChars[i] == patternChars[j+1]) { // MATCH

				if(j + 1 == len - 1) { // PATTERN FOUND

					matchingIndices.add(i - len + 1); 
					j = lps[j + 1];
				}
				else { j++; }
			}
			else { j = Math.min(j, lps[j]); } // NO MATCH
		}

		return matchingIndices;
	}
}