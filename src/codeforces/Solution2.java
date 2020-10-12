package codeforces;// link
// TIME - O()

//package codeforces;
import java.io.*;
import java.util.*;

public class Solution2 {
	
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

			int[] arr = new int[n];
			st = new StringTokenizer(buf.readLine());

			for(int i = 0; i < n; ++i) {

				arr[i] = Integer.parseInt(st.nextToken());
			}

			System.out.println(getAnswer(arr, n));

		}


	}

	// logic
	public static int getAnswer(int[] arr, int n) {

		return -1;
	}
}

// I/O
