// https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/
// TIME - O(n!)

// TODO- remove duplicates[add to a set]
// TODO- sort results[sort list]

import java.io.*;
import java.util.*;

class permutations {

	public static void main (String[] args)throws IOException {
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			System.out.println("Enter string:");
			String s = buf.readLine();
			int len = s.length();
			
			List<Character> avail = new ArrayList<>();
			for(char ch : s.toCharArray()) avail.add(ch);
			
			for(int i = 0; i < len; ++i) {
			    
			    findPermutations(new ArrayList<Character>(avail), new ArrayList<Character>(), len, i);
			}
		}
	}
	
	// Logic-
	// Avail --- Perm --- Total
	// {a,b,c} --- {} --- {}
	// {b,c} --- {a} --- {}
	// {c} --- {a,b} --- {}
	// {} --- {a,b,c} --- {}
	// {} --- {} -- {{a,b,c}}
	// backtrack
	// {b,c} --- {a} --- {{a,b,c}}
	// {b} --- {a,c} --- {{a,b,c}}
	// {} --- {a,c,b} --- {{a,b,c}}
	// {} --- {} --- {{a,b,c}, {a,c,b}}
	public static void findPermutations(List<Character> avail, List<Character> perm, int len, int idx) {
	    
	    perm.add(avail.get(idx));
	    
	    if(perm.size() == len) {
	       System.out.println(perm);
	        return;
	    }
	    avail.remove(idx);
	    
	    for(int j = 0; j < avail.size(); ++j) {
	        
	        findPermutations(new ArrayList<Character>(avail), 
	        new ArrayList<Character>(perm), 
	        len, 
	        j);
	    }
	    
	    return;
	}
}

// I/P=
// abc

// O/P=
// [a, b, c]
// [a, c, b]
// [b, a, c]
// [b, c, a]
// [c, a, b]
// [c, b, a]
