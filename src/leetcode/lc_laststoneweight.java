// https://leetcode.com/explore/featured/card/30-day-leetcoding-chllenge/529/week-2/3297/
// TIME - O(n * nlogn) cuz SORTING
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

        List<Integer> l = new ArrayList<>(stones.length);
        for(int stone : stones) l.add(stone);

        while(l.size() > 1) {

            Collections.sort(l, Collections.reverseOrder());

            if(l.get(0) > l.get(1)) {
                l.set(0, l.get(0) - l.get(1));
                l.remove(l.get(1));
            }
            else {
                l.remove(l.get(0));
                l.remove(l.get(0));
            }
        }

        return (l.size() == 0) ? 0 : l.get(0);        
    }
}

