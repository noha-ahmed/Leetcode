class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniques = new HashSet<>();
        for(int num: nums){
            if(uniques.contains(num)) return true;
            uniques.add(num);
        }
        return false;
    }
}