import java.util.Map;
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

    Map<Integer, Node> map;
    int capacity;
    Node head = null ;
    Node tail = null ;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1, null, tail);
        tail = new Node(-1, -1, head, null);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        addLast(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            addLast(new Node(key, value, null, null));
            if (map.size() > capacity) {
                deleteNode(head.next);
            }
        }
        else {
            Node node = map.get(key);
            deleteNode(node);
            addLast(new Node(key, value, null, null));
        }
    }

    private void deleteNode(Node node) {
        map.remove(node.key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

    }

    private void addLast(Node node) {
        Node prevOfTail = tail.prev;
        prevOfTail.next = node;
        node.prev = prevOfTail;
        node.next = tail;
        tail.prev = node;
        map.put(node.key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */