class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<Integer>[] subseq = new PriorityQueue[2002];
        final int MIN = -1001;
        for(int num: nums)
             subseq[num - MIN] = new PriorityQueue<>();
        
        for(int num: nums){
            PriorityQueue<Integer> q = subseq[num - 1 - MIN];
            if( q == null || q.isEmpty())
                subseq[num - MIN].add(1);
            else
                subseq[num - MIN].add(q.poll() + 1);
                
        }
        
        for(int num: nums)
           if( !subseq[num - MIN].isEmpty()){
                Iterator<Integer> it = subseq[num - MIN].iterator();
                while(it.hasNext() && it.next() < 3)
                    return false;
            }
        
        return true;
    }
}