// https://leetcode.com/problems/container-with-most-water/
// TIME - O()

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_containerwithmostwater {
	
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

			System.out.println(findContainer(arr));
		}
	}

	// Logic - Start at corners come inside from the shorter side and keep track of water capacity. GREEDY
	public static int findContainer(int[] height) {

		int maxWater = 0, currentWater;
		int len = height.length;
		int low = 0, high = len - 1;

		while(low < high) {

			currentWater = Math.min(height[low], height[high]) * (high - low);

			maxWater = Math.max(maxWater, currentWater);

			if(height[low] < height[high]) low++;
			else high--;
		}

		return maxWater;
    }
}

// I/O -

// Example:

// Input: [1,8,6,2,5,4,8,3,7]
// Output: 49
