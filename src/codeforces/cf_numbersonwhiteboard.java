package codeforces;// https://codeforces.com/contest/1430/problem/C
// TIME - O()

//package codeforces;
import java.io.*;
import java.util.*;

public class cf_numbersonwhiteboard {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(buf.readLine());

		while((testCases--) > 0) {

			int n = Integer.parseInt(buf.readLine());

			getNumber(n);
		}
	}

	// LOGIC- PriorityQueue to store the numbers in reverse order and pick first two numbers at every operation
	public static void getNumber(int n) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		List<int[]> chosen = new ArrayList<>();

		for(int i = 1; i <= n; ++i) { pq.add(i); }

		while(pq.size() != 1) {

			int a = pq.poll();
			int b = pq.poll();
			chosen.add(new int[]{a, b});

			pq.add((int)Math.ceil((a + b)/2.0));
		}

		System.out.println(pq.poll());

		for(int[] pair : chosen) {

			System.out.print(pair[0] + " " + pair[1]);
			System.out.println();
		}
	}
}

// I/O
