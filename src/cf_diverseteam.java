import java.io.*;
import java.util.*;
// http://codeforces.com/contest/988/problem/A

public class cf_diverseteam
{
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        long arr[], arr2[][], num, t, temp, len, sum = Long.MIN_VALUE, count = 0, diff = Long.MAX_VALUE, rem, ans;
        int i, j, n, k;
        char ch, crr[];
        String s = "", srr[];
        StringTokenizer st;
        boolean flag = false;
        
        st = new StringTokenizer(buf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        HashMap<Long, Integer> hm = new HashMap<>();
        ArrayList<Integer> arrlist = new ArrayList<>();
    
        srr = buf.readLine().split(" ");
        arr = new long[n];
        
        for(i = 0; i < n && k > 0; i++)
        {
            arr[i] = Long.parseLong(srr[i]);
            
            if(hm.get(arr[i]) == null)
            {
                k--;
                hm.put(arr[i], 1);
                arrlist.add(i+1);
            }
        }
        
        if(k == 0)
        {
            System.out.println("YES");
            for (i=0; i<arrlist.size(); i++)
                System.out.print(arrlist.get(i)+" ");
        }
        else
        {
            System.out.println("NO");
        }
    }
}
