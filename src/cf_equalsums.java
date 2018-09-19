import java.io.*;
import java.util.*;
// https://codeforces.com/contest/988/problem/C

public class cf_equalsums
{
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        long arr[], arr2[][], num, t, temp, len, sum = 0, count = 0, diff = Long.MAX_VALUE, rem, ans;
        int i, j, n, m, k;
        StringTokenizer st;
        boolean flag = true;
        HashMap<Long, Integer> llhm = new HashMap<>();
        HashMap<Long, Integer> llhm2 = new HashMap<>();
        k = Integer.parseInt(buf.readLine());
        
        /*
        reading a sequence and storing the sum obtained by removing each element at a time.
        These sums are stored in a map which is looked up everytime a sum is computed for the answer.
         */
        for(i = 0; i < k; i++)
        {
            sum = 0;
            n = Integer.parseInt(buf.readLine());
            
            st = new StringTokenizer(buf.readLine());
            arr = new long[n];
            
            // answer not found yet
            if(flag)
            {
                for(j = 0; j < n; j++)
                {
                    arr[j] = Integer.parseInt(st.nextToken());
                    sum += arr[j];
                }
                
                for(j = 0; j < n; j++)
                {
                    temp = sum - arr[j];
                    
                    // check if computed sum already exists
                    if(flag && llhm.containsKey(temp)) {
                        
                        // not from the same seq
                        if (llhm.get(temp) != (i + 1)) {
                            System.out.println("YES");
                            System.out.println(llhm.get(temp) + " " + llhm2.get(temp));
                            System.out.println((i + 1) + " " + (j + 1));
                            flag = false;
                        }
                    }
                    // put sum in map
                    else
                    {
                        llhm.put(temp, (i + 1));
                        llhm2.put(temp, (j + 1));
                    }
                }
            }
        }
        
        // no match found
        if(flag)
            System.out.println("NO");
        
    }
}
