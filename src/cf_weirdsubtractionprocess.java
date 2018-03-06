import java.io.*;
import java.util.*;
// http://codeforces.com/contest/946/problem/B

public class cf_weirdsubtractionprocess
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(buf.readLine());
        
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        while(!(n == 0 || m == 0))
        {
            if(n >= (2 * m))
                n %= (2 * m);
            else
                if(m >= (2 * n))
                    m %= (2 * n);
            else
                break;
        }
        
        System.out.println(n + " " + m);
        
    }
}
