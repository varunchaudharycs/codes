package codeforces;

import java.io.*;
import java.util.*;
// http://codeforces.com/contest/1042/problem/A

public class cf_benches
{
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        long arr[], arr2[][], num, t, temp, len, sum = 0, count = 0, diff = Long.MAX_VALUE, rem = 0, ans = 0;
        int i, j, n, m, k;
        char ch, crr[];
        String s = "", srr[];
        StringTokenizer st;
        boolean flag = true;
        HashMap<String, Long> slhm = new HashMap<>();
        HashMap<Long, String> lshm = new HashMap<>();
        HashMap<Long, Long> llhm = new HashMap<>();
        ArrayList<Long> arrlist = new ArrayList<>();
        ArrayList<String> srrlist = new ArrayList<>();
        long max = 0;
        
        n = Integer.parseInt(buf.readLine());
        m = Integer.parseInt(buf.readLine());
        
        arr = new long[n];
        
        for(i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(buf.readLine());
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        
        long ans_kMax = get_kMax(n, m, arr, max);
        long ans_kMin = get_kMin(n, m, arr, max);
        
        System.out.println(ans_kMin + " " + ans_kMax);
    }
    
    public static long get_kMax(int n, int m,long arr[], long max)
    {
        // all sit on the bench with already the maximum people
        return (max + m);
    }
    
    public static long get_kMin(int n, int m,long arr[], long max)
    {
        // distribute people ONLY on benches having people < max, reduce values from m -> m'
        for(int i = 0; i < n && m > 0; i++)
        {
            if(arr[i] != max)
            {
                m -= (max - arr[i]);
            }
        }
        // people still left to come?
        if(m > 0)
        {
            // if all benches have max value now, distribute evenly. max -> max'
            max += (m/n);
            // if m'%n > 0, +1 to the max' bench
            if(m % n > 0)
                max++;
            return max;
        }
        else
        {
            return max;
        }
        
    }
    
}
