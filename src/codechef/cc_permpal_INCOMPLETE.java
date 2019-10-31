package codechef;

import java.io.*;
import java.util.*;

class cc_permpal_INCOMPLETE
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(buf.readLine());
        int i, l, odd, left, right, p[], id;
        char chr[];
        HashMap<Character, Integer> hm;
        HashMap<Character, Boolean> hmvisit;
        
        while((t--) > 0)
        {
            id = -1;
            odd = 0;
            hm = new HashMap<>();
            hmvisit = new HashMap<>();
            chr = buf.readLine().toCharArray();
    
            l = chr.length;
            p = new int[l];
            left = 0;
            right = l - 1;
    
            for(i = 0; i < l; i++)
            {
                if(hm.containsKey(chr[i]))
                {
                    hm.put(chr[i], hm.get(chr[i]) + 1);
    
                    if(hm.get(chr[i]) % 2 == 1)
                    {
                        odd++;
                        id = i;
                    }
                    else
                        odd--;
                }
                else
                {
                    hm.put(chr[i], 1);
                    hmvisit.put(chr[i], true);
                    odd++;
                }
            }
    
            System.out.println(hm);
            
            if(odd > 1)
            {
                System.out.println("-1");
                System.exit(0);
            }
            
            for(i = 0; i < l; i++)
            {
                if(hmvisit.get(chr[i]))
                {
                    hmvisit.put(chr[i], false);
                    p[left++] = i;
                }
                else
                {
                    hmvisit.put(chr[i], true);
                    p[right--] = i;
                }
            }
            
            if(odd == 1)
                p[left] = id;
            
            for(i = 0; i < l; i++)
                System.out.print((p[i] + 1) + " ");
            
        }
    }
}
