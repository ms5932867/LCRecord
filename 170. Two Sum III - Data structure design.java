import java.util.Map;
class TwoSum {
    Map<Integer, Integer> numCnt;
    /** Initialize your data structure here. */
    public TwoSum() {
        numCnt = new HashMap<>();  
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        numCnt.putIfAbsent(number, 0);
        numCnt.put(number, numCnt.get(number) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key: numCnt.keySet()) {
            int tgt = value - key;
            
             if ((tgt == key && numCnt.get(key) > 1) || (tgt != key && numCnt.containsKey(tgt))) {
                 return true;
             }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */