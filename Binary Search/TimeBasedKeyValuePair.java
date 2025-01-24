// TC - O(n), SC - O(mxn)
class TimeMap {
    Map<String, List<String[]>> map;

    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
         if(!map.containsKey(key)) {
            map.put(key, new ArrayList());
        }

        // key -> {[value, timestamp], [value, timestamp]...}
        map.get(key).add(new String[]{value, String.valueOf(timestamp)});
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            List<String[]> values = map.get(key);

            for(int i = values.size() - 1; i >= 0; i--) {
                if(Integer.parseInt(values.get(i)[1]) <= timestamp) {
                    return values.get(i)[0];
                }
            } 
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */