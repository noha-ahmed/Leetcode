class MyCalendarThree {
    private TreeMap<Integer, Integer> diff;

    public MyCalendarThree() {
        diff = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        diff.put(start, diff.getOrDefault(start, 0) + 1);
        diff.put(end, diff.getOrDefault(end, 0) - 1);
        int activeEvents = 0;
        int maxK = 1;
        for(int delta: diff.values()){
            activeEvents += delta;
            maxK = Math.max(maxK, activeEvents);
        }
        return maxK;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */