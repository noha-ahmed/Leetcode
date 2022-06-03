class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        prefixSum = new int[n+1][m+1];
        
        prefixSum[n-1][m-1] = matrix[n-1][m-1];
        for(int row = n - 2; row >= 0; row--)
                prefixSum[row][m-1] = matrix[row][m-1] + prefixSum[row + 1][m-1];
        
        for(int col = m - 2; col >= 0; col--)
                prefixSum[n - 1][col] = matrix[n - 1][col] + prefixSum[n - 1][col + 1];
        
        for(int col = m - 2; col >= 0; col--)
            for(int row = n - 2; row >= 0; row--)
                prefixSum[row][col] = matrix[row][col] + prefixSum[row][col+1]
                    + prefixSum[row+1][col] - prefixSum[row+1][col+1];
               
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row1][col1] - prefixSum[row1][col2+1] 
            - prefixSum[row2+1][col1] + prefixSum[row2 + 1][col2 + 1];
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */