class Solution {
    public int maxSubArray(int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        
        for(int num : nums){
            maxEndingHere += num;
            if(maxEndingHere < num)
                maxEndingHere = num;
            if(maxEndingHere > maxSoFar)
                maxSoFar = maxEndingHere;
        }
        
        return maxSoFar;
    }
}