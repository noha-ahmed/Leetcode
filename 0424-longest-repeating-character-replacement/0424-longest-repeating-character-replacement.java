class Solution {
    public int characterReplacement(String s, int k) {
        if( k == s.length() ) return k;
        int maxMatching = 0;
        int[] freq = new int[26];
        for(int i = 0; i <= k; i++){
            freq[s.charAt(i) - 'A']++;
            maxMatching = Math.max(maxMatching, freq[s.charAt(i) - 'A']);
        }
        
        int l = 0, r = k;
        int ans = k + 1;
        int windowLength = k + 1;
        while( r < s.length()){
            int nonMatching = windowLength - maxMatching;
            if( nonMatching <= k ){
                ans = Math.max(ans, maxMatching + nonMatching);
                r++;
                if(r == s.length()) break;
                freq[s.charAt(r) - 'A']++;
                maxMatching = Math.max(maxMatching, freq[s.charAt(r) - 'A']);
                windowLength++;
            } 
            else{
                l++;
                freq[s.charAt(l - 1) - 'A']--;
                windowLength--;
            }
                
        }
        return ans;
        
    }
    
    private int getMax(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length; i++)
            max = Math.max(nums[i], max);
        return max;
    }
}