// https://www.codechef.com/problems/CNOTE
import java.io.*;
import java.util.*;

class cc_cnote
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(buf.readLine());
        
        int x, k, n, i;
        boolean buy;
        StringTokenizer st;
        
        while ((t--) > 0)
        {
            buy = false;
            
            st = new StringTokenizer(buf.readLine());
            
            x = Integer.parseInt(st.nextToken());
            x -= Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            
            for(i = 0; i < n; i++)
            {
                st = new StringTokenizer(buf.readLine());
                
                if((Integer.parseInt(st.nextToken()) - x) >= 0 && (k - Integer.parseInt(st.nextToken())) >=0)
                    buy = true;
            }
            
            if(buy)
                System.out.println("LuckyChef");
            else
                System.out.println("UnluckyChef");
        }
        
    }
}
