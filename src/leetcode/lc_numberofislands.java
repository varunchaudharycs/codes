// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3302/
// TIME - O(r * c)
package leetcode;
class lc_numberofislands {
    // EVERY LAND CELL IS VISITED JUST ONCE
    // WHEN LAND IS FOUND, INC ISLANDS & SPREAD OUT IN 4 DIRECTIONS TO VISIT EVERY PIECE OF ISLAND
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        if(rows == 0) return 0; // CORNER CASE - EMPTY INPUT
        int cols = grid[0].length;
        if(cols == 0) return 0;
        boolean[][] visited = new boolean[rows][cols]; // (F-NOT VISITED, T-VISITED)
        int islands = 0;
        
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++) {
                
                if(!visited[i][j]) { // VISIT EVERY LAND CELL JUST ONCE
                    visited[i][j] = true;
                    if(grid[i][j] == '1') { // UNVISITED LAND FOUND (ADD TO ISLANDS)
                        islands++;
                        findWater(grid, visited, i, j);
                    }
                }
            }
        return islands;
    }
    // SPREAD IN 4 DIRECTIONS TO MARK EVERY LAND OF THIS ISLAND AS VISITED
    public void findWater(char[][] grid, boolean[][] visited, int r, int c) {
                
        if(grid[r][c] == '0') return; // FOUND WATER
        
        visited[r][c] = true; // MARKING VISITED
        
        if(c + 1 < grid[0].length && !visited[r][c+1]) findWater(grid, visited, r, c+1);
        if(c - 1 >= 0 && !visited[r][c-1]) findWater(grid, visited, r, c-1);
        if(r + 1 < grid.length && !visited[r+1][c]) findWater(grid, visited, r+1, c);
        if(r - 1 >= 0 && !visited[r-1][c]) findWater(grid, visited, r-1, c);
        
        return;
    }
}
