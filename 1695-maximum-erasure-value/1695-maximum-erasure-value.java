class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0;
        int[] prefixSum = new int[nums.length]; 
        HashMap<Integer, Integer> lastIndexMap = new HashMap<>();
        int sum = nums[0];
        int maxSum = sum;
        prefixSum[0] = nums[0];
        lastIndexMap.put(nums[0],0);
       
        for(int i = 1; i < nums.length; i++){
            int index = lastIndexMap.getOrDefault(nums[i],-1);
            lastIndexMap.put(nums[i],i);
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            sum+= nums[i];
            if(index >= l){
                l = index + 1;
                sum = prefixSum[i] - prefixSum[index]; 
            }
            maxSum = Math.max(maxSum, sum);   
        }
        return maxSum;
        
    }
}