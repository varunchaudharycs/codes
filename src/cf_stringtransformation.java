import java.io.*;
import java.util.*;
// http://codeforces.com/contest/946/problem/C

public class cf_stringtransformation
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        long arr[], n, num, t, temp, len, sum = Long.MIN_VALUE, diff = Long.MAX_VALUE, count = 0;
        char ch, crr[];
        int i, j;
        String s = "", srr[];
        StringTokenizer st;
        boolean flag = false;
        
        crr = buf.readLine().toCharArray();
        len = crr.length;
        
        if(len < 26)
        {
            System.out.println("-1");
            System.exit(0);
        }
        
        ch = 'a';
        
        for(i = 0; i < len && ch < '{'; i++)
        {
            if(ch - crr[i] >= 0)
            {
                crr[i] = ch;
                ch++;
            }
        }
        
        if(ch == '{')
            System.out.println(crr);
        else
            System.out.println("-1");
        
        
    }
}
