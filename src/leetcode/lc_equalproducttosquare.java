package leetcode;// https://leetcode.com/contest/weekly-contest-205/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/
// TIME - O(n^2)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_equalproducttosquare {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int[] nums1a = {7,4};
		int[] nums2a = {5,2,8,9};

		int[] nums1b = {1,1};
		int[] nums2b = {1, 1, 1};

		int[] nums1c = {7,7,8,3};
		int[] nums2c = {1,2,9,7};

		int[] nums1d = {4,7,9,11,23};
		int[] nums2d = {3,5,1024,12,18};

		System.out.println(numTriplets(nums1a, nums2a));
		System.out.println(numTriplets(nums1b, nums2b));
		System.out.println(numTriplets(nums1c, nums2c));
		System.out.println(numTriplets(nums1d, nums2d));
	}

	// Logic- store (squares,count) in map to reduce n^3 to n^2
	public static int numTriplets(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int triplets = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        HashMap<Long, Integer> sq1 = new HashMap<>();
        for(int i = 0; i < len1; ++i) {
            long sq = (long)Math.pow(nums1[i], 2);
            sq1.put(sq, sq1.getOrDefault(sq, 0) + 1);
        }
        HashMap<Long, Integer> sq2 = new HashMap<>();
        for(int i = 0; i < len2; ++i) {
            long sq = (long)Math.pow(nums2[i], 2);
            sq2.put(sq, sq2.getOrDefault(sq, 0) + 1);
        }
        
        
        for(int i = 0; i < len1 - 1; ++i) {
            for(int j = i + 1; j < len1; ++j) {
                
                long prod = (long)nums1[i] * nums1[j];
                
                triplets += sq2.getOrDefault(prod, 0);
            }
        }
        
        for(int i = 0; i < len2 - 1; ++i) {
            
            for(int j = i + 1; j < len2; ++j) {
                
                long prod = (long)nums2[i] * nums2[j];
            
                triplets += sq1.getOrDefault(prod, 0);
            }
        }
        
        return triplets;
    }
}

// I/O -

// Example 1:

// Input: nums1 = [7,4], nums2 = [5,2,8,9]
// Output: 1
// Explanation: Type 1: (1,1,2), nums1[1]^2 = nums2[1] * nums2[2]. (4^2 = 2 * 8). 
// Example 2:

// Input: nums1 = [1,1], nums2 = [1,1,1]
// Output: 9
// Explanation: All Triplets are valid, because 1^2 = 1 * 1.
// Type 1: (0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2).  nums1[i]^2 = nums2[j] * nums2[k].
// Type 2: (0,0,1), (1,0,1), (2,0,1). nums2[i]^2 = nums1[j] * nums1[k].
// Example 3:

// Input: nums1 = [7,7,8,3], nums2 = [1,2,9,7]
// Output: 2
// Explanation: There are 2 valid triplets.
// Type 1: (3,0,2).  nums1[3]^2 = nums2[0] * nums2[2].
// Type 2: (3,0,1).  nums2[3]^2 = nums1[0] * nums1[1].
// Example 4:

// Input: nums1 = [4,7,9,11,23], nums2 = [3,5,1024,12,18]
// Output: 0
// Explanation: There are no valid triplets.