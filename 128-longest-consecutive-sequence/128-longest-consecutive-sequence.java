class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> chainsMap = new HashMap<>();
        HashSet<Integer> numsSet = new HashSet<>();
        for(int x : nums){
            numsSet.add(x);
        }
        int maxChainLength = 0;
        for(int x : nums){
            if(numsSet.contains(x)){
                int chainLength = 1;
                int num = x + 1;
                while(numsSet.contains(num)){
                    chainLength++;
                    numsSet.remove(num); num++;
                }
                if(chainsMap.containsKey(num)){
                    chainLength += chainsMap.get(num);
                    chainsMap.remove(num);
                }
                chainsMap.put(x, chainLength);
                maxChainLength = Math.max(maxChainLength, chainLength);
                numsSet.remove(x);
            }
        }
        return maxChainLength;
        
    }
}