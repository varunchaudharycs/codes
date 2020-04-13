// https://leetcode.com/explore/featured/card/30-day-leetcoding-chllenge/529/week-2/3297/
// TIME - O(max), SPACE - O(max) || O(n logn), SPACE - O(n)
package leetcode;
import java.io.*;
import java.util.*;

class lc_laststoneweight {

    public static void main(String[] args) throws IOException {

        lc_laststoneweight obj = new lc_laststoneweight();
        int[] arr = new int[]{2,7,4,1,8,1};
        int ans = obj.lastStoneWeight(arr);
        System.out.println(ans);
    }
    // BUCKET SORT + ELIMINATION ROUNDS
    public int lastStoneWeight(int[] stones) {

        int len = stones.length;
        int[] buckets = new int[Arrays.stream(stones).max().getAsInt() + 1];

        for(int weight : stones) buckets[weight]++;

        int pointer = Arrays.stream(stones).max().getAsInt();

        while(pointer > 0) {

            if((buckets[pointer] & 1) == 0) { // EVEN COUNT, DESTROYED IN PAIRS
                buckets[pointer] = 0; 
            }
            else { // ODD COUNT, FIND COMPETITIOR FOR SURVIVOR
                boolean found = false;
                for(int competitor = pointer - 1; competitor >= 0; competitor--) {

                    if(buckets[competitor] > 0) {
                        found = true;
                        buckets[competitor]--;
                        buckets[pointer] = 0;
                        if(pointer > competitor) buckets[pointer - competitor]++; // MAX1 - MAX2
                        break;
                    }
                }
                if(!found) break; // NOT FOUND (last remaining weight)
            }
            pointer--;
        }
        return pointer;
    }
    // PRIORITY QUEUE w/ REVERSE ORDERING as PRIORITY
//     public int lastStoneWeight(int[] stones) {

//         PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // REVERSE ORDER FOR PRIORITY
//         for(int stone : stones) pq.add(stone);

//         while(pq.size() >= 2) {

//             int max1 = pq.poll();
//             int max2 = pq.poll();

//             if(max1 > max2) pq.add(max1 - max2); // IF MAX > 2nd MAX
//         }

//         return (pq.size() == 0) ? 0 : pq.poll();          
//     }
}

