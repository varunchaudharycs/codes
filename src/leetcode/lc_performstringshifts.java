// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

class lc_performstringshifts {

    public static void main(String[] args) throws IOException {
       
        lc_performstringshifts obj = new lc_performstringshifts();
        String s = "yisxjwry";
        int[][] shiftInfo = {{1,8},{1,4},{1,3},{1,6},{0,6},{1,4},{0,2},{0,1}};
        String ans = obj.stringShift(s, shiftInfo);
        System.out.println(ans);
    }
    // COUNT ALL SHIFTS -> Then, SHIFT STRING PARTS
    public String stringShift(String s, int[][] shift) {

        int len = s.length();
        int leftShifts = 0; // COUNTS #Left Shifts

        for(int[] row : shift) // COUNT TOTAL SHIFTS = SUM(LEFT) - SUM(RIGHT)
            leftShifts = (row[0] == 0) ? leftShifts + row[1] : leftShifts - row[1];

        leftShifts %= len; // CHECK FOR SHIFTS > LENGTH OF STRING
        if(leftShifts == 0) return s;
        else if(leftShifts > 0) return (s.substring(leftShifts, len) + s.substring(0, leftShifts)); // LEFT SHIFTING
        else return (s.substring(len - Math.abs(leftShifts), len) + s.substring(0, len - Math.abs(leftShifts))); // RIGHT SHIFTING
    }
}

