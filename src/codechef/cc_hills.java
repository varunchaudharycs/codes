package codechef;// https://www.codechef.com/problems/HILLS
import java.io.*;
import java.util.*;

class cc_hills
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    
        int t = Integer.parseInt(buf.readLine());
        int n, d, u, i, h[], jumps;
        boolean parachute;
        StringTokenizer st;
    
        while((t--) > 0)
        {
            parachute = true;
            st = new StringTokenizer(buf.readLine());
            n = Integer.parseInt(st.nextToken());
            u = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            h = new int[n];
            st = new StringTokenizer(buf.readLine());
    
            for (i = 0; i < n; i++)
                h[i] = Integer.parseInt(st.nextToken());
    
            for (i = 0; i < n - 1; i++)
            {
                if (h[i + 1] > h[i] && h[i + 1] - h[i] > u)
                    break;
                else
                    if (h[i + 1] < h[i] && h[i] - h[i + 1] > d)
                    {
                        if (parachute)
                            parachute = false;
                        else
                            break;
                    }
            }
    
            System.out.println(i + 1);
            
        }
       
    }
}
        

