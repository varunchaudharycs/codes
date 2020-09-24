//https://leetcode.com/problems/search-suggestions-system/
class lc_SearchSuggestionSystem {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> result = new ArrayList<>();
        int maxCount = 3;
        int totalProducts = products.length;
        int len = searchWord.length();
        
        Arrays.sort(products); // LEXICOGRAPHICAL RESULTS REQUIREMENT
                
        int start = 0, end = totalProducts;
        
        for(int i = 0; i < len; ++i) {
            
            List<String> resulti = new ArrayList<>();
            int count = 0;
            
            char toMatch = searchWord.charAt(i);
            
            for(int j = start; j < end; ++j) {
                
                if(i < products[j].length() && toMatch == products[j].charAt(i)) { // VALID RESULT
                    
                    if(count < maxCount) { // TOP 3 OR NOT
                        
                        if(count == 0) { start = j; }
                        count++;
                        resulti.add(products[j]);
                    }
                }
                else {
                    
                    if(count > 0) { // SHRINK SEARCH SPACE
                        
                        end = j;
                        break;
                    }
                }
            }
            
            if(count == 0) { end = -1; }
            
            result.add(resulti);
        }
        
        return result;
    }
    
    
    // LOGIC- Brute force
//     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
//         List<List<String>> result = new ArrayList<>();
//         int maxCount = 3;
//         int totalProducts = products.length;
//         int len = searchWord.length();
        
//         Arrays.sort(products);
        
//         for(int i = 0; i < len; ++i) {
            
//             List<String> resulti = new ArrayList<>();
//             int count = 0;
            
//             String toMatch = searchWord.substring(0, i + 1);
            
//             for(int j = 0; j < totalProducts; ++j) {
                
//                 if(i < products[j].length() && toMatch.equalsIgnoreCase(products[j].substring(0, i + 1))) {
                    
//                     if(count < maxCount) {
                        
//                         count++;
//                         resulti.add(products[j]);
//                     }
//                 }
//             }
            
//             result.add(resulti);
//         }
        
//         return result;
//     }
}