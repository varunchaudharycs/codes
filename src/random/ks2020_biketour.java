// https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc8/00000000002d82e6
// TIME - O(n)

package random;
import java.io.*;
import java.util.*;

public class ks2020_biketour {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int test = 1; test <= t; test++ ) {

            int ans = 0;
            int n = Integer.parseInt(buf.readLine());
            String[] srr = buf.readLine().split(" ");
            int[] checkpoints = new int[n];
            for(int i = 0; i < n; i++) checkpoints[i] = Integer.parseInt(srr[i]);

            for(int i = 0; i < n; i++)
                if(i != 0 && i != n - 1 
                   && checkpoints[i] > checkpoints[i-1] && checkpoints[i] > checkpoints[i+1])
                    ans++;
           
            System.out.println("Case #" + test + ": " + ans);
        }
    }

    
}
