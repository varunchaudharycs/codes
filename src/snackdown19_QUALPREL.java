import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;
// 

class snackdown19_QUALPREL
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
        TreeMap<Long, Long> treemap_ll = new TreeMap<>();
        ArrayList<Long> arrlist = new ArrayList<>();
        ArrayList<String> srrlist = new ArrayList<>();
        
        t = Integer.parseInt(buf.readLine());
        
        while((t--) > 0)
        {
            treemap_ll.clear();
            sum = 0;
            st = new StringTokenizer(buf.readLine());
            
            // accept N & K
            n = Integer.parseInt(st.nextToken());
            arr = new long[n];
            
            k = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(buf.readLine());
            
            // accept N values(points) - put in TreeMap
            // so we have a sorted list of scores & no. people who obtained each score
            for(i = 0; i < n; i++)
            {
                arr[i] = Long.parseLong(st.nextToken());
                
                if(treemap_ll.containsKey(arr[i]))
                {
                    temp = treemap_ll.get(arr[i]);
                    treemap_ll.put(arr[i], temp + 1);
                }
                else
                    treemap_ll.put(arr[i], (long)1);
            }
            
            // traversing from highest to lowest score
            for(long key: treemap_ll.descendingKeySet())
            {
                sum += treemap_ll.get(key);
                
                // we got our first K ranks
                if(sum >= k)
                {
                    System.out.println(sum);
                    break;
                }
            }
        }
    }
}
