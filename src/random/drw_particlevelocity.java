// problem link
// TIME - O()

//package leetcode;
import java.io.*;
import java.util.*;

public class drw_particlevelocity {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int[] vel = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};

		System.out.println(findPeriods(vel));

		assert findPeriods(vel) == 5;

		System.out.println("SUCCESS");
	}

	// Logic
	public static int findPeriods(int[] velocity) {

		int periods = 0;
        int len = velocity.length;
        int i = 1, j = 0;

		while(i < len) {

			int currDiff = velocity[i] - velocity[i-1];
			
			int windowSize = 2;

			for(j = i + 1; j < len; ++j) // find window
				if(velocity[j] - velocity[j-1] == currDiff)
					windowSize++;
				else
					break;

			if(windowSize >=3) { // min 3 ele in window

				windowSize -= 2;
				periods += (windowSize * (windowSize + 1) / 2); // n*(n+1)/2
			}

			i = j;
		}


        return periods;
    }
}

// I/O -

// {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0} returns 5
