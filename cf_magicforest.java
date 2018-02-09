import java.io.*;

public class cf_magicforest
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(buf.readLine());
		
		int i, j, k, ans = 0;
		
		for(i = 1; i <=n; i++)
			for(j = i; j <=n; j++)
			{
				// IF A XOR B XOR C = 0 <=> A XOR B = C
				k = i ^ j;
				
				if((i + j > k) && k > j && k <=n)
					ans++;
			}
			
		System.out.println(ans);
	}
}
