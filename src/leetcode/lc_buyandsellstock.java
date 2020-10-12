// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_buyandsellstock {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        lc_buyandsellstock obj = new lc_buyandsellstock();
        int[] arr = {7,6,4,3,1};
        int ans = obj.maxProfit(arr);

        System.out.println(ans);
    }
    /*
    profit = max 
                {
                    0 , i = 0
                    prices[i] - min of prices[0 -> (i - 1)]
                }
    */
    public int maxProfit(int[] prices) {

        int len = prices.length;
        if(len == 0) return 0;
        int minBuy = prices[0]; // minimum buying price
        int maxProfit = 0; // maximum profit

        for(int i = 1; i < len; i++) {

            int profit = prices[i] - minBuy; // current profit
            if(profit > maxProfit) 
                maxProfit = profit;

            minBuy = Math.min(minBuy, prices[i]);// update minimum buying price
        }

        return maxProfit;
    }
}
