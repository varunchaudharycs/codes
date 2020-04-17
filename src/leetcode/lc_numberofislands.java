// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3302/
// TIME - O(r * c)
package leetcode;
class lc_numberofislands {
    // EVERY LAND CELL IS VISITED JUST ONCE & CONVERTED TO WATER
    // WHEN LAND IS FOUND, INC ISLANDS & SPREAD OUT IN 4 DIRECTIONS TO VISIT EVERY PIECE OF ISLAND 
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        if(rows == 0) return 0; // CORNER CASE - EMPTY INPUT
        int cols = grid[0].length;
        int islands = 0;
        
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                
                if(grid[i][j] == '1') { // UNVISITED LAND FOUND (ADD TO ISLANDS)
                    islands++;
                    findWater(grid, i, j);
                }
        return islands;
    }
    // SPREAD IN 4 DIRECTIONS TO MARK EVERY LAND OF THIS ISLAND AS VISITED
    public void findWater(char[][] grid, int r, int c) {
                
        if(c >= grid[0].length || c < 0 || r >= grid.length || r < 0 || grid[r][c] == '0') return; // FOUND WATER/BOUNDARY
        
        grid[r][c] = '0'; // MARKING VISITED
        
        findWater(grid, r, c+1);
        findWater(grid, r, c-1);
        findWater(grid, r+1, c);
        findWater(grid, r-1, c);
        
        return;
    }
}
