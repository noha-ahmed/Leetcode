class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentTank = 0, totalTank = 0, startIndex = 0;
        for(int i = 0; i < gas.length; i++){
            totalTank+= gas[i] - cost[i];
            currentTank+= gas[i]-cost[i];
            if( currentTank < 0 ){
                startIndex = i + 1;
                currentTank = 0;
            }
        }
        if( totalTank < 0 ) return -1;
        else return startIndex;
        
        
    }
}