// https://leetcode.com/problems/climbing-stairs/
// TIME - O(n)

class lc_climbingstairs {
    
    // DP - dp[i] = dp[i−1] + dp[i−2]
    public int climbStairs(int n) {
        
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i < n + 1; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
    
    // Additionally -> FIBONACCI FORMULA && BINET'S MATRIX MULTIPLICATION
    
    // FIBONACCI
//     public int climbStairs(int n) {
        
//         if(n == 0) return 0;
//         if(n == 1) return 1;
//         if(n == 2) return 2;
        
//         int first = 1, second = 2, fibo = 0;
        
//         for(int i = 3; i < n + 1; i++) {
            
//             fibo = first + second;
//             first = second;
//             second = fibo;
//         }
//         return fibo;
//     }
    
    
    // MEMOIZATION - store #ways in int[]
//     public int climbStairs(int n) {
        
//         lc_climbingstairs obj = new lc_climbingstairs();
//         int[] memo = new int[n + 1];
//         memo[0] = 1;
//         memo[1] = 1;
//         return obj.helper(0, n, memo);
//     }
    
//     public int helper(int pos, int n, int[] memo) {
        
//         if(memo[n - pos] != 0) return memo[n - pos];
        
//         int plusone = helper(pos + 1, n, memo);
//         int plustwo = helper(pos + 2, n, memo);
//         memo[n - pos] = plusone + plustwo;
//         return memo[n - pos];
//     }

    public static void main(String[] args) {

    	lc_climbingstairs obj = new lc_climbingstairs();
    	System.out.println(obj.climbStairs(45));
    }
}
