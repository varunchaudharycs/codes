// https://leetcode.com/problems/design-browser-history/

import java.io.*;
import java.util.*;


class BrowserHistory {
    
    ArrayList<String> sites; // list of visited sites
    int currentPos; // current position in history

    public BrowserHistory(String homepage) {
        
        this.sites = new ArrayList<String>() {{add(homepage);}};
        this.currentPos = 0;
    }
    
    public void visit(String url) {
        
        // clearing forward history
        if(currentPos != sites.size() - 1) sites.subList(currentPos + 1, sites.size()).clear();
                
        currentPos++;
        sites.add(url);
        
        //System.out.println("Added " + url + " @ " + currentPos);                
    }
    
    public String back(int steps) {
        
        while(steps > 0 && currentPos >= 1) {
            steps--;
            currentPos--;
        }       
        
        //System.out.println("@ " + currentPos); 
        
        return sites.get(currentPos);
    }
    
    public String forward(int steps) {
        
         while(steps > 0 && currentPos < sites.size() - 1) {
            steps--;
            currentPos++;
        }  
        
        //System.out.println("@ " + currentPos); 
        
        return sites.get(currentPos);
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

// I/O

// Input:
// ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
// [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
// Output:
// [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

// Explanation:
// BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
// browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
// browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
// browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
// browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
// browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
// browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
// browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
// browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
// browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
// browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"