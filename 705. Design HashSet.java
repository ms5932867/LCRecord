// read https://leetcode.com/problems/design-hashset/solution/
//bst todo

// Design a HashSet without using any built-in hash table libraries.

// Implement MyHashSet class:

// void add(key) Inserts the value key into the HashSet.
// bool contains(key) Returns whether the value key exists in the HashSet or not.
// void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

class MyHashSet {

    List<List<Integer>> list = new ArrayList<>();
    int modulo = 769;
    /** Initialize your data structure here. */
    public MyHashSet() {
        for (int i = 0; i < 769; i++) {
            list.add(new LinkedList<>());
        }
    }
    
    public void add(int key) {
        int hashKey = key % modulo;
        for (int n : list.get(hashKey)) {
            if (key == n) {
                return;
            }
        }
        list.get(hashKey).add(key);
    }
    
    public void remove(int key) {
        int hashKey = key % modulo;
        for (int n : list.get(hashKey)) {
            if (key == n) {
                list.get(hashKey).remove(Integer.valueOf(key));
                return;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKey = key % modulo;
        for (int n : list.get(hashKey)) {
            if (key == n) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */