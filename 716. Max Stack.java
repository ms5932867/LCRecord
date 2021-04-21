//Time Complexity: O(logN) for all operations except peek which is O(1),
//where N is the number of operations performed. 
//Most operations involving TreeMap are O(logN).
//Space Complexity: O(N), the size of the data structures used.
// doulbe LinkedList  + TreeMap
// https://dzone.com/articles/performance-analysis-of-arraylist-and-linkedlist-i#:~:text=To%20remove%20by%20index%2C%20ArrayList,O(N)%20time%20complexity.
// https://www.tutorialspoint.com/Difference-between-TreeMap-HashMap-and-LinkedHashMap-in-Java#:~:text=TreeMap%20has%20complexity%20of%20O,but%20allow%20multiple%20null%20values.
class MaxStack {
    public class Node {
        int val;
        Node prev = null;
        Node next = null;
        Node (int val) {
            this.val = val;
        }

    }
    TreeMap<Integer, List<Node>> intToNodes;
    Node head;
    Node tail;
    /** initialize your data structure here. */
    public MaxStack() {
        intToNodes =  new TreeMap<>();
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
    }
    
    public void push(int x) {
        Node cur = new Node(x);
        addNode(cur);
        intToNodes.putIfAbsent(x, new ArrayList<>());
        intToNodes.get(x).add(cur);
    }
    // add a node before Tail
    private void addNode(Node node) {
        Node nodeBeforeTail = tail.prev;
        nodeBeforeTail.next = node;
        node.prev = nodeBeforeTail;
        node.next = tail;
        tail.prev = node;
    }

    public int pop() {
        Node cur = tail.prev;
        deleteNodeFromTreeMap(cur);
        deleteNode(cur);
        return cur.val;
    }
    private void deleteNodeFromTreeMap(Node node) {
        int size = intToNodes.get(node.val).size();
        if (size == 1) {
            intToNodes.remove(node.val);
        } else {
            intToNodes.get(node.val).remove(size - 1);
        }
    }
    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    public int top() { //O(1)
        return tail.prev.val;
    }
    
    public int peekMax() {
        return intToNodes.lastKey();

    }
    
    public int popMax() {
        int max = intToNodes.lastKey();
        int size = intToNodes.get(max).size();
        Node cur = intToNodes.get(max).get(size - 1);
        deleteNodeFromTreeMap(cur);
        deleteNode(cur);
        return max;
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