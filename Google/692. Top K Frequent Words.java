import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public class Item {
        String word;
        int cnt;
        Item(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    public class ItemComparator implements Comparator<Item> {
        public int compare(Item i1, Item i2) {
            if (i1.cnt == i2.cnt) {
                return i2.word.compareTo(i1.word);
            }
            return i1.cnt - i2.cnt;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCnt = new HashMap<>();
        for (String w: words) {
            wordCnt.put(w, wordCnt.getOrDefault(w, 0) + 1);
        }
        PriorityQueue<Item> pq = new PriorityQueue<>(k, new ItemComparator());
        for (String w: wordCnt.keySet()) {
            pq.offer(new Item(w, wordCnt.get(w)));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll().word);
        }
        Collections.reverse(res);
        return res;
    }
}