class Solution {
    public static final int[][] DIRECTIONS = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return rec(grid,i,j);
                }
            }
           
        }
        
        return 0;
    }
    
    public int rec(int[][] grid, int r, int c){
        int count = 4;
        grid[r][c] = 2;
        for(int[] dir : DIRECTIONS){
                int x = r + dir[0], y = c + dir[1];
                if( x < 0 || x > grid.length - 1 
                  || y < 0 || y > grid[0].length - 1) continue;
                if(grid[x][y] !=0 ) count--;
                if( grid[x][y] != 1) continue;    
               
                count+= rec(grid, x, y);
            }
        return count;
    
        
    }
}