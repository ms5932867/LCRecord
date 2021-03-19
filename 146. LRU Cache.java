class LRUCache {
    public class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node (int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    int capacity;
    Map<Integer, Node> map;
    Node head = new Node(-1,-1, null, null);
    Node tail = new Node(-1, -1, null, null);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();       
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        deleteNode(cur);
        addLast(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node newNode = new Node(key,value, null, null);
            addLast(newNode);

        }
        else {
            Node newNode = map.get(key);
            newNode.val = value;
            deleteNode(newNode);
            addLast(newNode);
        }
        if (map.size() > capacity) {
            deleteFirst();
        }
    }
    private void deleteFirst() {
        map.remove(head.next.key);
        head.next = head.next.next;
        head.next.prev = head;

    }
    private void addLast(Node node) {
        Node oldLast = tail.prev;
        oldLast.next = node;
        node.prev = oldLast;
        node.next = tail;
        tail.prev = node;
        map.put(node.key, node);
    }
    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */