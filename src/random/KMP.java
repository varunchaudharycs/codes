// Aim- IMPLEMENT KMP ALGORITHM FOR STRING PATTERN MATCHING

import java.io.*;
import java.util.*;

class KMP {

	public static void main(String[] args)throws IOException {


		String pattern = "aa";
		String text = "aaadsaaa"; // 4

		// String pattern = "abc";
		// String text = "abcdabc"; // 2

		int[] lps = findLPS(pattern);

		//for(int i : lps) System.out.println(i);

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

		int i = 0, j = 0; 

        while (i < totalChars) {

            if (patternChars[j] == textChars[i]) {

                j++; 
                i++; 
            } 

            if (j == len) { 

                matchingIndices.add(i - j); 
                j = lps[j - 1];
            }
            // mismatch after j matches 
            else if (i < totalChars && patternChars[j] != textChars[i]) { 

                // Do not match lps[0..lps[j-1]] characters, 
                // they will match anyway 
                if (j != 0) 
                    j = lps[j - 1]; 
                else
                    i = i + 1; 
            } 
        } 

		return matchingIndices;
	}
}