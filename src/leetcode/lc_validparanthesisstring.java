// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
// TIME - O(n)
package leetcode;
import java.io.*;
import java.util.*;

class lc_validparanthesisstring {

    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            // STRING VARIABLE
            String s = buf.readLine();
            s = s.replaceAll("\"","");
            // "()" T , "(*)" T , "(*))" T , "*(()" F
            lc_validparanthesisstring obj = new lc_validparanthesisstring();
            boolean ans = obj.checkValidString(s);
            System.out.println(ans);
        }
    }
    // TRACK MAX & MIN OPEN "("
    // COMPENSATE FOR "*" being "(" OR ")" OR NULL
    public boolean checkValidString(String s) {

        int minOpen = 0, maxOpen = 0;

        for(char c : s.toCharArray()) {

            if(c == '(') {
                minOpen++;
                maxOpen++;
            }
            else if(c == ')') { // MATCHES w/ ")"
                minOpen--;
                maxOpen--;
            }
            else { // "*" CAN BE "(" OR ")"
                minOpen--;
                maxOpen++;
            }

            if(maxOpen < 0) return false; // INVALID, ")" w/o A MATCH

            minOpen = Math.max(minOpen, 0); // COMPENSATE FOR "*" BEING NULL
        }
        return (minOpen == 0) ? true : false;
    }
    // For ")" = Check for "(" before lifeline "*"
    // For each leftover "(", there should be a "*" ON ITS RIGHT(need to save position/indices)
//     public boolean checkValidString(String s) {

//         Stack<Integer> lifelineIdx = new Stack<>(); // STORE "(" INDICES
//         Stack<Integer> openIdx = new Stack<>(); // STORE "*" INDICES

//         for(int i = 0; i < s.length(); i++) {

//             char c = s.charAt(i);

//             if(c == '*')
//                 lifelineIdx.push(i);
//             else if(c == '(')
//                 openIdx.push(i);
//             else if(c == ')') {
//                 if(!openIdx.isEmpty()) // LOOK FOR "(" FIRST
//                   openIdx.pop();
//                 else if(!lifelineIdx.isEmpty()) // NONE? LIFELINE SAVES
//                   lifelineIdx.pop();
//                 else 
//                   return false; // INVALID
//             }
//         }
//         if(openIdx.isEmpty()) // NO OPEN "(" LEFT
//             return true; 
//         else { // FOR EACH LEFTOVER "(" => A "*" ON ITS RIGHT
//             while(!openIdx.isEmpty() && !lifelineIdx.isEmpty()) {
//                 if(openIdx.pop() > lifelineIdx.pop()) return false;
//             }
//             if(openIdx.isEmpty()) return true;
//             else return false; // INVALID
//         }
//    }
}

