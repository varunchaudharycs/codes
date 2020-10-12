package leetcode;// https://leetcode.com/problems/minimum-window-substring/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_minimumwindowsubstring {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter string");
			inp = buf.readLine();
			System.out.println("Enter substring");
			String inp2 = buf.readLine();

			System.out.println(minWindow(inp, inp2));
		}
	}

	// Logic- Expand window till all found. Shift window to find alternatives.
	public static String minWindow(String s, String t) {

		int len = s.length();

		int minimumWindow = Integer.MAX_VALUE, minimumStart = -1, minimumEnd = -1;

		List<Character> unvisited = new ArrayList<>();
		for(char ch : t.toCharArray()) unvisited.add(ch);
		LinkedList<Character> visited = new LinkedList<>();
		LinkedList<Integer> idx = new LinkedList<>(); // store indices of visited chars

		int start = 0, end = 0;

		for(; end < len; ++end) {

			Character ch = Character.valueOf(s.charAt(end));

			if(unvisited.contains(ch)) {

				unvisited.remove(ch); // mark visited, note index
				visited.add(ch);
				idx.add(Integer.valueOf(end));

				if(unvisited.isEmpty()) { // all found

					if(end - start + 1 < minimumWindow) { // check if minimum window

						minimumWindow = end - start + 1;
						minimumStart = start;
						minimumEnd = end;
					}

					unvisited.add(visited.pollFirst()); // move start to next char
					idx.pollFirst();
					start = (idx.peekFirst() != null) ? idx.peekFirst() : start;
				}
			}
			else if(visited.contains(ch)) { // if a visited character is found, update index to higher index(compress window)

				idx.remove(visited.indexOf(ch));
				idx.addLast(Integer.valueOf(end));

				visited.remove(ch);
				visited.addLast(ch);

				start = idx.peekFirst();
			}


			if(visited.isEmpty()) start++; // if none found, move window start
		}

		
         
        return (minimumStart == -1) ? "" : s.substring(minimumStart, minimumEnd + 1);
    }
}

// I/O -
// Example:

// Input: S = "ADOBECODEBANC", T = "ABC"
// Output: "BANC"
