package codes;
import java.io.*;

public class cf_supermarket
{
	public static void main(String args[])throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		String srr[] = buf.readLine().split(" ");

		int n = Integer.parseInt(srr[0]);
		int m = Integer.parseInt(srr[1]);
		double price;

		srr = buf.readLine().split(" ");
		double cheapest = Double.parseDouble(srr[0])/Double.parseDouble(srr[1]);
		
		for(int i = 1; i < n; i++)
		{
			srr = buf.readLine().split(" ");
			price = Double.parseDouble(srr[0])/Double.parseDouble(srr[1]);

			if( price < cheapest )
				cheapest = price;
		}

		System.out.println(cheapest*m);

	}
}