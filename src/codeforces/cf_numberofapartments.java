// problem link
// TIME - O()

//package leetcode;
import java.io.*;
import java.util.*;

public class Solution {

	private static Set<Integer> sizes = new HashSet<>() {{
		add(3);
		add(5);
		add(7);
	}};
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(buf.readLine());

		while((t--) > 0) {

			int windows = Integer.parseInt(buf.readLine());

			printCombination(windows);
		}
	}

	// Logic
	public static void printCombination(int windows) {

		Integer[] dp = new Integer[windows+1];
		Arrays.fill(dp, 0);
		dp[0] = 0;

		for(int i = 1; i <= windows; ++i) {

			for(int size : sizes) {

				if(i % size == 0 || (i - size >= 0 && dp[i - size] != 0)) {

					dp[i] = size;

					break;
				}
			}
		}

		if(dp[windows] != 0) {
			
			Integer[] count = new Integer[3];
			Arrays.fill(count, 0);

			for(int i = windows; i != 0;) {

				if(dp[i] == 7) { count[2] += 1; }
				if(dp[i] == 5) { count[1] += 1; }
				if(dp[i] == 3) { count[0] += 1; }

				i -= dp[i];
			}

			StringBuilder res = new StringBuilder();

			for(int c : count) { res.append(c).append(" "); }

			System.out.println(res.toString().trim());
		}
		else { System.out.println(-1); }
	}
}

// I/O -

