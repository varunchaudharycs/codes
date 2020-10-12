package random;// https://leetcode.com/discuss/interview-question/831199/drw-oa-2020
// TIME - O(n logn)

//package leetcode;
import java.io.*;
import java.util.*;

public class drw_breakchain {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int[] links = {5,2,4,6,3,7};

		assert findMinSum(links) == 5;

		System.out.println("SUCCESS");
	}

	// Logic- sort links. find a pair of weakest links that arent neighbors nor first and last.
	public static int findMinSum(int[] links) {

		int len = links.length;
		int sum = 0;

		List<Integer> P = new ArrayList<>();
		List<Integer> Q = new ArrayList<>();

		List<List<Integer>> link_idx = new ArrayList<>();

		for(int i = 0; i < len; ++i) link_idx.add(new ArrayList<Integer>(Arrays.asList(links[i], i)));

		Collections.sort(link_idx, new Comparator<List<Integer>>() { // sort based on link strength, increasing order

			public int compare(List<Integer> a, List<Integer> b) {

				return a.get(0) - b.get(0);
			}
		});

		int i = 0;

		while(P.isEmpty() || Q.isEmpty()) {

			int link = link_idx.get(i).get(0);
			int idx = link_idx.get(i).get(1);

			if(idx == 0 || idx == len - 1) { // first or last link

				continue;
			}

			if(P.isEmpty()) {

				P = link_idx.get(i);
			}
			else if(Q.isEmpty()) {

				if(!(P.get(1) + 1 == idx || P.get(1) - 1 == idx)) {

					Q = link_idx.get(i);
				}
			}

			i++;
		}

		sum = P.get(0) + Q.get(0);

		return sum;
    }
}

// I/O -

// {5,2,4,6,3,7} returns 5 after choosing (2,3)
