class Solution {
    public int combinationSum4(int[] nums, int target) {
       int[] mem = new int[target + 1];
        Arrays.fill(mem, -1);
        mem[0] = 1;
        return countCombRec(nums, mem, target);
    }
    
    private int countCombRec(int[] nums, int[] mem, int target){
        int count = 0;
        
        for(int num : nums){
            if( num <= target ){
                int temp = target - num;
                if( mem[temp] == - 1 )
                    mem[temp] = countCombRec(nums, mem, temp);                
                count += mem[temp];
            }
        }
        
        return count;
    }
}