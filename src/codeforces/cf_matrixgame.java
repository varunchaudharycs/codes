// https://codeforces.com/contest/1365/problem/A
// TIME - O(n * m)

package codeforces;
import java.io.*;
import java.util.*;

public class cf_matrixgame {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));


		int testCases = Integer.parseInt(buf.readLine());

		while((testCases--) > 0) {

			String s;
			StringTokenizer st;
			int n;

			s = buf.readLine();
			st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] matrix = new int[n][m];

			for(int i = 0; i < n; ++i) {

				st = new StringTokenizer(buf.readLine());

				for(int j = 0; j < m; ++j) {

					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println(getWinner(matrix, n, m));

		}


	}

	// find unclaimed rows & cols, keep removing from both one by one until possible
	public static String getWinner(int[][] matrix, int n, int m) {

		HashSet<Integer> unclaimedRows = new HashSet<>();
		HashSet<Integer> unclaimedCols = new HashSet<>();

		for(int i = 0; i < n; ++i) unclaimedRows.add(i);
		for(int i = 0; i < m; ++i) unclaimedCols.add(i);

		HashSet<Integer> claimedRows = new HashSet<>();
		HashSet<Integer> claimedCols = new HashSet<>();

		boolean ashishTurn = true;

		for(int i = 0; i < n; ++i)
			for(int j = 0; j < m; ++j) {

				if(matrix[i][j] == 1) {

					unclaimedCols.remove(j);
					unclaimedRows.remove(i);
				}
			}

		int unclaimedRowsCount = unclaimedRows.size();
		int unclaimedColsCount = unclaimedCols.size();

		while(unclaimedRowsCount > 0 && unclaimedColsCount > 0) {


			unclaimedRowsCount--;
			unclaimedColsCount--;

			ashishTurn = !ashishTurn;
		}

		if(ashishTurn) return "Vivek";
		else return "Ashish";
	}
}

// I/O

// 4
// 2 2
// 0 0
// 0 0
// 2 2
// 0 0
// 0 1
// 2 3
// 1 0 1
// 1 1 0
// 3 3
// 1 0 0
// 0 0 0
// 1 0 0

// Vivek
// Ashish
// Vivek
// Ashish
