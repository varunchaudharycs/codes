// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/
// TIME - O(n * k logk), n- #strings, k- #characters in a string
package leetcode;
import java.io.*;
import java.util.*;

public class lc_groupanagrams {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        Solution obj = new Solution();

        String[] arr = {"",""}; //{"eat", "tea", "tan", "ate", "nat", "bat"}; 
        
        List<List<String>> list = obj.groupAnagrams(arr);

        for(List<String> l : list) {
            for(String s : l)
                System.out.print("word - " + s + ",");
        }
    }
    // (key : value) => (Sorted String : List of strings)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, String> anagrams = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(String str : strs) {

            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String newStr = new String(strArr); // SORT STRING

           if(anagrams.containsKey(newStr)) // INSERT IN MAP
                anagrams.put(newStr, anagrams.get(newStr) + "," + str);
            else
                anagrams.put(newStr, str);
        }

        for(Map.Entry<String, String> entry : anagrams.entrySet()) { // GENERATE OUTPUT FORMAT
            List<String> words = new ArrayList<>(Arrays.asList(entry.getValue().split(",", -1)));
            ans.add(words);
        }

        return ans;        
    }
}
