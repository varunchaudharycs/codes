import java.io.*;
import java.util.StringTokenizer;

public class cf_acompatiblepair
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(buf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long nrr[] = new long[n];
		long mrr[] = new long[m];
		
		int i = 0;
		long nmax = Long.MIN_VALUE, mmax = Long.MIN_VALUE, nextmax = Long.MIN_VALUE;
		
		st = new StringTokenizer(buf.readLine());
		
		while(st.hasMoreTokens())
		{
			nrr[i] = Long.parseLong(st.nextToken());
			
			if(nrr[i] > nextmax)
			{
				if(nrr[i] > nmax)
				{
					nextmax = nmax;
					nmax = nrr[i];
				}
				else
					nextmax = nrr[i];
			}
				
			i++;
		}
		
		st = new StringTokenizer(buf.readLine());
		i = 0;
		
		while(st.hasMoreTokens())
		{
			mrr[i] = Long.parseLong(st.nextToken());
			
			if(mrr[i] > mmax)
				mmax = mrr[i];
			
			i++;			
		}
		
		System.out.println(mmax * nextmax);
	}
}
