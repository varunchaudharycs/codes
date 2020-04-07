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
    // (key : value) => (alphabet#Count : List of strings)
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> anagrams = new HashMap<>();
        int[] alphabets = new int[26];

        for(String str : strs) {

            Arrays.fill(alphabets, 0); // RESET ALPHABET COUNTS
            String newStr = "";

            for(Character c : str.toCharArray()) alphabets[c - 'a']++; // COUNT ALPHABETS

            for(int i = 0; i < 26; i++) // PREPARE CODE
                if(alphabets[i] > 0)
                    newStr += Character.toString((char)'a' + i) + alphabets[i];

            if(!anagrams.containsKey(newStr)) // INSERT IN MAP
                 anagrams.put(newStr, new ArrayList<String>());
        }
        return new ArrayList<>(anagrams.values()); // GENERATE OUTPUT FORMAT              
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
