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
    // encodes string as alphabetCount, sorted alphabetically. eg. tea => a1e1t1
     public static String getCode(String s) {
        
        s = s.toLowerCase();
        int len = s.length();
        int[] alpha = new int[26];
        
        for(int i = 0; i < len; ++i) {
            
            alpha[s.charAt(i) - 'a']++;
        }
        
        StringBuilder code = new StringBuilder();
        
        for(int i = 0; i < 26; ++i) 
            if(alpha[i] != 0)
                code.append('a' + "" + i + alpha[i]);
        
        return code.toString();
    }
    // Encode all strings. Anagrams get same code/key in map of (code) -> (strings)
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> hm = new HashMap<>();
        int len = strs.length;
        List<List<String>> anagrams = new ArrayList<>();
        
        for(int i = 0; i < len; ++i) {
            
            hm.computeIfAbsent(getCode(strs[i]), k -> new ArrayList<String>()).add(strs[i]);
        }
        
        for(Map.Entry<String, List<String>> e : hm.entrySet())
            anagrams.add(e.getValue());
            
        return anagrams;
    }
    // (key : value) => (Sorted String : List of strings)
//     public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String, List<String>> anagrams = new HashMap<>();
//         int[] alphabets = new int[26];

//         for(String str : strs) {

//             Arrays.fill(alphabets, 0); // RESET ALPHABET COUNTS
//             String newStr = "";

//             for(Character c : str.toCharArray()) alphabets[c - 'a']++; // COUNT ALPHABETS

//             for(int i = 0; i < 26; i++) // PREPARE CODE
//                 if(alphabets[i] > 0)
//                     newStr += Character.toString((char)'a' + i) + alphabets[i];

//             if(!anagrams.containsKey(newStr)) // INSERT IN MAP
//                 anagrams.put(newStr, new ArrayList<String>());

//             anagrams.get(newStr).add(str);
//         }
//         return new ArrayList<>(anagrams.values()); // GENERATE OUTPUT FORMAT                 
//     }
}
