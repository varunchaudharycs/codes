package leetcode;

import java.io.*;
import java.util.*;

//https://leetcode.com/problems/rotting-oranges/

// TIME - O(r * c)
// SPACE - O(n)

class lc_rottingoranges {
    
    public int orangesRotting(int[][] grid) {
        
         int rows = grid.length;
        int cols = grid[0].length;
        int this_row;
        int this_col;
        int ele;
        int code= 0;
        int mins = 0;
        int left;
        int right;
        int up;
        int down;
        
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0; i < rows; ++i)
                for(int j = 0; j < cols; ++j) {
                    
                    code = i * cols + j;
                    if(grid[i][j] == 2) {
                        q.add(code);
                        hm.put(code, 0);
                    }
                    else if(grid[i][j] == 1){
                        hs.add(code);
                    }
                        
                    
                }
        
        while(!q.isEmpty()) {
            
            ele = q.poll();
            this_col = ele % cols;
            this_row = (ele - this_col) / cols;
            mins = hm.get(ele);
            
            left = this_col - 1 < 0 ? 0 : this_col - 1;
            right = this_col + 1 == cols  ? cols - 1 : this_col + 1;
            up = this_row - 1 < 0 ? 0 : this_row - 1;
            down = this_row + 1 == rows  ? rows - 1 : this_row + 1;
            
            if(grid[this_row][left] == 1) {
                grid[this_row][left] = 2;
                code = this_row * cols + left;
                hs.remove(code);
                q.add(code);
                hm.put(code, mins + 1);
            }
            if(grid[this_row][right] == 1) {
                grid[this_row][right] = 2;
                code = this_row * cols + right;
                q.add(code);
                hs.remove(code);
                hm.put(code, mins + 1);
            }
            if(grid[up][this_col] == 1) {
                grid[up][this_col] = 2;
                code = up * cols + this_col;
                hs.remove(code);
                q.add(code);
                hm.put(code, mins + 1);
            }
            if(grid[down][this_col] == 1) {
                grid[down][this_col] = 2;
                code = down * cols + this_col;
                q.add(code);
                hs.remove(code);
                hm.put(code, mins + 1);
            }
        
    
            
        }
        
        if(!hs.isEmpty())
            return -1;
        
        return mins;
    }

// TIME - O(r * c * mins)
// SPACE - O(1)
    
    
//     public int orangesRotting(int[][] grid) {
        
//         int r = grid.length;
//         int c = grid[0].length;
//         boolean isChanged;
//         boolean isAnyFresh;
//         int mins = 0;
        
//         int MIN_R = 0;
//         int MAX_R = r - 1;
//         int MIN_C = 0;
//         int MAX_C = c - 1;
        
//         int N_LEFT;
//         int N_RIGHT;
//         int N_UP;
//         int N_DOWN;
        
//         do {
//             mins++;
//             isChanged = false;
//             isAnyFresh = false;
            
//             ArrayList<Integer> x = new ArrayList<>();
//             ArrayList<Integer> y = new ArrayList<>();
        
//             for(int i = 0; i < r; ++i)
//                 for(int j = 0; j < c; ++j) {
                    
//                     N_UP = i - 1 < MIN_R ? i : i - 1;
//                     N_DOWN = i + 1 > MAX_R ? i : i + 1;
//                     N_LEFT = j - 1 < MIN_C ? j : j - 1;
//                     N_RIGHT = j + 1 > MAX_C ? j : j + 1;
                    
//                     if(grid[i][N_LEFT] == 2
//                       || grid[i][N_RIGHT] == 2
//                       || grid[N_UP][j] == 2
//                       || grid[N_DOWN][j] == 2){
                        
//                         if(grid[i][j] != 2 && grid[i][j] != 0) {
//                                 x.add(j);
//                                 y.add(i);
//                             }
//                     }
//                     else {
//                         if(grid[i][j] == 1)
//                             isAnyFresh = true;
//                     }
//                 }
            
//             for(int i = 0; i < x.size(); ++i) {
                
//                 grid[y.get(i)][x.get(i)] = 2;
//                 isChanged = true;                
//             }
            
//         }while(isChanged);
        
//         if(isAnyFresh)
//             return -1;
//         else
//             return mins - 1;
//     }
}
