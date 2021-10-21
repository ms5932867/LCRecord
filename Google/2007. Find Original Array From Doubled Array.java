import java.util.Map;
// corner case: 0
class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed == null || changed.length % 2 == 1) {
            return new int[]{};
        }
        Arrays.sort(changed);
        int[] res = new int[changed.length / 2];
        Map<Integer, Integer> map = new HashMap<>(); // num and cnt;
        for (int i : changed) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        for (int i : changed) {
            if (!map.containsKey(i)) {
                continue;
            }
            if (i == 0) {
                if (map.get(i) % 2 == 1) {
                    return new int[]{};
                } else {
                    for (int cnt = map.get(i) / 2; cnt > 0; cnt--) {
                        res[index] = i;
                        index++;
                    }
                    map.remove(i); 
                }
                continue;
            }

            if (!map.containsKey(i * 2)) {
                return new int[]{};
            }
            res[index] = i;
            index++;
            map.put(i, map.get(i) - 1);
            if (map.get(i) == 0) {
                map.remove(i);
            }
            map.put(i * 2, map.get(i * 2) - 1);
            if (map.get(i * 2) == 0) {
                map.remove(i * 2);
            }
        }
        if (map.isEmpty()) {
            return res;
        }
        return new int[]{};
    }
}