/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class SortRomanNames
{
    public static int romanToInt(String s) {
         int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}
       
        char c[]=s.toCharArray();
        int count=0;
       
       for(;count<=s.length()-1;count++){
           if(c[count]=='M') sum+=1000;
           if(c[count]=='D') sum+=500;
           if(c[count]=='C') sum+=100;
           if(c[count]=='L') sum+=50;
           if(c[count]=='X') sum+=10;
           if(c[count]=='V') sum+=5;
           if(c[count]=='I') sum+=1;
           
       }
       
       return sum;
    }
   
public static void main (String[] args) throws java.lang.Exception
{
// your code goes here

List<String> names = new ArrayList<String>() {{
  add("Varun X");
  add("Aryan X");
  add("Varun V");
}};

Collections.sort(names, new Comparator<String>() {
   
  public int compare(String a, String b) {
     
      String[] fields = a.split(" ");
      String af = fields[0];
      int al = romanToInt(fields[1]);
     
      fields = b.split(" ");
        String bf = fields[0];
      int bl = romanToInt(fields[1]);
     
      int diff = af.compareTo(bf);
     
      return (diff != 0) ? diff : al - bl;
     
  }
});

System.out.println(names);



}
}