class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < prices[start])
                start = i;
            else
                maxProfit = Math.max(maxProfit, prices[i] - prices[start]);
        }
        return maxProfit;
    }
}