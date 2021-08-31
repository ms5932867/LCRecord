import java.util.Map;
import java.util.PriorityQueue;
class Solution {
    public class Item {
        Character ch;
        int cnt;
        Item(Character ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    public String reorganizeString(String S) {
        Map<Character, Integer> charCnt = new HashMap<>();
        for (char c: S.toCharArray()) {
            charCnt.put(c, charCnt.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Item> pq = new PriorityQueue<>(S.length(), (i1, i2) -> Integer.compare(i2.cnt, i1.cnt));
        for (char c: charCnt.keySet()) {
            pq.offer(new Item(c, charCnt.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Item cur = pq.poll();
            if (sb.length() == 0 || cur.ch != sb.charAt(sb.length() - 1)) {
                sb.append(cur.ch);
                if (cur.cnt >= 2) {
                    pq.offer(new Item(cur.ch, cur.cnt - 1));
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                } else {
                    Item next = pq.poll();
                    pq.offer(cur);
                    sb.append(next.ch);
                    if (next.cnt >= 2) {
                        pq.offer(new Item(next.ch, next.cnt - 1));
                    }
                }
            }
        }
        return sb.toString();
    }
}