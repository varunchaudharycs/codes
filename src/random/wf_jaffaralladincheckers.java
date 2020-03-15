import java.io.*;
import java.util.*;

class wf_jaffaralladincheckers {
    public int solution(String[] B) {
    
        char jafar = 'O';
        char aladdin = 'X';
        int maxPawns = 0; // answer
        for(int i = 0; i < B.length; i++) {
            // fetch row
            String value = B[i];
            // find jafar
            int jafarPosition = value.indexOf(jafar);
            if(jafarPosition > 0) {
                while(i >= 2) { // to be inside board
                    if(i >= 2) { // considering only 2 rows above recursively
                        String aladdinFirstRow = B[i-1];
                        String aladdinSecondRow = B[i-2];
                        // DIAGONAL LEFT
                        if(aladdinFirstRow.charAt(jafarPosition - 1) == aladdin // check if Alladin on left diagonal
                            && aladdinSecondRow.charAt(jafarPosition - 2) == '.') { // check if empty position to land
                            maxPawns++; // cut pawn
                            jafarPosition -= 2; // change column
                            i -= 2; // change row
                            continue;
                        }
                        // DIAGONAL RIGHT
                        if(aladdinFirstRow.charAt(jafarPosition + 1) == aladdin 
                            && aladdinSecondRow.charAt(jafarPosition + 2) == '.') {
                            maxPawns++;
                            jafarPosition += 2;
                            i -= 2;
                            continue;
                        }
                        else break;
                    }
                    else break;
                }
                break;
            }
        }
        return maxPawns;
    }
}
