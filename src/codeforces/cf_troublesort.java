// link
// TIME - O()

//package codeforces;
import java.io.*;
import java.util.*;

public class cf_troublesort {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));


		int testCases = Integer.parseInt(buf.readLine());

		while((testCases--) > 0) {

			String s;
			StringTokenizer st;
			int n;

			s = buf.readLine();
			//st = new StringTokenizer(s);
			n = Integer.parseInt(s);

			int[] arr = new int[n];
			int[] types = new int[n];
			st = new StringTokenizer(buf.readLine());
			for(int i = 0; i < n; ++i) {

				arr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(buf.readLine());
			for(int i = 0; i < n; ++i) {

				types[i] = Integer.parseInt(st.nextToken());
			}

			System.out.println(isPossible(arr, types, n));

		}


	}

	// 
	public static String isPossible(int[] arr, int[] types, int n) {

		if(isSorted(arr)) return "Yes";
		else if(Arrays.stream(types).distinct().count() == 1) return "No"; // unsorted list, all nums of same type

		boolean isChanged;

		do {

			isChanged = false;

			for(int i = 0; i < n - 1; i++) {

				if(arr[i] > arr[i+1]) { // invalid for non-decreasing

					for(int j = i + 1; j < n; ++j) { // find a legit replacement

						if(arr[j] < arr[i] && types[j] != types[i]) { // swap

							arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
							types[i] = types[i] ^ types[j] ^ (types[j] = types[i]);
							isChanged = true;
						}
					}
				}
			}

		} while(isChanged && !isSorted(arr));

		if(isSorted(arr)) return "Yes";
		else return "No";
	}

	public static boolean isSorted(int[] arr) {

		int len = arr.length;

		for(int i = len - 1; i > 0; --i) {

			if(arr[i] < arr[i-1]) return false;
		}

		return true;
	}
}

// I/O

// 5
// 4
// 10 20 20 30
// 0 1 0 1
// 3
// 3 1 2
// 0 1 1
// 4
// 2 2 4 8
// 1 1 1 1
// 3
// 5 15 4
// 0 0 0
// 4
// 20 10 100 50
// 1 0 0 1


// Yes
// Yes
// Yes
// No
// Yes

