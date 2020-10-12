package leetcode;// https://leetcode.com/problems/set-matrix-zeroes/

class lc_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRowZero = false;
        
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < n; ++j) {
                
                if(matrix[i][j] == 0) { // store state of row & col in 1st respective cell
                    
                    if(i == 0 || j == 0) {
                        
                        if(i == 0) { firstRowZero = true; }
                        if(j == 0) { matrix[0][j] = 0; }
                    }
                    else {
                        
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        
        for(int i = 1; i < m; ++i) { // make rows 0, NOT FIRST
            
            if(matrix[i][0] == 0) {
                
                for(int j = 1; j < n; ++j) { matrix[i][j] = 0; }
            }
        }
        
        for(int i = 1; i < n; ++i) { // make cols 0, NOT FIRST
            
            if(matrix[0][i] == 0) {
                
                for(int j = 1; j < m; ++j) { matrix[j][i] = 0; }
            }
        }
        
        if(matrix[0][0] == 0) { // make 1st col 0
            
            for(int j = 1; j < m; ++j) { matrix[j][0] = 0; } 
        }
        
        if(firstRowZero) { // make 1st row 0
            
            for(int j = 0; j < n; ++j) { matrix[0][j] = 0; }      
        }
                
    }
}