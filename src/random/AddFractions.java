/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String[] fractions = {"2/6+2/6", "7/10+13/10"}; // 2/3, 2/1
		
		String[] res = new String[fractions.length];
		int idx = 0;
		
		for (String fraction : fractions) {
		    String[] parts = fraction.split("\\+");
		    String[] part1 = parts[0].split("\\/");
		    String[] part2 = parts[1].split("\\/");
		    
		    int a = Integer.parseInt(part1[0]);
		    int b = Integer.parseInt(part1[1]);
		    int x = Integer.parseInt(part2[0]);
		    int y = Integer.parseInt(part2[1]);
		    
		    res[idx++] = addFraction(a, b, x, y);
		}
		for (String s : res) {
		    System.out.println(s);
		}
	}
	
	static int gcd(int a, int b) {  
        if (a == 0)  
            return b;  
        return gcd(b%a, a);  
    }  
  
    static String lowest(int den3, int num3) {  
        int common_factor = gcd(num3,den3);  
        den3 = den3/common_factor;  
        num3 = num3/common_factor; 
        return num3 + "/" + den3;
    }   
  
    static String addFraction(int num1, int den1, int num2, int den2) {  
        int den3 = gcd(den1,den2);  
        den3 = (den1*den2) / den3;
        int num3 = (num1)*(den3/den1) + (num2)*(den3/den2);  
        return lowest(den3,num3);  
    }  
}
