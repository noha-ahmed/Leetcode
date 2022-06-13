class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] mem = initMem(triangle);
        minimumTotalRec(triangle, mem, 0, 0);
        return mem[0][0];
    }
    
    private int[][] initMem(List<List<Integer>> triangle){
        int[][] mem = new int[triangle.size()][];
        for(int i = 0; i < mem.length - 1; i++){
            mem[i] = new int[i + 1];
            for(int j = 0; j < mem[i].length; j++)
                mem[i][j] = Integer.MIN_VALUE;
        }
        
        int lastRowIndex = mem.length - 1;
        mem[lastRowIndex] = new int[mem.length];
        List<Integer> lastRow = triangle.get(lastRowIndex);
        for(int i  = 0; i < mem[lastRowIndex].length; i++){
            mem[lastRowIndex][i] = lastRow.get(i); 
        }
        return mem;
    }
    
    private void minimumTotalRec(List<List<Integer>> triangle, int[][] cost, int r , int c){
        if( r == triangle.size() - 1 ) return;
        
        if( cost[r + 1][c] == Integer.MIN_VALUE)
            minimumTotalRec(triangle, cost, r + 1, c);
        
         if( cost[r + 1][c + 1] == Integer.MIN_VALUE)
            minimumTotalRec(triangle, cost, r + 1, c + 1);
        
        cost[r][c] = Math.min(cost[r+1][c], cost[r+1][c+1]) + triangle.get(r).get(c);
    }
    
}