class Solution {
    
    // The solution is based on the notion that we want to find a third number in a triplet. Thinking greedy, we will save the minimal first element and the minimal second element in a triplet and our goal is to find a third number that is more than the first and the second minimal elements.
    public boolean increasingTriplet(int[] nums) {
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= minOne)
                minOne = nums[i];
            else if(nums[i] <= minTwo)
                minTwo = nums[i];
            else
                return true;
        }
        return false;
    }
}