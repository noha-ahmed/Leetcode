class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int k = i + 2;
            for(int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++){
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += (k - j - 1);
            }
        }
        
        return count;
    }
    
    
    // search for nums[k] >= x
    private int binarySearch(int[] nums, int l, int r, int x){
        while( l < nums.length && nums[l] < x){
            int mid = (l + r)/2;
            if( nums[mid] < x )
                l = mid + 1;
            else if( nums[mid] >= x)
                r = mid;
        }
        
        return l;
    }
}