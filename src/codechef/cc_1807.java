package codechef;

import java.io.*;
import java.util.*;
// https://www.codechef.com/NCC2018/problems/NCC1807

class cc_1807
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(buf.readLine());
        int n, k;
        long sweets;
        StringTokenizer st;
        
        
        while((t--) > 0)
        {
            st = new StringTokenizer(buf.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            sweets = (((n * n) + n)/2) + (k * n) - k;
            
            System.out.println(sweets);
        
        }
        
    }
}
