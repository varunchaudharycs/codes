import java.io.*;
import java.util.Arrays;

public class cc_chefchr
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(buf.readLine());
		int len, i, ways;
		String s;
		char pattern[];
		// SORTED MATCHING PATTERN
		char match[] = {'c','e','f','h'};
		
		while((t--) > 0)
		{
			ways = 0;
			s = buf.readLine();
			len = s.length();
			
			for(i = 0; i < len - 3; i++)
			{
				// SORTING EXTRACTED 4 LETTER SUBSTRING
				pattern = s.substring(i, i + 4).toCharArray();
				Arrays.sort(pattern);
				// CHECKING FOR A MATCH
				if(Arrays.equals(pattern, match))
					ways++;
			}
			// RESULT
			if(ways > 0)
				System.out.println("lovely " + ways);
			else
				System.out.println("normal");
			
		}

	}
}
