package codeforces;

import java.io.*;
import java.util.*;
// http://codeforces.com/contest/946/problem/D

public class cf_timetable_INCOMPLETE
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        long arr[], arr2[][], num, t, temp, len, sum = Long.MIN_VALUE, count = 0, diff = Long.MAX_VALUE, rem, ans, arr3[];
        int i, j, n, m, k;
        char ch, crr[];
        String s = "", srr[];
        StringTokenizer st;
        boolean flag = false;
        
        st = new StringTokenizer(buf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr2 = new long[n][m];
        arr = new long[n];
        arr3 = new long[n];
        
        for(i = 0; i < n; i++)
        {
            st = new StringTokenizer(buf.readLine());
            flag = false;
            temp = -1;
            
            for(j = 0; j < m; j++)
            {
                arr2[i][j] = Integer.parseInt(st.nextToken());
    
                if (arr2[i][j] == 1 && !flag)
                {
                    flag = true;
                    temp = j;
                }
    
            }
            
            for(j = m - 1; j >= 0 && temp != -1; j--)
            {
                if(arr2[i][j] == 1)
                    if(j == temp)
                        arr[i] = 1;
                    else
                        arr[i] = j - temp + 1;
            }
            
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        
    }
}
