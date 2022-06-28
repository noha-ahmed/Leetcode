class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if( i != 0 && nums[i] == nums[i-1] )
                continue;
            
            int p1 = i + 1;
            int p2 = nums.length - 1;
            int target = -1*nums[i];
            
            while(p1 < p2){
                if(nums[p1] + nums[p2] < target)
                    p1++;
                else if (nums[p1] + nums[p2] > target)
                    p2--;
                else{
                    int x = nums[p1]; 
                    int y = nums[p2];
                    while(p1 < p2 && (nums[p1] == x))
                        p1++;
                    
                    while( p1 < p2 && (nums[p2] == y))
                        p2--;
                    
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]); list.add(x); list.add(y);
                    sol.add(list);
                }
            }
            
        }
        return sol;
        
    }
}