import java.io.*;

class cf_aprosperouslot
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(buf.readLine());
        int n = k / 2, i;

        if(k > 36)
        {
            System.out.print("-1");
            System.exit(0);
        }

        for(i = 1; i <= n; i++)
            System.out.print(8);

        if(k % 2 == 1)
            System.out.print(4);

    }
}