class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> timeStampsMap = map.getOrDefault(key, new TreeMap<>());
        timeStampsMap.put(timestamp, value);
        map.put(key, timeStampsMap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeStampsMap = map.getOrDefault(key, null);
        if( timeStampsMap == null ) return "";
        Map.Entry<Integer, String> entry = timeStampsMap.floorEntry(timestamp);
        if( entry == null ) return "";
        return entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */