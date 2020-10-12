// https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc8/00000000002d83dc
// TIME - O(n)

package random;
import java.io.*;
import java.util.*;

public class ks2020_robotpathdecoding {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int test = 1; test <= t; test++ ) {

            String s = buf.readLine();
            long len = s.length();

            int row = 1, col = 1;
            long down = 0, right = 0;
            Stack<Integer> times = new Stack<Integer>(){{
                push(1);
            }};
            for(int i = 0; i < len; i++) {

                char c = s.charAt(i);
                if(c == 'N') down -= times.peek();
                else if(c == 'S') down += times.peek();
                else if(c == 'E') right += times.peek();
                else if(c == 'W') right -= times.peek();
                else if(Character.isDigit(c)) times.push(times.peek() * Character.getNumericValue(c));
                else if(c == '(') continue;
                else if(c == ')') times.pop();
            }

            if(down >= 0){
                down %= (long)Math.pow(10, 9);
                row += down;
            }
            else {
                down = (long)Math.abs(down) % (long)Math.pow(10, 9);
                row += (long)Math.pow(10, 9) - down;
            }
            if(right >= 0){
                right %= (long)Math.pow(10, 9);
                col += right;
            }
            else {
                right = (long)Math.abs(right) % (long)Math.pow(10, 9);
                col += (long)Math.pow(10, 9) - right;
            }

            System.out.printf("Case #%d: %d %d\n", test, col, row);
        }
    }

    
}
