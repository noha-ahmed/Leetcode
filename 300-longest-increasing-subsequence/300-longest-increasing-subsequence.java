class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int maxLen = 1;
        for(int i = 0; i < nums.length; i++){
            arr[i] = 1; 
            for(int j = i - 1; j >= 0; j--)
                if( nums[j] < nums[i] )
                    arr[i] = Math.max(arr[i], arr[j] + 1);
            
            maxLen = Math.max(maxLen, arr[i]);
        }
        
        return maxLen;
    }
}