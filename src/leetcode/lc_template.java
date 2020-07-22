// problem link
// TIME - O()

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_template {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter array");
			inp = buf.readLine();
			st = new StringTokenizer(inp);

			n = st.countTokens();
			arr = new int[n];
			for(int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

			System.out.println(nameOfMethod(arr));
		}
	}

	// Logic
	public static int nameOfMethod(int[] nums) {

		// do something
         
        return -1;
    }
}

// I/O -

