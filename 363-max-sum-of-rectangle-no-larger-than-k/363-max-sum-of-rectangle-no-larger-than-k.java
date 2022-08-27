class Solution {
    // Brute force
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int maxSum = Integer.MIN_VALUE;
        int[] prefixSum = new int[matrix.length];
        for(int l = 0; l < matrix[0].length; l++){
            Arrays.fill(prefixSum, 0);
            for(int r = l; r < matrix[0].length; r++){
                
                for(int row = 0; row < matrix.length; row++)
                    prefixSum[row]+= matrix[row][r];
                
                maxSum = Math.max(maxSum, getLargestSumCloseToK(prefixSum, k));
                
            }
        }
            
        return maxSum;                        
    }
    
    public int getLargestSumCloseToK(int[] arr, int k){
    int sum=0;
    TreeSet<Integer> set = new TreeSet<Integer>();
    int result=Integer.MIN_VALUE;
    set.add(0);
 
    for(int i=0; i<arr.length; i++){
        sum=sum+arr[i];
 
        Integer ceiling = set.ceiling(sum-k);
        if(ceiling!=null){
            result = Math.max(result, sum-ceiling);        
        }
 
        set.add(sum);
    }
 
    return result;
}
    
}