package random;
import java.io.*;
import java.util.*;

class HashMaps
{
    public static void main(String args[])throws IOException {
        
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, String> hm = new HashMap<>();
        
        hm.put("Chaudhary", "Varun");
        hm.put("Singh", "Varun");
        hm.put("Sehrawat", "Basu");
        
        //hm.remove("Singh");
        
        if(hm.containsKey("Chaudhary"))
            System.out.println(hm.get("Chaudhary"));
        
        for(Map.Entry k   : hm.entrySet())  {
            System.out.println("Key : " + k.getKey() + ", Value : " + k.getValue());
        }
        
        //hm.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
        
        System.out.println(hm);
    }
}