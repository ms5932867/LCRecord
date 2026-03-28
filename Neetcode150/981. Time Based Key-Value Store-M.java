// Time Based Key-Value Store
// https://leetcode.com/problems/time-based-key-value-store/
/**
 * Implement a time-based key-value data structure that supports:

Storing multiple values for the same key at specified time stamps
Retrieving the key's value at a specified timestamp
Implement the TimeMap class:

TimeMap() Initializes the object.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns the most recent value of key if set was previously called on it and the most recent timestamp for that key prev_timestamp is less than or equal to the given timestamp (prev_timestamp <= timestamp). If there are no values, it returns "".
Note: For all calls to set, the timestamps are in strictly increasing order.

Example 1:

Input:
["TimeMap", "set", ["alice", "happy", 1], "get", ["alice", 1], "get", ["alice", 2], "set", ["alice", "sad", 3], "get", ["alice", 3]]

Output:
[null, null, "happy", "happy", null, "sad"]

Explanation:
TimeMap timeMap = new TimeMap();
timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.
timeMap.get("alice", 1);           // return "happy"
timeMap.get("alice", 2);           // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
timeMap.set("alice", "sad", 3);    // store the key "alice" and value "sad" along with timestamp = 3.
timeMap.get("alice", 3);           // return "sad"
 */
class TimeMap {
    Map<String, List<ValueItem>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new ValueItem(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        List<ValueItem> valueItems = timeMap.get(key);
        int size = valueItems.size();
        int l = 0;
        int r = size - 1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            ValueItem cur = valueItems.get(m);
            if (cur.time > timestamp) {
                r = m - 1;
            } else {
                res = cur.val;
                l = m + 1;
            }
        }
        return res;

    }

    private class ValueItem {
        String val;
        int time;
        ValueItem(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }
}
/*
如果 list[m].time <= timestamp，说明这个位置可用，先记下来
但还要继续往右找，看有没有更接近的
所以 l = m + 1
最后 res 就是答案
*/