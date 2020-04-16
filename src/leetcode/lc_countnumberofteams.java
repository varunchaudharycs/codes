// https://leetcode.com/problems/count-number-of-teams/
// TIME - O(n^2)
package leetcode;
import java.io.*;
import java.util.*;

class lc_countnumberofteams {

    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        lc_countnumberofteams obj = new lc_countnumberofteams();
        while(true) {
            // STRING VARIABLE
             String s = buf.readLine();
             s = s.replaceAll("\"","").replaceAll("\\[","").replaceAll("\\]","");
            // STRING ARRAY
            String[] srr = s.split(",");
            // INT ARRAY
            int[] arr = new int[srr.length];
            for(int i = 0; i < srr.length; i++) arr[i] = Integer.parseInt(srr[i]);

            int ans = obj.numTeams(arr);
            System.out.println(ans);
        }
    }
    // TAKE CURRENT ELEMENT AS PIVOT (a < i < b) OR (a > i > b)
    // teams[i] = (less[0,i-1] * high[i+1,length]) + (high[0,i-1] * less[i+1,length])
    public int numTeams(int[] rating) {
        
        int len = rating.length;
        int count = 0;
        
        for(int i = 0; i < len; i++) {
            int low = 0, high = 0;
            for(int j = 0; j < i; j++) {
                low += (rating[j] < rating[i]) ? 1 : 0; 
            }
            for(int j = i + 1; j < len; j++) {
                high += (rating[j] > rating[i]) ? 1 : 0; 
            }
            count += (low * high);

            low = 0; high = 0;
            for(int j = i + 1; j < len; j++) {
                low += (rating[j] < rating[i]) ? 1 : 0; 
            }
            for(int j = 0; j < i; j++) {
                high += (rating[j] > rating[i]) ? 1 : 0; 
            }
            count += (low * high);
        }
        return count;
    }
}

