class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n][target + 1];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return (int)solve(0, k, target, dp);
    }
    
    private long solve(int i, int k, int target, long[][] dp){
        if(dp[i][target] != -1 ) return dp[i][target];
        
        if( i == dp.length - 1){
            dp[i][target] = (k >= target) ? 1 : 0;
            return dp[i][target];
        }
        
        dp[i][target] = 0;
        for(int ik = 1; ik <= k && ik < target; ik++){
            dp[i][target] = (dp[i][target] + solve(i + 1, k, target - ik, dp)) % 1000000007;
        }
        return dp[i][target];   
    }
}