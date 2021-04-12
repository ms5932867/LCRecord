// Design a HashMap without using any built-in hash table libraries.

// To be specific, your design should include these functions:

// put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
// get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
// remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.


class MyHashMap {
    class Pair {
        int k;
        int v;
        Pair(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
    List<List<Pair>> list;
    int modulo;
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new ArrayList<>();
        modulo = 769;
        for (int i = 0; i < modulo; i++) {
            list.add(new ArrayList<>());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % modulo;
        for (Pair p : list.get(index)) {
            if (p.k == key) {
                list.get(index).remove(p);
                break;
            }
        }
        list.get(index).add(new Pair(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % modulo;
        for (Pair p : list.get(index)) {
            if (p.k == key) {
                return p.v;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % modulo;
        for (Pair p : list.get(index)) {
            if (p.k == key) {
                list.get(index).remove(p);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */