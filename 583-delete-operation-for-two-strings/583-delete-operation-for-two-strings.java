class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1]; 
        
        for(int i = 0; i  < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if( i == 0 || j == 0 )
                    dp[i][j] = i + j;
                else if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}