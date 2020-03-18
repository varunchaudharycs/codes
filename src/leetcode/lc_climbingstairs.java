// https://leetcode.com/problems/climbing-stairs/
// TIME - n

class lc_climbingstairs {
    public int climbStairs(int n) {
        
        lc_climbingstairs obj = new lc_climbingstairs();
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        return obj.helper(0, n, memo);
    }
    
    public int helper(int pos, int n, int[] memo) {
        
        if(memo[n - pos] != 0) return memo[n - pos];
        
        int plusone = helper(pos + 1, n, memo);
        int plustwo = helper(pos + 2, n, memo);
        memo[n - pos] = plusone + plustwo;
        return memo[n - pos];
    }

    public static void main(String[] args) {

    	lc_climbingstairs obj = new lc_climbingstairs();
    	System.out.println(obj.climbStairs(45));
    }
}
