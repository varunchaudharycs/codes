// https://codeforces.com/contest/1359/problem/B
// TIME - O(n * m)

package codeforces;
import java.io.*;
import java.util.*;

public class cf_newtheatresquare {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(buf.readLine());

		while((t--) > 0) {

			StringTokenizer st = new StringTokenizer(buf.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			String[] theatre = new String[n];
			for(int i = 0; i < n; ++i) theatre[i] = buf.readLine();
			
			System.out.println(minimumPrice(n, m, x, y, theatre));
		}
	}

	// Minimise cost for each row separately. Count adjacent/consecutive tiles
	static int minimumPrice(int n, int m, int x, int y, String[] theatre) {

		int price = 0;

		for(int i = 0; i < n; ++i) { // every row

			int xTiles = 0, yTiles = 0;
			int consecutiveTiles = 0;

			for(int j = 0; j < m; ++j) { // every col
				if(theatre[i].charAt(j) == '.') { // white
					consecutiveTiles++;
				}
				else {
					if(consecutiveTiles > 0) {
						xTiles += consecutiveTiles % 2;
						yTiles += (int)(consecutiveTiles / 2);
						consecutiveTiles = 0;
					}
				}
			}
			// leftover
			if(consecutiveTiles > 0) {
				xTiles += consecutiveTiles % 2;
				yTiles += consecutiveTiles / 2;
			}

			// calculate price
			if(x * 2 < y) price += (x * (2 * yTiles + xTiles));	// CHECK IF 2X < Y
			else price += (x * xTiles) + (y * yTiles);
		}

		return price;
	}
}

// I/O -

// 4
// 1 1 10 1
// .
// 1 2 10 1
// ..
// 2 1 10 1
// .
// .
// 3 3 3 7
// ..*
// *..
// .*.

// 10
// 1
// 20
// 18
