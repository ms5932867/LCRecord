import java.util.Map;
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        // 注意sort！！！！！！
        Integer[] B = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i)
            B[i] = arr[i];
        Arrays.sort(B, Comparator.comparingInt(Math::abs));

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1); 
        }

        for (int n : B) {

            if (!map.containsKey(n)) {
                continue;
            }
            if (n == 0) {
                if (map.get(n) % 2 == 1) {
                    return false;
                } else {
                    map.remove(n);
                    continue;
                }
            }
            if (!map.containsKey(n * 2) || map.get(n) > map.get(n * 2)) {
                return false;
            }
            map.put(n * 2, map.get(n * 2) - map.get(n));
            if (map.get(n * 2) == 0) {
                map.remove(n * 2);
            }
            map.remove(n);

        }

        return map.size() == 0;

    }
}