class MyCalendar {
    private List<int[]> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int i = 0; i < events.size(); i++){
            int[] event = events.get(i);
            if( start < event[1] && end > event[0] )
                return false;
        }
        int[] newEvent = new int[2];
        newEvent[0] = start; newEvent[1] = end;
        events.add(newEvent);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */