import java.io.*;

public class cf_perfectnumber
{
	public static void main(String args[])throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(buf.readLine());
		int i, sum, num;

		for(i = 0; ; i++)
		{
			sum = 0;
			num = i;
						
			while(num != 0)
			{
				sum += num%10;
				num/=10;
			}

			if(sum == 10)
				n--;

			if(n == 0)
			{
				System.out.println(i);
				break;
			}
		}
	}
}

// Test