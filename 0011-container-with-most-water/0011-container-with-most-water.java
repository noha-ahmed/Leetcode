class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while(l < r){
            maxArea = Math.max(maxArea, (r - l)*Math.min(height[l], height[r]));
            if( height[l] < height[r] ) l++;
            else r--;
        }
        return maxArea;
    }
  
}