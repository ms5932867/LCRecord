import java.util.Map;
class RandomizedSet {
    Map<Integer, Integer> numToIndex;
    List<Integer> nums;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        numToIndex = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (numToIndex.containsKey(val)) {
            return false;
        }
        numToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!numToIndex.containsKey(val)) {
            return false;
        }
        int index = numToIndex.get(val);
        // 如果删除的就是最后一个， 要注意map 先加再删除!!!!
        // if (index == nums.size() - 1) {
        //     nums.remove(nums.size() - 1);
        //     numToIndex.remove(val);
        //     return true;
        // }

        int lastNum = nums.get(nums.size() - 1);
        nums.set(index, lastNum);
        nums.remove(nums.size() - 1);

        
        numToIndex.put(lastNum, index);
        numToIndex.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int)(Math.random() * nums.size());
        return nums.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */