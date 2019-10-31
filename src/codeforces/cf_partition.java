package codeforces;

import java.io.*;
import java.util.*;
// http://codeforces.com/contest/946/problem/A

class cf_partition
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        String s = "";
        char ch;
        long n, i, j, arr[], num;
        
        long b = 0, c = 0;
        
        n = Integer.parseInt(buf.readLine());
        
        st = new StringTokenizer(buf.readLine());
        
        while(st.hasMoreTokens())
        {
            num = Integer.parseInt(st.nextToken());
            
            if(num < 0)
                c += num;
            else
                b += num;
        }
        
        System.out.println(b - c);
        
    }
}
