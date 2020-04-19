// https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc8/00000000002d83bf
// TIME - O(n)

//package random;
import java.io.*;
import java.util.*;

public class ks2020_busroutes {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int test = 1; test <= t; test++ ) {

            String[] srr = buf.readLine().split(" ");
            int n = Integer.parseInt(srr[0]);
            long d = Long.parseLong(srr[1]);
            srr = buf.readLine().split(" ");
            long[] routes = new long[n];
            for(int i = 0; i < n; i++) routes[i] = Long.parseLong(srr[i]);

            long departure = d;
            for(int i = n - 1; i >= 0; i--) {
                departure -= (departure % routes[i]);
            }
           
            System.out.println("Case #" + test + ": " + departure);
        }
    }

    
}
