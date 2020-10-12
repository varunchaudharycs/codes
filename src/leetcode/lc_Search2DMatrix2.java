package leetcode;

//https://leetcode.com/problems/search-a-2d-matrix-ii/
class lc_Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        boolean isFound = false;
        int n = matrix.length;
        
        if(n == 0) { return isFound; }
        
        int m = matrix[0].length;
        
        if(m == 0) { return isFound; }
        
        int i = n - 1, j = 0;
        
        
        while((i >= 0 && i < n) && (j >= 0 && j < m)) {
            
            if(target == matrix[i][j]) {
                isFound = true;
                break;
            }
            else if(target > matrix[i][j]) { ++j; }
            else { --i; };
        }
        
        return isFound;
    }
}