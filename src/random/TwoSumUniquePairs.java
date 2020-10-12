package random;

import java.io.*;
import java.util.*;
import java.lang.*;

public class TwoSumUniquePairs {

	public static void main(String[] args)throws IOException {

		int[] nums1 = {1, 1, 2, 45, 46, 46};
		int target1 = 47;

		int[] nums2 = {1, 1};
		int target2 = 2;

		int[] nums3 = {1, 5, 1, 5};
		int target3 = 6;

		countPairs(nums1, target1);
		countPairs(nums2, target2);
		countPairs(nums3, target3);
	}

	// LOGIC- maintains set of seen elements
	public static void countPairs(int[] nums, int target) {

		Set<Integer> uniqueNums = new HashSet<>();
		int len = nums.length;
		Set<Integer> numsUsedInPair = new HashSet<>();
		int count = 0;

		for(int num : nums) {

			int rem = target - num;

			if(uniqueNums.contains(rem) && !numsUsedInPair.contains(numsUsedInPair)) {

				count++;
				numsUsedInPair.add(rem);
				numsUsedInPair.add(num);
			}

			uniqueNums.add(num);
		}

		System.out.println(count);
	}

	// LOGIC- sort array + maintain set of pairs
	// public static void countPairs(int[] nums, int target) {

	// 	Set<Integer> uniqueNums = new HashSet<>();

	// 	Set<List<Integer>> pairs = new HashSet<>();

	// 	Arrays.sort(nums); // ensures that pairs 

	// 	for(int num : nums) {

	// 		int rem = target - num;

	// 		if(uniqueNums.contains(rem)) {

	// 			List<Integer> pair = List.of(rem, num);
	// 			pairs.add(pair); // only added if unique pair
	// 		}

	// 		uniqueNums.add(num);
	// 	}

	// 	System.out.println(pairs.size());
	// }
}