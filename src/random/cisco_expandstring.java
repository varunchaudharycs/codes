import java.io.*;
import java.util.*;

class cisco_expandstring {

	public static void main(String[] args)throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			System.out.println("Enter string");
			String s = buf.readLine();

			System.out.println(expand(s));
		}
	}

	// logic - maintain stack = answer at index 'i'. collect number and prev substring within "(" & ")". put local ans back on stack
	public static String expand(String s) {

		int len = s.length();

		StringBuilder sb = new StringBuilder();

		Stack<Character> chars = new Stack<>();

		for(int i = 0; i < len; ++i) {

			char ch = s.charAt(i);

			if(ch != '}') chars.push(ch);

			else {

				StringBuilder part = new StringBuilder();
				while(chars.peek() != '{') part.append(chars.pop());
				chars.pop(); // remove "{"
				int multiply = Integer.parseInt(part.reverse().toString());

				part.setLength(0);
				chars.pop(); // remove ")"
				while(chars.peek() != '(') part.append(chars.pop());
				chars.pop(); // remove "("
				String str = part.reverse().toString();

				while(multiply != 0) {

					for(char ch2 : str.toCharArray()) chars.push(ch2);
					multiply--;
				}
			}
		}

		while(!chars.isEmpty()) sb.append(chars.pop());

		return sb.reverse().toString();
	}
}

// I/O -

// (a){2}
// aa

// (ab(c){2}d){3}
// abccdabccdabccd
