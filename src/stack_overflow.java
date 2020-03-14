import java.io.*;
import java.util.*;

class stack_overflow {
    public static void main(String args[]) throws IOException {
        
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        String[] banned = {"m","q","e","l","c","i","z","j","g","t","w","v","h","p","d","b","a","r","x","n"};
        String paragraph = "j. t? T. z! R, v, F' x! L; l! W. M; S. y? r! n; O. q; I? h; w. t; y; X? y, p. k! k, h, J, r? w! U! V; j' u; R! z. s. T' k. P? M' I' j! y. P, T! e; X. w? M! Y, X; G; d, X? S' F, K? V, r' v, v, D, w, K! S? Q! N. n. V. v. t? t' x! u. j; m; n! F, V' Y! h; c! V, v, X' X' t? n; N' r; x. W' P? W; p' q, S' X, J; R. x; z; z! G, U; m. P; o. P! Y; I, I' l' J? h; Q; s? U, q, x. J, T! o. z, N, L; u, w! u, S. Y! V; S? y' E! O; p' X, w. p' M, h! R; t? K? Y' z? T? w; u. q' R, q, T. R? I. R! t, X, s? u; z. u, Y, n' U; m; p? g' P? y' v, o? K? R. Q? I! c, X, x. r' u! m' y. t. W; x! K? B. v; m, k; k' x; Z! U! p. U? Q, t, u' E' n? S' w. y; W, x? r. p! Y? q, Y. t, Z' V, S. q; W. Z, z? x! k, I. n; x? z; V? s! g, U; E' m! Z? y' x? V! t, F. Z? Y' S! z, Y' T? x? v? o! l; d; G' L. L, Z? q. w' r? U! E, H. C, Q! O? w! s? w' D. R, Y? u. w, N. Z? h. M? o, B, g, Z! t! l, W? z, o? z, q! O? u, N; o' o? V; S! z; q! q. o, t! q! w! Z? Z? w, F? O' N' U' p? r' J' L; S. M; g' V. i, P, v, v, f; W? L, y! i' z; L? w. v, s! P?";
        paragraph = paragraph.toLowerCase();
        HashSet<String> hs = new HashSet<>(Arrays.asList(banned));
    
        String words[] = paragraph.split("[,.;?! ']+");
        
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(String word : words) {
        
            if(!hs.contains(word)) {
                if(hm.containsKey(word))
                    hm.put(word, hm.get(word) + 1);
                else
                    hm.put(word, 1);
            }
        }
        
        
        for(Map.Entry e : hm.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    
        String most_freq = Collections.max(hm.entrySet(), Map.Entry.comparingByValue()).getKey();
    
        System.out.println(most_freq);
    }
}