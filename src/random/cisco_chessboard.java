import java.io.*;
import java.util.*;

class cisco {

	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {


			String inp = "7  10";
			System.out.println(Arrays.toString(inp.trim().split(" ")));



			int n;
			String s;
			StringTokenizer st;

			n = Integer.parseInt(buf.readLine());

			getAnswer(n);

		}
	}

	public static void getAnswer(int n) {

		// Logic- Generate the first 2 lines. Repeat them to complete board
		StringBuilder line1 = new StringBuilder();
		StringBuilder line2 = new StringBuilder();

		boolean white = true;

		for(int i = 0; i < n; ++i) { // first line

			if(white) line1.append("W ");
			else line1.append("B ");

			white = !white;
		}

		white = false;

		for(int i = 0; i < n; ++i) { // second line

			if(white) line2.append("W ");
			else line2.append("B ");

			white = !white;
		}

		for(int i = 1; i <= n; ++i) { // chess board

			if((i & 1) == 1) System.out.println(line1);
			else System.out.println(line2);

		}
	}
}