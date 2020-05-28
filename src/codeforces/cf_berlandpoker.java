// https://codeforces.com/contest/1359/problem/A
// TIME - O(1)

package codeforces;
import java.io.*;
import java.util.*;

public class cf_berlandpoker {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(buf.readLine());

		while((t--) > 0) {

			StringTokenizer st = new StringTokenizer(buf.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			System.out.println(maximumPoints(n, m, k));
		}
	}

	// IDEAL - Winner has all jokers. Remaining jokers are evenly distributed among opponents
	static int maximumPoints(int n, int m, int k) {

		int cardsPerPlayer = n / k;

		if(m <= cardsPerPlayer) return m;
		else {
			int remJokers = m - cardsPerPlayer;
			int remPlayers = k - 1;

			int secondHighestScore = remJokers / remPlayers;

			if(remJokers % remPlayers > 0)
				secondHighestScore++;

			return cardsPerPlayer - secondHighestScore; 
		}
	}
}

// I/O -

// 4
// 8 3 2
// 4 2 4
// 9 6 3
// 42 0 7

// 3
// 0
// 1
// 0
