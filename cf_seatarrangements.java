package codes;
import java.io.*;

public class cf_seatarrangements
{
	public static void main(String args[])throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		String srr[] = buf.readLine().split(" ");
		int n = Integer.parseInt(srr[0]);
		int m = Integer.parseInt(srr[1]);
		int k = Integer.parseInt(srr[2]);
		int i, j, z, ways = 0;
		srr = new String[n];

		for(i = 0; i < n; i++)
			srr[i] = buf.readLine();
		
		// ROW
		for(i = 0; i < n; i++)
		{
			// COLUMN
			for(j = 0; j < m; j++)
			{
				// CHECK EMPTY SEAT
				if(srr[i].charAt(j) == '.')
				{
					// ROW CHECK
					// CHECK IF ALREADY TRAVERSED
					if(j == 0 || (j != 0 && srr[i].charAt(j - 1) != '.'))
					{
						// CONSECUTIVE EMPTY SEATS IN ROW - FORMULA = EMPTY SEATS - K + 1
						for(z = 1; (j + z) < m && srr[i].charAt(j + z) == '.'; z++);
						
						// ADD TO ANSWER IF EMPTY SEATS >= K
						if(z >= k)
							ways += z - k + 1;
					}
					// COLUMN CHECK
					// CHECK IF ALREADY TRAVERSED & AVOID IF K = 1
					if(k > 1 && (i == 0 || (i != 0 && srr[i - 1].charAt(j) != '.')))
					{
						// CONSECUTIVE EMPTY SEATS IN COLUMN - FORMULA = EMPTY SEATS - K + 1
						for(z = 1; (i + z) < n && srr[i + z].charAt(j) == '.'; z++);
						
						// ADD TO ANSWER IF EMPTY SEATS >= K
						if(z >= k)
							ways += z - k + 1;
					}
				}
			}
		}
			
		System.out.println(ways); 
		
	}
}