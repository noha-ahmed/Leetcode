class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        for(int x : nums){
            numsSet.add(x);
        }
        int maxChainLength = 0;
        for(int x : nums){
            if(!numsSet.contains(x - 1)){
                int chainLength = 1;
                int num = x + 1;
                while(numsSet.contains(num)){
                    chainLength++;
                    num++;
                }
                maxChainLength = Math.max(maxChainLength, chainLength);
            }
        }
        return maxChainLength;
        
    }
}