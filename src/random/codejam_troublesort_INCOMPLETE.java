package random;

import java.io.*;
import java.util.*;
// https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard/00000000000079cb

public class codejam_troublesort_INCOMPLETE
{
    public static long arr[];
    public static int n;
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        long t;
        int i, j, k;
        int index;
        String srr[];
        t = Long.parseLong(buf.readLine());
        
        for(j = 1; j <= t; j++)
        {
            n = Integer.parseInt(buf.readLine());
            arr = new long[n];
            
            srr = buf.readLine().split(" ");
            
            for(i = 0; i < n; i++)
                arr[i] = Long.parseLong(srr[i]);
            
            
            troubleSort();
            
            index = ifUnsorted();
            
            if(index == -1)
                System.out.println("Case #" + j + ": OK");
            else
                System.out.println("Case #" + j + ": " + index);
    
        }
        
    }
    
    
    public static int ifUnsorted()
    {
        int i;
        for(i = 0; i < n - 1; i++)
        {
            if(arr[i] > arr[i + 1])
                break;
        }
        
        if (i == n - 1)
            return -1;
        else
            return i;
    }
    
    public static void troubleSort()
    {
        long temp;
        boolean done = false;
        
        while(!done)
        {
            done = true;
            
            for(int i = 0; i < n - 2; i++)
            {
                if(arr[i] > arr[i + 2])
                {
                    done = false;
                    temp = arr[i];
                    arr[i] = arr[i + 2];
                    arr[i + 2] = temp;
                }
            }
        }
        
        
        
    }
}
