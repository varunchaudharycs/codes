// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
// TIME - O(n logn + 4n)

package leetcode;
import java.io.*;
import java.util.*;

public class lc_maximumareaofcake {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		boolean keepTesting = true;

		while(true) {

			String inp;
			StringTokenizer st;
			int[] arr;
			int n;

			System.out.println("Enter h and w");
			inp = buf.readLine();
			st = new StringTokenizer(inp);
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			System.out.println("Enter horizontal cuts");
			inp = buf.readLine();
			st = new StringTokenizer(inp);
			n = st.countTokens();
			int[] hCuts = new int[n];
			for(int i = 0; i < n; ++i) hCuts[i] = Integer.parseInt(st.nextToken());

			System.out.println("Enter vertical cuts");
			inp = buf.readLine();
			st = new StringTokenizer(inp);
			n = st.countTokens();
			int[] vCuts = new int[n];
			for(int i = 0; i < n; ++i) vCuts[i] = Integer.parseInt(st.nextToken());

			System.out.println(maxArea(h, w, hCuts, vCuts));
		}
	}

	// sort cut indices. find biggest difference between consecutive elements for maximising area
	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		ArrayList<Long> horizontalCutsArrL = new ArrayList<>();
		ArrayList<Long> verticalCutsArrL = new ArrayList<>();

		for(int cut : horizontalCuts) horizontalCutsArrL.add((long)cut);
		horizontalCutsArrL.add((long)h); // top boundary
		for(int cut : verticalCuts) verticalCutsArrL.add((long)cut);
		verticalCutsArrL.add((long)w); // rightmost boundary

		// sort
		Collections.sort(horizontalCutsArrL);
		Collections.sort(verticalCutsArrL);

		// LOGIC- find biggest difference between consecutive elements for maximising area
		// current element = current element - previous
		for(int i = horizontalCutsArrL.size() - 1; i > 0; --i) horizontalCutsArrL.set(i, horizontalCutsArrL.get(i) - horizontalCutsArrL.get(i-1));
		for(int i = verticalCutsArrL.size() - 1; i > 0; --i) verticalCutsArrL.set(i, verticalCutsArrL.get(i) - verticalCutsArrL.get(i-1));

		int ans = (int)((Collections.max(horizontalCutsArrL) * Collections.max(verticalCutsArrL))%(Math.pow(10,9) + 7));

		return ans;
	}
	
}

// I/O -

// Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
// Output: 4 
// Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.

// Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
// Output: 6
// Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.
// Example 3:

// Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
// Output: 9
//  