// https://leetcode.com/discuss/interview-question/381518/drw-oa-2019-soldiers
// TIME - O(n logn)

import java.io.*;
import java.util.*;

public class drw_soldiers {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int[] ranks1 = {3,4,3,0,2,2,3,0,0};
		int[] ranks2 = {4,2,0};
		int[] ranks3 = {4,4,3,3,1,0};

		assert findReportingSoldiers(ranks1) == 5;
		assert findReportingSoldiers(ranks2) == 0;
		assert findReportingSoldiers(ranks3) == 3;

		System.out.println("SUCCESS");
	}

	// Logic- instead of sorting ranks, store counts in map
	public static int findReportingSoldiers(int[] ranks) {

		int reporting = 0;

		HashMap<Integer, Integer> rank_count = new HashMap<>();

		for(int rank : ranks) rank_count.put(rank, rank_count.getOrDefault(rank, 0) + 1);

		for(Map.Entry<Integer, Integer> e : rank_count.entrySet()) {

			int soldier = e.getKey();
			int officer = soldier + 1;

			if(rank_count.containsKey(officer)) reporting += rank_count.get(soldier);
		}

        return reporting;
    }

	// Logic- Sort ranks. Count people with same rank. Check if their reporting officer exists.
	// public static int findReportingSoldiers(int[] ranks) {

	// 	int totalSoldiers = ranks.length;
	// 	int reporting = 0;

	// 	Arrays.sort(ranks);

	// 	for(int i = 0; i < totalSoldiers;) {

	// 		int currRank = ranks[i];
	// 		int start = i;

	// 		while(i < totalSoldiers && ranks[i] == currRank) i++; // cout soldiers with the same rank

	// 		if(i < totalSoldiers && currRank + 1 == ranks[i]) reporting += i - start; // check reporting officer
	// 	}
         
 //        return reporting;
 //    }
}

// I/O -

// [3,4,3,0,2,2,3,0,0] returns 5
// rank 3 solders(total=3) report to rank 4.
// rank 2 soldiers(total=2) report to rank 3.

// [4,2,0] returns 0

// [4,4,3,3,1,0] returns 3