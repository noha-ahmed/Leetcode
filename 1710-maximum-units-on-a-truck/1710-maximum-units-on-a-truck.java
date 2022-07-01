class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> a[1] > b[1] ? -1 : 1);
        int units = 0;
        
        for(int i = 0; truckSize > 0 && i < boxTypes.length; i++){
            int boxesNum = Math.min(boxTypes[i][0], truckSize);
            units+= boxesNum* boxTypes[i][1];
            truckSize -= boxesNum;
        }
        return units;   
    }
}