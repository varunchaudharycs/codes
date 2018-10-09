import java.io.*;
import java.util.*;
// http://codeforces.com/contest/1042/problem/B

public class cf_vitamins
{
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    
        long arr[], arr2[][], num, t, temp, len, sum = 0, count = 0, diff = Long.MAX_VALUE, rem = 0, ans = 0;
        int i, j, n, m, k;
        char ch, crr[];
        String s = "", srr[];
        StringTokenizer st;
        boolean flag = true;
        HashMap<Long, String> lshm = new HashMap<>();
        HashMap<Long, Long> llhm = new HashMap<>();
        ArrayList<Long> arrlist = new ArrayList<>();
        ArrayList<String> srrlist = new ArrayList<>();
    
        n = Integer.parseInt(buf.readLine());
        String vitamins = "";
        long cost = 0;
        HashMap<String, Long> slhm = new HashMap<>(); // to store the "VITAMIN" -> COST map(only stores lowest values)
    
        // Cheapest juice(s) containing all 3 vitamins(A,B,C) can be obtained from one the three cases-
        // 1 box - containing all 3 vitamins
        // 2 boxes - cumulatively
        // 3 boxes - with 1 vitamin each
    
        // reading input & finding cheapest price for all combos(ABC, A, B, C, AB, AC, BC)
        for (i = 0; i < n; i++) {
            st = new StringTokenizer(buf.readLine());
            cost = Long.parseLong(st.nextToken());
            vitamins = st.nextToken();
            // sorting vitamins combo so that ABC is same as BAC(to further store in hash map)
            crr = vitamins.toCharArray();
            Arrays.sort(crr);
            vitamins = new String(crr);
    
            // update map if vitamin combo doesn't exist OR existing value is greater than current
            if (!slhm.containsKey(vitamins) || (slhm.containsKey(vitamins) && cost < slhm.get(vitamins)))
                slhm.put(vitamins, cost);
        }
    
        long cheapest_1box = Long.MAX_VALUE;
        long cheapest_2box = Long.MAX_VALUE;
        long cheapest_3box = Long.MAX_VALUE;
        boolean found_1box = false;
        boolean found_2box = false;
        boolean found_3box = false;
    
        if (slhm.containsKey("ABC")) {
            cheapest_1box = slhm.get("ABC");
            found_1box = true;
        }
        if (slhm.containsKey("A") && slhm.containsKey("B") && slhm.containsKey("C")) {
            cheapest_3box = slhm.get("A") + slhm.get("B") + slhm.get("C");
            found_3box = true;
        }
        if (slhm.containsKey("AB") && slhm.containsKey("BC")) {
            cheapest_2box = slhm.get("AB") + slhm.get("BC");
            found_2box = true;
        }
        if (slhm.containsKey("BC") && slhm.containsKey("AC") && (cheapest_2box > slhm.get("BC") + slhm.get("AC"))) {
            cheapest_2box = slhm.get("BC") + slhm.get("AC");
            found_2box = true;
        }
        if (slhm.containsKey("AB") && slhm.containsKey("AC") && (cheapest_2box > slhm.get("AB") + slhm.get("AC"))) {
            cheapest_2box = slhm.get("AB") + slhm.get("AC");
            found_2box = true;
        }
        if (slhm.containsKey("A") && slhm.containsKey("BC") && (cheapest_2box > slhm.get("A") + slhm.get("BC"))) {
            cheapest_2box = slhm.get("A") + slhm.get("BC");
            found_2box = true;
        }
        if (slhm.containsKey("B") && slhm.containsKey("AC") && (cheapest_2box > slhm.get("B") + slhm.get("AC"))) {
            cheapest_2box = slhm.get("B") + slhm.get("AC");
            found_2box = true;
        }
        if (slhm.containsKey("C") && slhm.containsKey("AB") && (cheapest_2box > slhm.get("C") + slhm.get("AB"))) {
            cheapest_2box = slhm.get("C") + slhm.get("AB");
            found_2box = true;
        }
        if(found_1box || found_2box || found_3box)
        {
            if(cheapest_1box <= cheapest_2box && cheapest_1box <= cheapest_3box)
                System.out.println(cheapest_1box);
            else if(cheapest_2box <= cheapest_1box && cheapest_2box <= cheapest_3box)
                System.out.println(cheapest_2box);
            else if(cheapest_3box <= cheapest_1box && cheapest_3box <= cheapest_2box)
                    System.out.println(cheapest_3box);
        }
        else
        {
            System.out.println("-1");
        }
        
        /*Iterator it = slhm.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + "=" + pair.getValue());
        }
        System.out.println(found_1box + "=" + found_2box + "=" + found_3box);*/
    }
}
