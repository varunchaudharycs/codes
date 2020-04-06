// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3287/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

public class lc_buyandsellstock2 {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();

        int[] arr = {7,6,4,3,1}; // [-13 -5 -7 -3 -6 12 11 6 5]
        
        int ans = obj.maxProfit(arr);

        System.out.println(ans);
    }
    // Plot PRICES -> BUY at VALLEYS & SELL at PEAKS
    public int maxProfit(int[] prices) {

        int buyPrice = -1, profit = 0;

        for(int i = 0; i < prices.length; i++) {

            if(i == prices.length - 1) { // LAST DAY
                if(buyPrice != -1)
                    profit = (prices[i] > buyPrice) ? profit + (prices[i] - buyPrice) : profit;
                break;
            }
            
            if(buyPrice == -1) { 
                if(prices[i] < prices[i+1]) // BUY
                    buyPrice = prices[i]; 
            }
            else {
                if(prices[i] > prices[i+1] && prices[i] > buyPrice) { // SELL
                    profit += (prices[i]) - buyPrice;
                    buyPrice = -1;
                }
            }
        }

        return profit;
    }
}
