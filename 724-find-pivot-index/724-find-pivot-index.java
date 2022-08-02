class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for(int x: nums) sum+=x;
        
        for(int i = 0; i < nums.length; i++){
            int rightSum = sum - leftSum - nums[i];
            if( leftSum == rightSum) return i;
            leftSum+= nums[i];
        }
        
        return -1;
    }
}