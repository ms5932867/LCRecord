class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> allStr = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subStr = s.substring(i, i + 10);
            if (allStr.contains(subStr)) {
                ans.add(subStr);
            } else {
                allStr.add(subStr);
            }
        }
        return new ArrayList<>(ans);
    }
}