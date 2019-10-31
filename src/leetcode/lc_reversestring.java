package leetcode;

import java.io.*;
import java.util.*;
// https://leetcode.com/problems/reverse-string/submissions/

public class lc_reversestring
{
    // Switch characters (first, last), (second, second last) and so on ...
    public static void reverseString(char[] s) {
        int len = s.length;
        char t;
        for(int i = 0; i < len/2; i++)
        {
            s[i] += s[len - i - 1];
            s[len - i - 1] = (char)(s[i] -s[len - i - 1]);
            s[i] -= s[len - i - 1];
        }
        System.out.println(s);
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        char s[] = new char[]{'h','e','l','l','o'};
        reverseString(s);
    }
}
