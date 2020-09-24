// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// TIME - O(log n)

package leetcode;
import java.io.*;
import java.util.*;

public class lc_minimumrotatedsortedarray {
	
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

			System.out.println(findMin(arr));
		}
	}

	// property - both left & right ele are greater
	public static boolean isMidMin(int[] nums, int len, int mid) {

		int left = (mid - 1 < 0) ? len - 1 : mid - 1;
		int right = (mid + 1 >= len) ? 0 : mid + 1;

		boolean isLeftGreater = (nums[left] >= nums[mid]) ? true : false;
		boolean isRightGreater = (nums[right] >= nums[mid]) ? true : false;

		return isLeftGreater & isRightGreater;
	}

	// logic - check mid v/s high, gives idea of the starting point of array(left or right)
	public static int findMin(int[] nums) {
        
        int len = nums.length;
        int low = 0, high = len - 1, mid = (low + high) / 2;

        while(!isMidMin(nums, len, mid)) {

        	if(nums[mid] < nums[high]) high = mid - 1;
        	else low = mid + 1;

        	mid = (low + high) / 2;
        }

        return nums[mid];
    }
}

// I/O -

// Example 1:

// Input: [3,4,5,1,2] 
// Output: 1
// Example 2:

// Input: [4,5,6,7,0,1,2]
// Output: 0
//  