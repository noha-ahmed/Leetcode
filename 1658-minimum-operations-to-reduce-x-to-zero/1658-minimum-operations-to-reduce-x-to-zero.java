class Solution {
    public int minOperations(int[] nums, int x) {
        int target = 0;
        for(int i = 0; i < nums.length; i++){
            target+= nums[i];
        }
        target-= x;
        int l = 0, r = 0;
        int maxLen = -1;
        int sum = nums[0];
        while(true){
            if( sum == target ){
                maxLen = Math.max(maxLen, (r - l + 1));  
                if( r < nums.length - 1){
                    r++;
                    sum += nums[r];
                }
                else if( l < r + 1){
                    sum -= nums[l];
                    l++;
                }
                else break;
                
            }
            else if( sum < target ){
                if( r < nums.length - 1){
                    r++;
                    sum += nums[r];
                }
                else break;
                
            }
            else{
                if( l < r + 1){
                    sum -= nums[l];
                    l++;
                }
                else break;
              
            }
        }
        if( maxLen == -1 ) return -1;
        return nums.length - maxLen;
    
    }
}