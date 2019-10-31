package codechef;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
// https://www.codechef.com/NCC2018/problems/NCC1803

class cc_ncc1803_INCOMPLETE
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(buf.readLine());
        int n, a, b;
        StringTokenizer st;
        List<Integer> arr;
        List<Integer> rem;
        ListIterator i, j;
        boolean sagarover, start;
        
        while((t--) > 0)
        {
            start = false;
            sagarover = false;
            n = Integer.parseInt(buf.readLine());
            st = new StringTokenizer(buf.readLine());
            arr = new ArrayList<>();
            rem = new ArrayList<>();
    
            while(st.hasMoreTokens())
                arr.add(new Integer(st.nextToken()));
            
            
            i = arr.listIterator();
            
            while(i.hasNext())
            {
                a = (int)i.next();
                j = i;
                
                while(j.hasNext())
                {
                    b = (int)j.next();
                    
                    if(findDivisors(a * b))
                    {
                        if(!start)
                            start = true;
                        
                        rem.add(a);
                        rem.add(b);
                        
                        arr.removeAll(rem);
                        
                        rem.clear();
                        
                        if(sagarover)
                            sagarover = false;
                        else
                            sagarover = true;
                        
                        break;
                    }
                }
                
            }
            
            if(start && sagarover)
                System.out.println("Sagar");
            else
                System.out.println("Shivam");
            
        }
    }
    
    public static boolean findDivisors(int num)
    {
        int divisors = 2;
        
        for (int i = 2; i <= num/2; i++)
        {
            if (num % i == 0)
            {
                if (divisors == 2)
                    divisors++;
                else
                {
                    divisors++;
                    break;
                }
            }
        }
        
        if(divisors == 3)
            return true;
        else
            return false;
        
    }
    
}
