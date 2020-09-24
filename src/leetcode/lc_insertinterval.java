// https://leetcode.com/problems/insert-interval/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_template {

	// put intrvals in order
	// 1. non-overlapping on left as it is
	// 2. consolidated start & end for all overlapping intervals
	// 3. non-overlapping on right as it is
	public int[][] insert(int[][] intervals, int[] newInterval) {

		int len = intervals.length;

		List<List<Integer>> merged = new ArrayList<>();

		int mergedStart = newInterval[0];
		int mergedEnd = newInterval[1];

		int i = 0;

		for (; i < len && intervals[i][1] < mergedStart; ++i) // non overlapping intervals on left
			merged.add(Arrays.asList(intervals[i][0], intervals[i][1]));

		for (; i < len && intervals[i][0] <= mergedEnd; ++i) {

			mergedStart = Math.min(mergedStart, intervals[i][0]);
			mergedEnd = Math.max(mergedEnd, intervals[i][1]);
		}

		merged.add(Arrays.asList(mergedStart, mergedEnd));

		for (; i < len; ++i)
			merged.add(Arrays.asList(intervals[i][0], intervals[i][1]));

		// convert list to array
		int[][] ans = new int[merged.size()][2];
		for (i = 0; i < merged.size(); ++i) {
			ans[i][0] = merged.get(i).get(0);
			ans[i][1] = merged.get(i).get(1);
		}

		return ans;
	}
}



	// Logic- new vs current
	// 1. start in between
	//  ---
	// ----------
	// 2. end in between
	// -------
	//    ---------
	// 3. superset
	// -----------------------
	//     -------------
// 	public static boolean isOverlapping(int[] intervalA, int[] intervalB) {
        
//         int newStart = intervalB[0];
//         int newEnd = intervalB[1];
        
//         int currentStart = intervalA[0];
//         int currentEnd = intervalA[1];
        
//         if((newStart >= currentStart && newStart <= currentEnd)
//            || (newEnd >= currentStart && newEnd <= currentEnd)
//            || (newStart < currentStart && newEnd > currentEnd))
//             return true;
//         else
//             return false;
//     }
    
//     // filter out overlapping intervals, find min of all starts and max of all ends
//     // if none found, insert acc to start time
//     // if found and inserted, copy the rem intervals as it is
//     public int[][] insert(int[][] intervals, int[] newInterval) {
        
//         int len = intervals.length;
        
//         List<ArrayList<Integer>> merged = new ArrayList<>();
        
//         int mergedStart = newInterval[0];
//         int mergedEnd = newInterval[1];
        
//         boolean found = false;
//         boolean merging = false;
        
//         for(int[] arr : intervals) {
            
//             if(found) { // interval merged, just opy remaining
                
//                 merged.add(new ArrayList<Integer>(Arrays.asList(arr[0], arr[1])));
//                 continue;
//             }
            
//             if(isOverlapping(arr, newInterval)) { // if overlapping, update merged interval's start/end
                                
//                 mergedStart = Math.min(mergedStart, arr[0]);
//                 mergedEnd = Math.max(mergedEnd, arr[1]);
//                 merging = true;
                
//             }
//             else {
                
//                 if(merging) { // if atleast one overlapping interval found, insert merged result
                    
//                     merged.add(new ArrayList<Integer>(Arrays.asList(mergedStart, mergedEnd)));
//                     found = true;
//                 }
                    
//                 else { // no overlapping window
                    
//                     if(mergedStart < arr[0]) { // insert new interval as it is
                        
//                         merged.add(new ArrayList<Integer>(Arrays.asList(mergedStart, mergedEnd)));
//                         found = true;
//                     }
//                 }
                
//                 merged.add(new ArrayList<Integer>(Arrays.asList(arr[0], arr[1])));
//             }        
//         }
        
//         if(!found) 
//             merged.add(new ArrayList<Integer>(Arrays.asList(mergedStart, mergedEnd)));
        
//         int[][] ans = new int[merged.size()][2];
        
//         for(int i = 0; i < merged.size(); ++i) {
            
//             ans[i][0] = merged.get(i).get(0);
//             ans[i][1] = merged.get(i).get(1);
//         }
        
//         return ans;
//     }
// }

// I/O -
// Example 1:

// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
// Example 2:

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
