class MyHashMap {
    class Pair {
        int k;
        int v;
        Pair (int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
    int modulo;
    List<List<Pair>> map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        modulo =  1000;
        map = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            map.add(new ArrayList<>());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = find(key);
        if ( i != -1) {
            map.get(key % modulo).remove(i);
        }
        Pair p = new Pair(key, value);
        map.get(key % modulo).add(p);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = find(key);
        if ( i == -1) {
            return -1;
        }
        return map.get(key % modulo).get(i).v;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = find(key);
        if ( i == -1) {
            return;
        }
        map.get(key % modulo).remove(i);
    }

    private int find(int key) { // return the index of the pair in that list
        List<Pair> list = map.get(key % modulo);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).k == key) {
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */