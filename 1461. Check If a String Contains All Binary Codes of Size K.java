class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> subStrings = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            subStrings.add(s.substring(i, i + k));
            // System.out.println(s.substring(i, i + k) + " i=" + i);
        }
        double cnt = 1;
        while(k >= 1) {
            cnt *= 2;
            k--;
        }
        return subStrings.size() == cnt;
    }
}