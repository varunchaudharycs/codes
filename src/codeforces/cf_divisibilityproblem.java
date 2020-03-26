// http://m3.codeforces.com/contest/1328/problem/A
// TIME - O(1)

import java.io.*;
import java.util.*;

public class cf_divisibilityproblem {

	public static void main(String[] args)throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(buf.readLine());

		int t = Integer.parseInt(st.nextToken());
		int a = 0, b = 0, rem = -1;

		while(t-- > 0) {

			st = new StringTokenizer(buf.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			rem = a % b;

			if(rem == 0) {
				System.out.println("0");
				continue;
			}

			System.out.println(b - rem);
		}

	}
}
