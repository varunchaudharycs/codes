// https://codeforces.com/contest/1358/problem/A
// TIME - O(1)

package codeforces;
import java.io.*;
import java.util.*;

public class cf_parklighting {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(buf.readLine());
		while((t--) > 0) {

			StringTokenizer st = new StringTokenizer(buf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			System.out.println(minimumLights(n, m));
		}
	}
	
	// IF ANY ONE DIM IS EVEN = EvenDim/2(border light) * Other dim
	// IF BOTH ODD = Make one dim EVEN. Solve like above. Then solve separately for the left out row/col
	static int minimumLights(int n, int m) {

		if((n & 1) == 1 && (m & 1) == 1) {
			return ((n - 1)/2 * m) + ((int)Math.ceil(m/2) + 1);
		}

		else {
			if((n & 1) == 1) {
				return m/2 * n;
			}
			else {
				return n/2 * m;
			}
		}
	}
}
