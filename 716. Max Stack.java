//Time Complexity: O(logN) for all operations except peek which is O(1),
//where N is the number of operations performed. 
//Most operations involving TreeMap are O(logN).
//Space Complexity: O(N), the size of the data structures used.
// doulbe LinkedList  + TreeMap
// Note the value of treeMap has to be list, cannot be set.
//  Since we need to gaurantee to delete the last one every time

// https://dzone.com/articles/performance-analysis-of-arraylist-and-linkedlist-i#:~:text=To%20remove%20by%20index%2C%20ArrayList,O(N)%20time%20complexity.
// https://www.tutorialspoint.com/Difference-between-TreeMap-HashMap-and-LinkedHashMap-in-Java#:~:text=TreeMap%20has%20complexity%20of%20O,but%20allow%20multiple%20null%20values.
class MaxStack {
    class Node {
        int val;
        Node pre;
        Node nxt;
        Node(int val, Node pre, Node nxt) {
            this.val = val;
            this.pre = pre;
            this.nxt = nxt;
        }
    }
    Node head;
    Node tail;
    TreeMap<Integer, List<Node>> map;
    public MaxStack() {
        head = new Node(Integer.MIN_VALUE, null, null);
        tail = new Node(Integer.MAX_VALUE, head, null); 
        head.nxt = tail;
        map = new TreeMap<>();
        
    }
    
    public void push(int x) {
        Node cur = new Node(x, tail.pre, tail);
        
        addNode(cur);
    }
    
    private void addNode(Node cur) {
        Node pre = tail.pre;
        pre.nxt = cur;
        tail.pre = cur;
        
        map.putIfAbsent(cur.val, new ArrayList<>());
        map.get(cur.val).add(cur);
    }
    public int pop() {
        Node cur = tail.pre;
        deleteNode(cur);
        return cur.val;
    }
    
    public int top() {
        return tail.pre.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int size = map.get(map.lastKey()).size();
        Node cur = map.get(map.lastKey()).get(size - 1);
        deleteNode(cur);
        return cur.val;
        
    }
    private void deleteNode(Node cur) {
        Node pre = cur.pre;
        Node nxt = cur.nxt;
        pre.nxt = nxt;
        nxt.pre = pre;
        
        
        int size = map.get(cur.val).size();
        map.get(cur.val).remove(size - 1);
        // map.get(cur.val).remove(cur); this also works
        if (map.get(cur.val).size() == 0) {
            map.remove(cur.val);
        }
    }
    
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */