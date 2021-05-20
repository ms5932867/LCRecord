// double LinkedList
class AllOne {
    class Node {
        String s;
        int cnt;
        Node prv = null;
        Node nxt = null;
        Node(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }
    Map<String, Node> map;
    Node head;
    Node tail;
    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        head = new Node("", -1);
        tail = new Node("", Integer.MAX_VALUE);
        head.nxt = tail;
        tail.prv = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addNode(new Node(key, node.cnt + 1));
        } else {
            addNode(new Node(key, 1));
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Node node = map.get(key);
        deleteNode(node);
        if (node.cnt != 1) {
            addNode(new Node(key, node.cnt - 1));
        } 

    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prv.s;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.nxt.s;
    }

    private void deleteNode(Node node) {
        Node prvNode = node.prv;
        Node nxtNode = node.nxt;
        prvNode.nxt = nxtNode;
        nxtNode.prv = prvNode;
        map.remove(node.s);
    }
    private void addNode(Node node) {
        // start comparing cnt from head
        Node p1 = head;
        Node p2 = head.nxt;
        while (!(node.cnt >= p1.cnt && node.cnt <= p2.cnt )) {
            p1 = p2;
            p2 = p2.nxt;
        }
        p1.nxt = node;
        node.prv = p1;
        p2.prv = node;
        node.nxt = p2;
        map.put(node.s, node);
    }
}
//TreeMap
class AllOne {
    TreeMap<Integer, Set<String>> treeMap;
    Map<String, Integer> map;
    int min = Integer.MAX_VALUE;
    int max = -1;
    /** Initialize your data structure here. */
    public AllOne() {
        treeMap = new TreeMap<>();
        map = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            map.put(key, 1);
            treeMap.putIfAbsent(1, new HashSet<>());
            treeMap.get(1).add(key);
        } else {
            int cnt = map.get(key);
            map.put(key, cnt + 1);
            treeMap.putIfAbsent(cnt + 1, new HashSet<>());
            treeMap.get(cnt + 1).add(key);
            treeMap.get(cnt).remove(key);
            if (treeMap.get(cnt).size() == 0) {
                treeMap.remove(cnt);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        int cnt = map.get(key);
        if (cnt == 1) {
            treeMap.get(1).remove(key);
            map.remove(key);
        } else {
            map.put(key, cnt - 1);
            treeMap.putIfAbsent(cnt - 1, new HashSet<>());
            treeMap.get(cnt - 1).add(key);
            treeMap.get(cnt).remove(key);
           
        }
        if (treeMap.get(cnt).size() == 0) {
            treeMap.remove(cnt);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (treeMap.size() > 0) {
            return treeMap.get(treeMap.lastKey()).iterator().next();
        }
        return "";
    }
        
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (treeMap.size() > 0) {
            return treeMap.get(treeMap.firstKey()).iterator().next();
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */