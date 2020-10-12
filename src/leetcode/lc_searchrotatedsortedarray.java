package leetcode;// https://leetcode.com/problems/search-in-rotated-sorted-array/
// TIME - O(log n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_searchrotatedsortedarray {
	
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
			n = Integer.parseInt(buf.readLine());

			System.out.println(findElement(arr, n));
		}
	}

	// Logic - IF mid > high, normal Binary Search ELSE reverse logic
	public static int findElement(int[] nums, int target) {


        int len = nums.length;
        
        if(len == 0) return -1;
        
        int l = 0, h = len - 1, m = (l + h) / 2;
        
        while(nums[m] != target && l <= h) {

			if(nums[m] < nums[h]) { // normal

				if(target > nums[m] && target <= nums[h]) l = m + 1;
			    else h = m - 1;    
			}
			
			else { // reverse logic

				if(target > nums[h] && target < nums[m]) h = m - 1;
				else l = m + 1;
				        
			}
			
			m = (l+h) /2;	            
		}

        if(nums[m] == target) return m;
        else return -1;
    }
}

// I/O -

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
