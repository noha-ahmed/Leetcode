class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int sum = numbers[l] + numbers[r];
        while(sum != target){
            if(sum < target) l++;
            else r--;
            sum = numbers[l] + numbers[r];
        }
        int[] sol = new int[2];
        sol[0] = l + 1;
        sol[1] = r + 1;
        return sol;
        
    }
}