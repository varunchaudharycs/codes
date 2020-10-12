package codeforces;// https://codeforces.com/contest/1430/problem/B
// TIME - O(n logn)

import java.io.*;
import java.util.*;


public class cf_barrels {

	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(buf.readLine());

		while((t--) > 0) {

			StringTokenizer st = new StringTokenizer(buf.readLine());

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			Integer[] w = new Integer[n];

			st = new StringTokenizer(buf.readLine());

			for(int i = 0; i < n; ++i) { w[i] = Integer.parseInt(st.nextToken()); }

			maxDiff(n, k, w);
		}
	}

	// LOGIC- Sort DESC. Start emptying from second largest barrel into the largest barrel for maximum difference
	public static void maxDiff(int n, int k, Integer[] w) {

		Arrays.sort(w, Collections.reverseOrder());

		if(w[0] == 0) { System.out.println(0); }
		else {

			long diff = w[0];

			for(int i = 1; i < k + 1; ++i) {

				if(w[i] == 0) { break; }
				diff += w[i];
			}

			System.out.println(diff);
		}
	}
}

