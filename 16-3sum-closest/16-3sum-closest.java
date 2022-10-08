class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int l = i + 1;
            int r = nums.length - 1;
            int newTarget = target - nums[i];
            while( l < r ){
                int sum = nums[l] + nums[r];
                if( Math.abs(nums[i] + sum - target) < Math.abs(target - closestSum))
                    closestSum = sum + nums[i];
                
                if( sum == newTarget )
                    return closestSum;
                    
                if(sum > newTarget)
                    r--;
                else
                    l++;
                
            }
        }
        
        return closestSum;
    }
}