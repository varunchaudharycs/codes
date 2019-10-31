package codeforces;

import java.io.*;
import java.util.*;
// http://codeforces.com/contest/980/problem/A

public class cf_linksandpearls
{
    public static void main(String args[]) throws IOException {
        
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        long len;
        int i;
        String s = "";
        
        s = buf.readLine();
        len = s.length();
        
        long pearls = 0, links = 0;
        
        for(i = 0; i < len; i++)
        {
            if(s.charAt(i) == 'o')
                pearls++;
            else
                links++;
        }
        
        
        if(pearls == 0 || pearls == 1 || links == 0 || links % pearls == 0)
            System.out.println("YES");
        else
            System.out.println("NO");
        
    }
}
