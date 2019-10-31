package codeforces;

import java.io.*;
import java.util.*;
import java.util.logging.LoggingPermission;
// http://codeforces.com/contest/988/problem/B

public class cf_substringssort
{
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        long arr[], arr2[][], k, num, t, temp, len, sum = Long.MIN_VALUE, count = 0, diff = Long.MAX_VALUE, rem, ans;
        int i, j, n, m;
        char ch, crr[];
        String s = "", srr[];
        StringTokenizer st;
        boolean flag = true;
    
        n = Integer.parseInt(buf.readLine());
        
        srr = new String[n];
        
        for(i = 0; i < n; i++)
            srr[i] = buf.readLine();
    
        Arrays.sort(srr, (a, b)->Integer.compare(a.length(), b.length()));
        
        if(n == 1)
        {
            System.out.println("YES");
            System.out.println(srr[0]);
        }
        else
        {
            for(i = 1; i < n; i++)
            {
                if(!srr[i].contains(srr[i-1]))
                    flag = false;
            }
    
            if(flag)
            {
                System.out.println("YES");
                for(i = 0; i < n; i++)
                    System.out.println(srr[i]);
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
}
