package leetcode;// https://leetcode.com/contest/weekly-contest-185/problems/reformat-the-string/
// TIME - O(2n)

//package random;
import java.io.*;
import java.util.*;

public class lc_reformatthestring {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        lc_reformatthestring obj = new lc_reformatthestring();
        while(true) {

            String s = buf.readLine();
            String ans = obj.reformat(s);
            System.out.println(ans);
        }

    }
    // COLLECT NUMBERS & LETTERS IN SEPARATE STACK
    // POP ALTERNATIVELY - START WITH WHICHEVER IS GREATER
    // IF COUNT DIFFERENCE > 1 => NOT POSSIBLE!
    public String reformat(String s) {

        int len = s.length();

        Stack<Character> numbers = new Stack<>();
        Stack<Character> alphabets = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) numbers.push((char)ch);
            else alphabets.push((char)ch);
        }

        if(Math.abs(numbers.size() - alphabets.size()) > 1) return ""; // NOT POSSIBLE
        String perm = "";
        if(numbers.size() >= alphabets.size()) { // DECIDING WHICH ONE TO START WITH BASED ON WHO'S MORE FREQUENT
            while(!alphabets.isEmpty()) perm += String.valueOf((char)numbers.pop()) + String.valueOf(alphabets.pop());
            if(!numbers.isEmpty()) perm += (char)numbers.pop();
        }
        else {
            while(!numbers.isEmpty()) perm += String.valueOf(alphabets.pop()) + String.valueOf(numbers.pop());
            perm += (char)alphabets.pop();
        }

        return perm;
    }

    
}
