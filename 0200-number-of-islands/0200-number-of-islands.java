class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == '1'){
                    count++;
                    visit(grid, i, j);
                }
        }
        return count;
    }
    
    private void visit(char[][] grid, int i, int j){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != '1') return;
        
        grid[i][j] = '2';
        for(int[] dir : DIRS)
            visit(grid, i + dir[0], j + dir[1]);
        
    }
}