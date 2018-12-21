import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
// https://codeforces.com/contest/1084/problem/B

public class cf_kvassandthefairnut
{
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        int i, j, n, least_vol = Integer.MAX_VALUE;
        int[] arr;
        long s, sum = 0;
        String srr[];
        StringTokenizer st;
        
        st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Long.parseLong(st.nextToken());
        srr = buf.readLine().split(" ");
        arr = Arrays.stream(srr).mapToInt(Integer::parseInt).toArray();
        for(i = 0; i < n; i++)
            sum += arr[i];
        
        if(n == 1)
            least_vol = arr[0];
        else
            for(i = 0; i < n; i++)
                if(arr[i] < least_vol)
                    least_vol = arr[i];
        
        // not enough water
        if(s > sum) {
            System.out.println("-1");
            System.exit(0);
        }
        // first try - keep taking out water from every keg unless each keg has volume = least_vol
        // second try - keep taking out a litre from each keg unless the glass fills or there's no water left
        // first try
        for(i = n - 1; i >= 0; i--) s -= (arr[i] - least_vol);
        // second try
        if(s > 0) least_vol -= Math.ceil((double)s/n);
        System.out.println(least_vol);
    }
}
