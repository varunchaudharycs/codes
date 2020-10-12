package leetcode;// https://leetcode.com/contest/weekly-contest-205/problems/minimum-deletion-cost-to-avoid-repeating-letters/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_minimumdeletioncost {
	
	public static void main(String[] args) throws IOException {

		String s1 = "abaac";
		int[] cost1 = {1,2,3,4,5};

		String s2 = "abc";
		int[] cost2 = {1,2,3};

		String s3 = "aabaa";
		int[] cost3 = {1,2,3,4,1};

		System.out.println(minCost(s1, cost1));
		System.out.println(minCost(s2, cost2));
		System.out.println(minCost(s3, cost3));
	}

	public static int findMinCost(int start, int end, int[] cost) {
        
        int maximumCost = Arrays.stream(Arrays.copyOfRange(cost, start, end+1)).max().getAsInt();
        int sumCost = Arrays.stream(Arrays.copyOfRange(cost, start, end+1)).sum();
        
        return sumCost - maximumCost; // cheapest options to remove
    }
    
    // LOGIC- find repeating char window, reqd cost = total cost - max cost(cheapest k-1 deletions)
    public static int minCost(String s, int[] cost) {
        
        int len = s.length();
        int totalCost = 0;
        
        char[] arr = s.toCharArray();        
        
        for(int i = 0; i < len - 1; ++i) {
            
            if(arr[i] == arr[i+1]) {
                
                int start = i;
                while(i < len - 1 && s.charAt(i) == s.charAt(i+1)) i++;
                int end = Math.min(len - 1, i);
                
                totalCost += findMinCost(start, end, cost);                
            }
        }
        
        return totalCost;
    }
}

// I/O -

// Example 1:

// Input: s = "abaac", cost = [1,2,3,4,5]
// Output: 3
// Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
// Example 2:

// Input: s = "abc", cost = [1,2,3]
// Output: 0
// Explanation: You don't need to delete any character because there are no identical letters next to each other.
// Example 3:

// Input: s = "aabaa", cost = [1,2,3,4,1]
// Output: 2
// Explanation: Delete the first and the last character, getting the string ("aba").