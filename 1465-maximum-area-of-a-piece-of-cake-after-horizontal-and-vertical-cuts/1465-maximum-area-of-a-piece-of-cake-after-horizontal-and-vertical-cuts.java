class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxH = getMaxDistance(horizontalCuts, h);
        int maxV = getMaxDistance(verticalCuts, w);
        long res = (long)maxH*maxV;
        long mod = (long)1e9+7;
        return (int)(res % mod);
        
    }
    
    public int getMaxDistance(int[] cuts, int n){
        Arrays.sort(cuts);
        int maxD = cuts[0];
        for(int i = 1; i < cuts.length; i++){
            maxD = Math.max(maxD, cuts[i] - cuts[i - 1]);
        }
        maxD = Math.max(maxD, n - cuts[cuts.length - 1]);
        return maxD;
    }
}