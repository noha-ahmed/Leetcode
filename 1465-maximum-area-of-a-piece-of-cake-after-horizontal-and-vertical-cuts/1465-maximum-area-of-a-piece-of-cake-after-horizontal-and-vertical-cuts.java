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
        int maxD = 0;
        int prev = 0;
        for(int cut : cuts){
            maxD = Math.max(maxD, cut - prev);
            prev = cut;
        }
        maxD = Math.max(maxD, n - cuts[cuts.length - 1]);
        return maxD;
    }
}