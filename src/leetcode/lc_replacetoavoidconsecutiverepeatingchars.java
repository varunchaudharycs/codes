package leetcode;// https://leetcode.com/contest/weekly-contest-205/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
// TIME - O(n)

//package leetcode;
import java.io.*;
import java.util.*;

public class lc_replacetoavoidconsecutiverepeatingchars {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		String s1 = "?zs";
		String s2 = "ubv?w";
		String s3 = "j?qg??b";
		String s4 = "??yw?ipkj?";

		System.out.println(modifyString(s1));
		System.out.println(modifyString(s2));
		System.out.println(modifyString(s3));
		System.out.println(modifyString(s4));
	}

	// Logic
	public static String modifyString(String s) {
        
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        
        char last = '.';
        
        
        outer: for(int i = 0; i < len;) {
            
            char ch = s.charAt(i);
            
            if(ch != '?') {
                
                sb.append(ch);
                last = ch;
                ++i;
            }
            else {
                
                
                while(ch == '?' && i < len) {
                    
                    int replacement = 0;
                    while('a' + replacement == last || (i < len - 1 && 'a' + replacement == s.charAt(i + 1))) {
                        
                        replacement = (replacement + 1) % 26;
                    }
                    
                    last = (char)('a' + replacement);
                    sb.append(last);
                    
                    //System.out.println(last + "@" + i);
                    
                    if(i == len - 1) break outer;
                    else ch = s.charAt(++i);
                }
            }
        }
        
        return sb.toString();        
    }
}

// I/O -

// Example 1:

// Input: s = "?zs"
// Output: "azs"
// Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
// Example 2:

// Input: s = "ubv?w"
// Output: "ubvaw"
// Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".
// Example 3:

// Input: s = "j?qg??b"
// Output: "jaqgacb"
// Example 4:

// Input: s = "??yw?ipkj?"
// Output: "acywaipkja"