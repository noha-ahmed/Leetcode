class Solution {
    private final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacficCheck = new boolean[n][m];
        boolean[][] atlanticCheck = new boolean[n][m];
        
//         for(int i = 0; i < n; i++){
//             pacficCheck[i][0] = true;
//             atlanticCheck[i][m - 1] = true;
//         }
            
//         for(int i = 0; i < m; i++){
//             pacficCheck[0][i] = true;
//             atlanticCheck[n - 1][i] = true;
//         }
        
        for(int i = 0; i < n; i++){
            check(heights, pacficCheck, i, 0);
            check(heights, atlanticCheck, i, m - 1);
        }
        
        for(int i = 0; i < m; i++){
            check(heights, pacficCheck, 0, i);
            check(heights, atlanticCheck, n - 1, i);
        }
        
        List<List<Integer>> sol = new LinkedList<>();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(pacficCheck[i][j] && atlanticCheck[i][j]){
                    ArrayList<Integer> list = new ArrayList<>(2);
                    list.add(i); list.add(j);
                    sol.add(list);
                }
        return sol;
    }
    
    private void check(int[][] heights, boolean[][] checkArr, int r, int c){
        checkArr[r][c] = true;
        for(int[] dir: DIRS){
            int i = r + dir[0];
            int j = c + dir[1];
            if(i < 0 || i == heights.length || j < 0 || j == heights[0].length)
                continue;
            if(!checkArr[i][j] && heights[i][j] >= heights[r][c])
                check(heights, checkArr, i, j);
        }
            
    }
}