import java.io.*;
import java.util.*;

class expandstring {

	public static void main(String[] args)throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		String s = buf.readLine();
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
				System.out.println(part);
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

		System.out.println(sb.reverse().toString());
	}
}