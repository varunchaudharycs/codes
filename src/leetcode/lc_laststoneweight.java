// https://leetcode.com/explore/featured/card/30-day-leetcoding-chllenge/529/week-2/3297/
// TIME - O(nlogn) cuz SORTING
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

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // REVERSE ORDER FOR PRIORITY
        for(int stone : stones) pq.add(stone);

        while(pq.size() >= 2) {

            int max1 = pq.poll();
            int max2 = pq.poll();

            if(max1 > max2) pq.add(max1 - max2); // IF MAX > 2nd MAX
        }

        return (pq.size() == 0) ? 0 : pq.poll();          
    }
}

