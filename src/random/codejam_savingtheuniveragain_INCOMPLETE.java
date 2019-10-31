package random;

import java.io.*;
import java.util.*;
// https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard

public class codejam_savingtheuniveragain_INCOMPLETE
{
    public static  char crr[];
    public static long len;
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        long t, d, hacks;
        int i;
        String s = "";
        String srr[];
        boolean possible = true;
        
        t = Long.parseLong(buf.readLine());
        
        for(i = 1; i <= t; i++)
        {
            possible = true;
            hacks = 0;
            s = buf.readLine();
            srr = s.split(" ");
            
            crr = srr[1].toCharArray();
            d = Long.parseLong(srr[0]);
            
            len = crr.length;
            
            if(calculateDamage() <= d)
                System.out.println("Case #" + i + ": " + 0);
            else
            {
                while(calculateDamage() > d && possible == true)
                {
                    possible = hackMove();
        
                    if(possible)
                        hacks++;
                }
    
                if(possible)
                    System.out.println("Case #" + i + ": " + hacks);
                else
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            
        }
        
    }
    
    public static long calculateDamage()
    {
        long damage = 0, beam = 1;
        
        for(int i = 0; i < len; i++)
        {
            if(crr[i] == 'C')
                beam *= 2;
            else
                damage += beam;
        }
        
        return damage;
        
    }
    
    public static boolean hackMove()
    {
        boolean changed = false;
        
        for(int i = 0; i < len - 1; i++)
        {
            if(crr[i] == 'C' && crr[i + 1] == 'S')
            {
                crr[i] = 'S';
                crr[i + 1] = 'C';
                changed = true;
                break;
            }
        }
        
        return changed;
    
    }
}
