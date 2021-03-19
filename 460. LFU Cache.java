import java.util.Map;
import java.util.PriorityQueue;
class LFUCache {
    
    public class Item {
        int key;
        int val;
        int cnt;
        int timeStamp;
        Item (int key, int val, int cnt, int timeStamp) {
            this.key = key;
            this.val = val;
            this.cnt = cnt;
            this.timeStamp = timeStamp;
        }
    }
    public class ItemComparator implements Comparator<Item> {
        public int compare(Item i1, Item i2) {
            if (i1.cnt == i2.cnt) {
                return i1.timeStamp - i2.timeStamp;
            }
            return i1.cnt- i2.cnt;
        }
    }
    Map<Integer, Item> map;
    PriorityQueue<Item> pq;
    int time = 0;
    int capacity;
    public LFUCache(int capacity) {
        map = new HashMap<>();
        pq = new PriorityQueue<>(capacity + 1, new ItemComparator());
        this.capacity = capacity;

    }
    
    public int get(int key) {
        time++;
        if (!map.containsKey(key) || capacity == 0) {
            return -1;
        }
        Iterator itr = pq.iterator();
        while (itr.hasNext()) {
            Item item = (Item)itr.next();
            if (item.key == key) {
                pq.remove(item);
                item.cnt++;
                item.timeStamp = time;
                pq.offer(item);
                map.put(key, item);
                return item.val;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        time++;
        if (!map.containsKey(key)) {
            if (pq.size() == capacity) {
                Item deleteItem = pq.poll();
                map.remove(deleteItem.key);
            }
            Item item = new Item(key, value, 1, time);
            pq.offer(item);
            map.put(key, item);

            return;
        }
        Iterator itr = pq.iterator();
        while (itr.hasNext()) {
            Item item = (Item)itr.next();
            if (item.key == key) {
                pq.remove(item);
                item.cnt++;
                item.timeStamp = time;
                item.val = value;
                pq.offer(item);
                map.put(key, item);
                return;
            }
        }


    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */