package leetcode;

import java.io.*;
import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// TIME - O(n)
// SPACE - O(n)

class lc_longestsubstringwithoutrepeatingcharacters {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> hm = new HashMap<>();
        int len_curr = 0, len_ans = 0;
        Optional<Integer> tmp;
        
        for(int i = 0; i < s.length(); ++i) {
            
            tmp = Optional.ofNullable(hm.put(s.charAt(i), i));
            
            if(!tmp.isPresent())
                len_curr++;
            else {
                len_ans = Math.max(len_ans, len_curr);
                len_curr = i - tmp.get();
                hm.clear();
                for(int j = tmp.get(); j <= i; ++j)
                    hm.put(s.charAt(j), j);
            }
        }
        
        return Math.max(len_ans, len_curr);
    }
}
