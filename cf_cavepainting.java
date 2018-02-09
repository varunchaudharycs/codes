import java.io.*;
import java.util.*;

public class cf_cavepainting
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(buf.readLine());
		
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		List<Long> l = new ArrayList<Long>();
		long rem; 
		
		if(k == 1)
		{
			System.out.println("Yes");
			System.exit(0);
		}
		
		if(n > 1 && k >= n)
		{
			System.out.println("No");
			System.exit(0);
		}
		
		for(int i = 1; i <= k; i++)
		{
			rem = n % i;
			
			if(l.contains(rem))
			{
				System.out.println("No");
				System.exit(0);
			}
			else
				l.add(rem);

		}
		
		System.out.println("Yes");
		

	}
}
