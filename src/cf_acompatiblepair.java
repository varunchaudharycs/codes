// http://codeforces.com/problemset/problem/934/A
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
		
		int i, j, id = 0;
		long max = Long.MIN_VALUE;
		
		st = new StringTokenizer(buf.readLine());
		
		for(i = 0; st.hasMoreTokens(); i++)
			nrr[i] = Long.parseLong(st.nextToken());
			
		st = new StringTokenizer(buf.readLine());

		for(i = 0; st.hasMoreTokens(); i++)
			mrr[i] = Long.parseLong(st.nextToken());
			
		for(i = 0; i < n; i++)
			for(j = 0; j < m; j++)
				if(Math.max(max, nrr[i] * mrr[j]) != max)
				{
					max = nrr[i] * mrr[j];
					id = i;
				}
		
		max = Long.MIN_VALUE;
		
		for(i = 0; i < n; i++)
		{
			if (i == id)
				continue;
			
			for (j = 0; j < m; j++)
				max = Math.max(max, nrr[i] * mrr[j]);
		}
		
		System.out.println(max);
	}
}
