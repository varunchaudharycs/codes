package codes;
import java.io.*;
import java.util.*;

public class cf_cloningtoys
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(buf.readLine());
		
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		
		if((y == 1 && x > 0) || (y > 1 && x == 0) || y == 0 || (x - (y - 1)) < 0 || (x - (y - 1))%2 == 1)
			System.out.println("No");
		else
			System.out.println("Yes");

	}
}