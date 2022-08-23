class TimeMap {
    
    private HashMap<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
            
        }
        
        TreeMap<Integer, String> treemap = map.get(key);
        treemap.put(timestamp, value);
        map.put(key, treemap);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        else {
            TreeMap<Integer, String> treemap = map.get(key);
            Map.Entry<Integer, String> entry = treemap.floorEntry(timestamp);
            
            if (entry == null) {
                return "";
            }
            else {
                return entry.getValue();
            }
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */