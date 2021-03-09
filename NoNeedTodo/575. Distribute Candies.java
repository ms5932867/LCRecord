class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> type = new HashSet<>();
        for (int t: candyType) {
            type.add(t);
        }
        int n = candyType.length;
        return Math.min(n /2, type.size());
    }
}