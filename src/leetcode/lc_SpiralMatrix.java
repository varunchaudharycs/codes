package leetcode;// https://leetcode.com/problems/spiral-matrix/
import java.io.*;
import java.util.*;
class lc_SpiralMatrix {

    public static boolean isValid(int idx, int size) {
        
        return (idx >= 0 && idx < size);
    }
        
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> spiral = new LinkedList<>();
        int gap = 0;
        
        int m = matrix.length;
        
        if(m == 0) return spiral;
        
        int n = matrix[0].length;
        
        int mid = m / 2;
        boolean[][] visited = new boolean[m][n];
        
        while(gap <= mid) {
            
            int c1 = gap;
            int r1 = gap;
            
            int c2 = n - gap - 1;
            int r2 = m - gap - 1;
            
            if(!(isValid(c1, n) && isValid(c2, n) && isValid(r1, m) && isValid(r2, m))) break;
            
            for(int i = c1; i <= c2 && isValid(i, n); ++i) { // top left TO top right
                
                if(!visited[r1][i]) {
                    
                    spiral.add(matrix[r1][i]);
                    visited[r1][i] = true;
                }
            }
            
            for(int i = r1 + 1; i <= r2 && isValid(i, m); ++i) { // top right TO bottom right
                
                if(!visited[i][c2]) {
                    
                    spiral.add(matrix[i][c2]);
                    visited[i][c2] = true;
                }
            }
            
            for(int i = c2 - 1; i >= c1 && isValid(i, n); --i) { // bottom right TO bottom left
                
                if(!visited[r2][i]) {
                    
                    spiral.add(matrix[r2][i]);
                    visited[r2][i] = true;
                }
            }
            
            for(int i = r2 - 1; i > r1 && isValid(i, m); --i) { // bottom left TO top left
                
                if(!visited[i][c1]) {
                    
                    spiral.add(matrix[i][c1]);
                    visited[i][c1] = true;
                }
            }
            
            gap++;
        }
                
        return spiral;        
    }
}