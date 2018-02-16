import java.io.*;
import java.math.*;

public class cf_aprosperouslot
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(buf.readLine());
		
		BigInteger n = new BigInteger("1");
		BigInteger base = new BigInteger("10");
		base = base.pow(k);
		base = base.subtract(n);
						
		n = n.multiply(base);
		
		System.out.println(n);
		
	}
}
