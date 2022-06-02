class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if( n == m){
            for(int pivot = 0 ; pivot < n - 1 ; pivot++){
            for(int i = pivot + 1; i < n; i++){
                int temp = matrix[pivot][i];
                matrix[pivot][i] = matrix[i][pivot];
                matrix[i][pivot] = temp;
            }
        }
        }
        else{
            int[][] newMatrix = new int[m][n];
            for(int i = 0 ; i < m ; i++){
                for(int j = 0; j < n ; j++){
                    newMatrix[i][j] = matrix[j][i];
                }
            }
            matrix = newMatrix;
        }
        
        return matrix;
    }
}