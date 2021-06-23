import java.util.Map;
// lowerKey, floorKey, higherKey, ceilingKey
// Integer time = map.get(key).floorKey(timestamp);
// if ( time == null ) {
   //https://stackoverflow.com/questions/13747859/how-to-check-if-an-int-is-a-null 
//An int is not null, it may be 0 if not initialized.

// If you want an integer to be able to be null, you need to use Integer instead of int.

class TimeMap {
    Map<String, TreeMap<Integer, String>> map;// key, TreeMap<time, value>
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        Integer time = map.get(key).floorKey(timestamp);
        if ( time == null ) {
            return "";
        }
        return map.get(key).get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */