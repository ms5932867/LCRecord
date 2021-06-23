import java.util.Map;
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