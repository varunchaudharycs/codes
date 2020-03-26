// https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3f56
// TIME - O(n), sorting - O(n logn)


import java.io.*;
import java.util.*;

class ks2020_allocation {
    
    public static void main(String[] args)throws IOException {
        
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(buf.readLine());
        int[] a;
        int n = 0, b = 0;
        String[] inp;
        int houses = 0;
        for(int j = 1; j <= t; j++) {
            
            houses = 0;
            inp = buf.readLine().split(" ");
            n = Integer.parseInt(inp[0]);
            b = Integer.parseInt(inp[1]);
            
            inp = buf.readLine().split(" ");
            a = new int[n];
            
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(a);
            
            for(int i = 0; i < n && b > 0; i++) {
                if(a[i] > b) break;
                b -= a[i];
                houses++;
            }
            
            System.out.println("Case " + "#" + j + ": " + houses);
        }
    }
}
