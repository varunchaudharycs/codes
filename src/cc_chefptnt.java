// https://www.codechef.com/FEB18/problems/CHEFPTNT
import java.io.*;
import java.util.StringTokenizer;

class cc_chefptnt
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(buf.readLine());
		String s;
		long n, m, x, k, even, odd;
		int i;
		StringTokenizer st;
				
		while((t--) > 0)
		{
			even = odd = 0;
			st = new StringTokenizer(buf.readLine()); 
			n = Long.parseLong(st.nextToken()); // PATENTS
			m = Long.parseLong(st.nextToken()); // MONTHS
			x = Long.parseLong(st.nextToken()); // WORKERS OR PATENTS/MONTH
			k = Long.parseLong(st.nextToken()); // TOTAL WORKERS
			
			s = buf.readLine();
			
			// CHECK IF POSSIBLE - X (PATENTS/MONTH) * M (MONTHS) >= N (PATENTS)
			if((x * m) < n)
				System.out.println("no");
			else
			{
				// COUNTING ODD & EVEN MONTH WORKERS
				for(i = 0; i < k; i++)
				{
					if(s.charAt(i) == 'E')
						even++;
					else
						odd++;
				}
				// CALCULATING PATENTS THAT CAN BE RESOLVED EACH MONTH
				for(i = 1; i <= m && n > 0; i++)
				{
					// EVEN MONTHS
					if(i % 2 == 0 && even > 0)
					{
						// CHECK IF AVAILABLE WORKERS ARE < OR > X
						if(even > x)
						{
							n -= x;
							even -= x; // REDUCING AVAILABLE WORKERS
						}
						else
						{
							n -= even;
							even = 0;
						}
					}
					// ODD MONTHS
					else
						if(i % 2 == 1 && odd > 0)
						{
							// CHECK IF AVAILABLE WORKERS ARE < OR > X
							if(odd > x)
							{
								n -= x;
								odd -= x; // REDUCING AVAILABLE WORKERS
							}
							else
							{
								n -= odd;
								odd = 0;
							}
						}
				}
				// RESULT
				if(n <= 0)
					System.out.println("yes");
				else
					System.out.println("no");
				
			} // TEST CASE ENDS
			
		} // ALL TEST CASES OVER
		
	}
}