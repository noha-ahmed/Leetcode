class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while(l < r){
            int x = numbers[l] + numbers[r];
            if(x == target) return new int[]{l + 1, r + 1};
            else if(x > target) r--;
            else l++;
        }
        return null;
    }
}