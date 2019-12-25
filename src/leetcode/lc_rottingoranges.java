package leetcode;

import java.io.*;
import java.util.*;

//https://leetcode.com/problems/rotting-oranges/

// TIME - O(r * c)
// SPACE - O(1)

class lc_rottingoranges {

    public int orangesRotting(int[][] grid) {
        
        int r = grid.length;
        int c = grid[0].length;
        boolean isChanged;
        boolean isAnyFresh;
        int mins = 0;
        
        int MIN_R = 0;
        int MAX_R = r - 1;
        int MIN_C = 0;
        int MAX_C = c - 1;
        
        int N_LEFT;
        int N_RIGHT;
        int N_UP;
        int N_DOWN;
        
        do {
            mins++;
            isChanged = false;
            isAnyFresh = false;
            
            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();
        
            for(int i = 0; i < r; ++i)
                for(int j = 0; j < c; ++j) {
                    
                    N_UP = i - 1 < MIN_R ? i : i - 1;
                    N_DOWN = i + 1 > MAX_R ? i : i + 1;
                    N_LEFT = j - 1 < MIN_C ? j : j - 1;
                    N_RIGHT = j + 1 > MAX_C ? j : j + 1;
                    
                    if(grid[i][N_LEFT] == 2
                      || grid[i][N_RIGHT] == 2
                      || grid[N_UP][j] == 2
                      || grid[N_DOWN][j] == 2){
                        
                        if(grid[i][j] != 2 && grid[i][j] != 0) {
                                x.add(j);
                                y.add(i);
                            }
                    }
                    else {
                        if(grid[i][j] == 1)
                            isAnyFresh = true;
                    }
                }
            
            for(int i = 0; i < x.size(); ++i) {
                
                grid[y.get(i)][x.get(i)] = 2;
                isChanged = true;                
            }
            
        }while(isChanged);
        
        if(isAnyFresh)
            return -1;
        else
            return mins - 1;
    }
}
