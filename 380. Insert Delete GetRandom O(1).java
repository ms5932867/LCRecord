import java.util.Map;
class RandomizedSet {

    Map<Integer, Integer> numAndIndex;
    List<Integer> nums;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        numAndIndex = new HashMap<>();
        nums =  new LinkedList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (numAndIndex.containsKey(val)) {
            return false;
        }
        numAndIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!numAndIndex.containsKey(val)) {
            return false;
        }
        
        int previousIndex = numAndIndex.get(val);
        

        nums.set(previousIndex, nums.get(nums.size() - 1));
        
        numAndIndex.put(nums.get(nums.size() - 1), previousIndex);
        nums.remove(nums.size() - 1);
        numAndIndex.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = (int)(Math.random() * nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */