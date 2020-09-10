// initial public offering
// TIME - O()

//package leetcode;
import java.io.*;
import java.util.*;

public class citadel_ipo {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		
		List<List<Integer>> bids = new ArrayList<>(){{
			add(new ArrayList<Integer>(List.of(1,5,5,0))); 
			add(new ArrayList<Integer>(List.of(2,7,8,1)));
			add(new ArrayList<Integer>(List.of(3,7,5,1)));
			add(new ArrayList<Integer>(List.of(4,10,3,3)));
		}};

		//System.out.println(bids);
		
		int totalShares = 7;
			
		System.out.println(findLosers(bids, totalShares));
		
	}

	// Logic
	public static List<Integer> findLosers(List<List<Integer>> bids, int totalShares) {

		List<Integer> losers = new ArrayList<>(); // store loser IDs

		Collections.sort(bids, new Comparator<List<Integer>>() { // sort by bidding price

			public int compare(List<Integer> bid1, List<Integer> bid2) {

				return bid2.get(2) - bid1.get(2);
			}
		});

		System.out.println(bids);

		int totalBids = bids.size();
		int i = 0;

		loop: for(; i < totalBids; ++i) {

			int id = bids.get(i).get(0);
			int shares = bids.get(i).get(1);
			int price = bids.get(i).get(2);
			int time = bids.get(i).get(3);

			if((i < totalBids - 1 && price > bids.get(i+1).get(2)) || i == totalBids - 1) {

				totalShares -= shares;

				if(totalShares <= 0) {
					i++;
					break;
				}
			}
			else {

				int j = i;
				while(j < totalBids && price == bids.get(j).get(2)) ++j; // list of bidding ties [i to j]
				j--;

				// TIE BREAKER
				int tiedBids = j - i + 1;

				if(totalShares < tiedBids) { // not enough shares for a single roundrobin pass

					i += totalShares;
					break;
				}
				else { // enough shares for a single roundrobin pass

					boolean isUpdated = true;

					while(isUpdated) {

						isUpdated = false;

						for(int k = i; k <=j; k++) { // each round robin pass, reduce 1 share for each bidder

							if(bids.get(k).get(1) > 0) {

								bids.get(k).set(1, bids.get(k).get(1) - 1);
								totalShares--;
								isUpdated = true;

								if(totalShares == 0) {

									i = j + 1;
									break loop;
								}
							}
						}
					}
					
				}
			}
		}

		for(; i < totalBids; ++i) losers.add(bids.get(i).get(0)); // remaining bidders
         
        return losers;
		
    }
}

// I/O -

// totalShares = 18

// bids = [[id, #shares, price, time]]  --- sorted by time
// bids = [[1,5,5,0], [2,7,8,1], [3,7,5,1], [4,10,3,3]]

// Q - allot shares to top bidders, for ties = FCFS.
// A - find losers = no shares