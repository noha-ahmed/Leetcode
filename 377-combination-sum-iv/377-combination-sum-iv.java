class Solution {
    public int combinationSum4(int[] nums, int target) {
       HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums)
            map.put(num, -1);
        
        map.put(0, 1);
        return countCombRec(nums, map, target);
    }
    
    private int countCombRec(int[] nums, HashMap<Integer, Integer> map, int target){
        int count = 0;
        
        for(int num : nums){
            if( num <= target ){
                int temp = target - num;
                int tempCount = map.getOrDefault(temp, -1);
                if( tempCount == - 1 ){
                    tempCount = countCombRec(nums, map, temp);
                    map.put(temp, tempCount);
                }
                count += tempCount;
            }
        }
        
        return count;
    }
}