package leetcode;// https://leetcode.com/problems/spiral-matrix-ii/

class lc_SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        
        int limit = (int)Math.pow(n, 2);
        int[][] spiral = new int[n][n];
        int gap = 0;
        int val = 1;
        
        while(val <= limit) {
            
            int r1 = gap;
            int c1 = gap;
            
            int r2 = n - gap - 1;
            int c2 = n - gap - 1;
            
            for(int i = c1; i <= c2 && val <= limit; ++i) spiral[r1][i] = val++;
            
            for(int i = r1 + 1; i <= r2 && val <= limit; ++i) spiral[i][c2] = val++;
            
            for(int i = c2 - 1; i >= c1 && val <= limit; --i) spiral[r2][i] = val++;
            
            for(int i = r2 - 1; i > r1 && val <= limit; --i) spiral[i][c1] = val++;
            
            gap++;
        }
        
        return spiral;            
        
    }
}