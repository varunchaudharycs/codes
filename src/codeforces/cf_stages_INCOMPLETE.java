package codeforces;

import java.io.*;
import java.util.*;
// 

public class cf_stages_INCOMPLETE
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
        
        st = new StringTokenizer(buf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        // RESULT
        char crr2[] = new char[k];
        crr = buf.readLine().replaceAll(" ", "").toCharArray();
        
        // SORT - ascending
        Arrays.sort(crr);
        
        // selecting first element
        crr2[0] = crr[0];
        sum = (int)crr[0];
        // sum - of weights with current selection
        // t - latest stage selected(for reference - diff > 1)
        // c - current stage number
        for(i = 1, j = 1; i < n && j != k - 1; i++)
        {
            if(crr[i] - crr2[j - 1] > 1)
            {
                crr2[j++] = crr[i];
                sum += (int)crr[i];
            }
        }
        
        for(i=0;i<j;i++)System.out.println(crr2[i]);
        // check if k is achieved
        if(j == k)
        {
            System.out.println(sum);
        }
        else
        {
            System.out.println("-1");
        }
    }
}
