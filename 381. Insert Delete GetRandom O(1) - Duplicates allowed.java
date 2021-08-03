class RandomizedCollection {

    Map<Integer, Set<Integer>> valIndex;
    List<Integer> vals;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        valIndex = new HashMap<>();
        vals = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (valIndex.containsKey(val)) {
            valIndex.get(val).add(vals.size());
            vals.add(val);
            return false;
        }
        valIndex.put(val, new HashSet<>());
        valIndex.get(val).add(vals.size());
        vals.add(val);
        return true;

    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!valIndex.containsKey(val)) {
            return false;
        }


        int index = valIndex.get(val).iterator().next();
        valIndex.get(val).remove(index);

        int lastVal = vals.get(vals.size() - 1);
        int lastIndex = vals.size() - 1;
        vals.set(index, lastVal);
        vals.remove(lastIndex);

        valIndex.get(lastVal).add(index);
        valIndex.get(lastVal).remove(lastIndex);
// same issue as in 380 add first, remove later. otherwise may have NPE 
        if (valIndex.get(val).size() == 0) {
            valIndex.remove(val);
        }
        
        return true;   
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = (int)(Math.random() * vals.size());
        return vals.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


//
class RandomizedCollection {
    Map<Integer, List<Integer>> map; //number and index
    List<Integer> list; //list of number
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new  HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if (!map.containsKey(val)) {
            map.put(val, new ArrayList<>());
            map.get(val).add(list.size() - 1);
            return true;
        } 
        map.get(val).add(list.size() - 1);
        return false;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        if (map.get(val).get(0) != list.size() - 1) {
            swapWithLast(val);
        } 
        removeLast();
        return true;  
    }
    private void swapWithLast(int curVal) {
        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);
        int curIndex = map.get(curVal).get(0);
        list.set(curIndex, lastVal);
        list.set(lastIndex, curVal);
        map.get(curVal).set(0, lastIndex);
        for (int i = 0; i < map.get(lastVal).size(); i++) {
            int index = map.get(lastVal).get(i);
            if (index == lastIndex) {
                map.get(lastVal).remove(i);
                map.get(lastVal).add(curIndex);
                break;
            }
        }
    }
    private void removeLast() {
        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);
        list.remove(lastIndex);
        for (int i = 0; i < map.get(lastVal).size(); i++) {
            int index = map.get(lastVal).get(i);
            if (index == lastIndex) {
                map.get(lastVal).remove(i);
                break;
            }
        }
        if (map.get(lastVal).size() == 0) {
            map.remove(lastVal);
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = (int)(Math.random() * list.size());
        return list.get(index);

    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */