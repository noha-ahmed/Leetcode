class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(nums);
       
        int prevY = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            if( i != 0 && nums[i] == nums[i-1] ) continue;
            int newTarget = -1*nums[i];
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                if(l != i + 1 && nums[l] == nums[l - 1]){
                    l++;
                    continue;
                }
                int x = nums[l] + nums[r];
                if( x == newTarget ){
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]); list.add(nums[l]); list.add(nums[r]);
                    sol.add(list);
                    l++; r--;
                }
                else if(x > newTarget) r--;
                else l++;
            }
        }
        return sol;
        
    }
}