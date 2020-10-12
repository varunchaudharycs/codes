// http://codeforces.com/contest/1363/problem/A
// TIME - O(n)

package codeforces;
import java.io.*;
import java.util.*;

public class cf_oddselection {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(buf.readLine());

		while((testCases--) > 0) {

			StringTokenizer st = new StringTokenizer(buf.readLine());

			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(buf.readLine());
			for(int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

			System.out.println(isPossible(n, x, arr));
		}
	}

	// For final sum to be Odd - Select Odd #ODDs
	static String isPossible(int n, int x, int[] arr) {

		int even = 0;
		int odd = 0;

		for(int ele : arr) {

			if((ele & 1) == 1) odd++;
			else even++;
		}

		if(odd == 0) return "No"; // NOT POSSIBLE
		else if(n - x == 0 && (odd & 1) == 0) return "No"; // selecting N nums with even #ODDs
		else if((x & 1) == 0 && odd == n) return "No"; // can only select even #ODDs
		else if(even >= x - 1) return "Yes"; // select all EVENs with just one ODD
		else return "Yes";
	}
}

// I/O -

// 5
// 1 1
// 999
// 1 1
// 1000
// 2 1
// 51 50
// 2 2
// 51 50
// 3 3
// 101 102 103

// Yes
// No
// Yes
// Yes
// No
// 