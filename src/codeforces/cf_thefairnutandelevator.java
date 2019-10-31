package codeforces;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
// https://codeforces.com/contest/1084/problem/A

public class cf_thefairnutandelevator
{
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        int arr[], i, n;
        long totalUnits = 0;
        String srr[];
        
        n = Integer.parseInt(buf.readLine());
        srr = buf.readLine().split(" ");
        arr = Arrays.stream(srr).mapToInt(Integer::parseInt).toArray();
        
        // Irrespective of x or no. of residents ...
        // SOLUTION - the elevator has to go to floor "i" and back to ground floor => (2 * i)
        // iterate over every floor
        // apply solution (2 * i) for both coming and going and for each resident => Resident count * 2 * 2i
        for(i = 0; i < n; i++) {
            totalUnits += (arr[i] * 4 * i);
        }
        System.out.println(totalUnits);
    }
}
