class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuteRec(0, nums);
    }
    
    private List<List<Integer>> permuteRec(int index, int[] nums){
        List<List<Integer>> res =  new LinkedList<>();
        if(index == nums.length - 1){
            ArrayList<Integer> list = new ArrayList<>(nums.length);
            for(int num: nums)
                list.add(num);
            res.add(list);
            return res;
        }
        
        res.addAll(permuteRec(index + 1, nums));
        for(int i = index + 1; i < nums.length; i++){
            swap(nums, index, i);
            res.addAll(permuteRec(index + 1, nums));
            swap(nums, index, i);
        }
        return res;   
    }
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}