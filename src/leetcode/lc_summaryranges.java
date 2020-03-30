// https://leetcode.com/problems/summary-ranges/
// NO DUPLICATES, SORTED
// Time - O(n)
package leetcode;
import java.io.*;
import java.util.*;

class lc_summaryranges {
	
	public static void main(String[] args)throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = {0,1,2,4,5,7};

		lc_summaryranges obj = new lc_summaryranges();
		ArrayList<String> summary = new ArrayList<>(obj.summary_ranges(arr));

		for(String s : summary) System.out.println(s + " ");

	}

	public ArrayList<String> summary_ranges(int[] arr) {

		int len = arr.length, curr_i;
		ArrayList<String> summary = new ArrayList<>();
		// iterate thru the array
		for(int i = 0; i < len; i++) {

			curr_i = i;
			// while current element + 1 = next element
			while(i + 1 < len && arr[i] + 1 == arr[i + 1]) {
				i++;
			}
			// any increments?
			if(curr_i != i) {
				summary.add(arr[curr_i] + "->" + arr[i]);
			}
			else {
				summary.add(String.valueOf(arr[curr_i]));
			}

		}

		return summary;
	}
}