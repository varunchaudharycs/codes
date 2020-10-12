package leetcode;// https://leetcode.com/problems/3sum/
// TIME - O(logn + n^2)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_3sum {
	
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

			findCombos(arr);
		}
	}

	// Logic - Sort. Iterate. For current element, get candidate pair from remaining list. AVOID same results.
	public static List<List<Integer>> findCombos(int[] nums) {

		Arrays.sort(nums);
		int len = nums.length;
		int target, low, high;
		List<List<Integer>> combos = new ArrayList<>();

		for(int i = 0; i < len - 2; ++i) {

			if(i > 0 && nums[i] == nums[i - 1]) continue;

			target = -nums[i]; // other two candidates' target(so total = 0)

			low = i + 1;
			high = len - 1;

			while(low < high) {

				if(nums[low] + nums[high] == target) {
					combos.add(Arrays.asList(nums[i], nums[low], nums[high]));
					low++;
					high--;

					while(low < high && nums[low] == nums[low - 1]) low++;
					while(low < high && nums[high] == nums[high + 1]) high--;
				}
				else if (nums[low] + nums[high] < target) 
					low++;
				else 
					high--;
			}
		}

		return combos;
    }
}

// I/O -

// Example:

// Given array nums = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]
