// https://leetcode.com/problems/permutations/
// TIME - O(n!)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_permutations {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(permute(new int[]{1,2,3}));
	}

	// LOGIC-
	// Avail --- Perm --- Total
	// {a,b,c} --- {} --- {}
	// {b,c} --- {a} --- {}
	// {c} --- {a,b} --- {}
	// {} --- {a,b,c} --- {}
	// {} --- {} -- {{a,b,c}}
	// backtrack
	// {b,c} --- {a} --- {{a,b,c}}
	// {b} --- {a,c} --- {{a,b,c}}
	// {} --- {a,c,b} --- {{a,b,c}}
	// {} --- {} --- {{a,b,c}, {a,c,b}}
	public static List<List<Integer>> permute(int[] nums) {
        
        int len = nums.length;
        
        List<List<Integer>> perms = new ArrayList<>();    
        List<Integer> avail = new ArrayList<>();
        if(len == 0) {
            perms.add(avail);
            return perms;
        }
        for(int num : nums) avail.add(num);
        
        for(int i = 0; i < len; ++i) {
            
            findPermutations(new ArrayList<Integer>(avail), 
                             new ArrayList<Integer>(), 
                             perms, 
                             len, 
                             i);
        }
        
        return perms;
    }
    
    public static void findPermutations(List<Integer> avail, List<Integer> perm, List<List<Integer>> perms, int len, int idx) {
        
        perm.add(avail.get(idx));
        
        if(perm.size() == len) {
            
            perms.add(perm);
            return;
        }
        
        avail.remove(idx);
        
        for(int j = 0; j < avail.size(); ++j) {
            
            findPermutations(new ArrayList<Integer>(avail),
                            new ArrayList<Integer>(perm),
                            perms,
                            len,
                            j);
        }
        
        return;
    }
}

// I/O -

// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
