class Solution {
    private class Cell{
        int x;
        int y;
        Cell(int i, int j){
            x = i;
            y = j;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length,  m = mat[0].length;
        int[][] distance = new int[mat.length][mat[0].length];
        
        final int INF = Integer.MAX_VALUE;
        for(int i = 0; i < distance.length; i++)
            Arrays.fill(distance[i], INF);
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(mat[i][j] == 0){
                    queue.add(new Cell(i, j));
                    distance[i][j] = 0;
                }
        
        final int[][] DIR = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        while( !queue.isEmpty() ){
            Cell cell = queue.poll();
            for(int[] dir: DIR){
                int i = cell.x + dir[0];
                int j = cell.y + dir[1];
                
                if( i >= 0 && i < n && j >= 0 && j < m && distance[i][j] == INF){
                     distance[i][j] = distance[cell.x][cell.y] + 1;
                    queue.add(new Cell(i, j));
                }
                   
            }
        }
        
        return distance;
        
        
    }
}