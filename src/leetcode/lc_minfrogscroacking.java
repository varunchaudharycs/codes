// https://leetcode.com/contest/weekly-contest-185/problems/minimum-number-of-frogs-croaking/
// TIME - O(n)

package leetcode;
import java.io.*;
import java.util.*;

public class lc_minfrogscroacking {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        lc_minfrogscroacking obj = new lc_minfrogscroacking();
        while(true) {

            String s = buf.readLine(); // crcoakroak
            int ans = obj.minNumberOfFrogs(s);
            System.out.println(ans);
        }

    }
    // KEEP TRACK OF NUMBER OF FROGS AT EACH CHAR AT "CROAK"
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int len = croakOfFrogs.length();
        int frogs = 0;
        if(len == 0) return frogs;
        frogs++;

        HashMap<Character, Integer> croak = new HashMap<>() {{ // CHAR POSITION
            put('c', 1);
            put('r', 2);
            put('o', 3);
            put('a', 4);
            put('k', 5);
        }};
        HashMap<Integer, Integer> stages = new HashMap<>() {{ // NUM OF FROGS AT EACH CHAR
            put(0, 1);
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
        }};
        for(char ch : croakOfFrogs.toCharArray()) {
            int stage = croak.get(ch);
            if(stages.get(stage-1) > 0) { // FROG EXISTS
                stages.put(stage-1, stages.get(stage-1) - 1);
                if(stage == 5) stages.put(0, stages.get(0) + 1);
                else stages.put(stage, stages.get(stage) + 1);
            }
            else { // NEW FROG NEEDED
                if(stage != 1) return -1; // INVALID
                stages.put(stage, stages.get(stage) + 1);
                frogs++;
            }
        }
        if(stages.get(1) + stages.get(2) + stages.get(3)+ stages.get(4) > 0) return -1; // INVALID
        return frogs;
    }

    
}
