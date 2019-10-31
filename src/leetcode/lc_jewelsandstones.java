package leetcode;///

import java.io.*;
import java.util.*;
// https://leetcode.com/problems/jewels-and-stones/submissions/

public class lc_jewelsandstones
{
    public static int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> hm = new HashMap<>();  // to store each type of jewel(given- distinct)
        int ans = 0;  // default answer
        for(int i = 0; i < J.length(); i++) {
            hm.put(J.charAt(i), 1);
        }
        // iterate over every character and find it in jewel hashmap
        for(int i = 0; i < S.length(); i++) {
            if(hm.get(S.charAt(i)) != null)
                ans++;
        }
        
        return ans;
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
