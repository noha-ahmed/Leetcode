class Solution {
    public int combinationSum4(int[] nums, int target) {
       int[] mem = new int[target + 1];
        Arrays.fill(mem, -1);
        mem[0] = 1;
        return countCombRec(nums, mem, target);
    }
    
    private int countCombRec(int[] nums, int[] mem, int target){
        mem[target] = 0;
        for(int num : nums){
            if( num <= target ){
                if( mem[target - num] == - 1 )
                    mem[target - num] = countCombRec(nums, mem, target - num);                
                mem[target] += mem[target - num];
            }
        }
        
        return mem[target];
    }
}