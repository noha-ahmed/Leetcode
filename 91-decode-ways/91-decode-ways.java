class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);
    }
    
    private int solve(int index,String s, int[] dp){
        
        if( index == s.length() ) return 1;
        if( dp[index] != -1 ) return dp[index];
        
        dp[index] = 0;
        int num = s.charAt(index) - '0';
        if(num > 0){
            dp[index]+= solve(index + 1, s, dp);
            if( index < s.length() - 1){
                num = num*10 + (s.charAt(index + 1) - '0');
                if( num <= 26)
                    dp[index] += solve(index + 2, s, dp);
            }
            
        }
        return dp[index];
        
    }
}