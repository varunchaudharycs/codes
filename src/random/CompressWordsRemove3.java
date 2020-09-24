import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CompressWordsRemove3
{
public static void main (String[] args) throws java.lang.Exception
{
// your code goes here

String s ="abbcccb"; //

char[] chars = s.toCharArray();

Stack<String> st = new Stack<>();

int len = s.length();

for(int i = 0; i < len;) {
   
   int count = 0;
   char ch = chars[i];
   boolean changed = false;
   
   while(i < len && chars[i] == ch) {
       
       changed = true;
       count++;
       i++;
   }
   
   if(!changed) ++i;
   
   count = count % 3;
   
   if(count != 0) {
       
       if(st.isEmpty()) { st.push(ch + String.valueOf(count)); continue;}
       
       String tos = st.peek();
       char c = tos.charAt(0);
       int f = Integer.parseInt(tos.substring(1, tos.length()));
       
       if(ch == c) {
           
           count += f;
           count %= 3;
           
           if(count != 0) st.push(ch + String.valueOf(count));
       }
   }
   else {
       
       continue;
   }
}

StringBuilder sb = new StringBuilder();

while(!st.isEmpty()) sb.insert(0, st.pop().charAt(0));

System.out.println(sb);
}
}
