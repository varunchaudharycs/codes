import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// 

public class stack_overflow
{
    public static int getRegexMatchCount(Matcher matcher) {
        
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }
    
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
        
        String command = "abc:/b1c\\xy";
        Pattern COMMAND_PATTERN = Pattern.compile("([a-z]{1})([a-z0-9:]*?)(\\/)([a-z0-9]*?)(\\\\)([a-z]+?)");
        Matcher matcher = COMMAND_PATTERN.matcher(command);
    
        while (matcher.find()) {
            
            count++;
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
            System.out.println(matcher.group(5));
            System.out.println(matcher.group(6));
        }
        
        System.out.println("MATCH COUNT = " + count);
    }
}
