// TIME - O(n)

import java.io.*;
import java.util.*;

class wf_linkedlistlength {
    public int solution(int[] A) {
        int i = 0; // header
        int len = 1; // length
        while(A[i] != -1) {
            i = A[i];
            len++;
        }
        return len;
    }
}
