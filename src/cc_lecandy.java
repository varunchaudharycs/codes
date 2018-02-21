// https://www.codechef.com/problems/LECANDY
import java.io.*;
import java.util.*;

class cc_lecandy
{
    public static void main(String args[])throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(buf.readLine());
        
        StringTokenizer st;
        int n, c, sum, i;
        
        while((t--) > 0)
        {
            sum = 0;
            st = new StringTokenizer(buf.readLine());
            
            n = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(buf.readLine());
            
            for(i = 0; i < n; i++)
                sum += Integer.parseInt(st.nextToken());
            
            if(sum > c)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
        
    }
}
