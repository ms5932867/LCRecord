class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()){
            return false;
        }
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                index.add(i);
            }
        }
        if (index.size() == 0) {
            return true;
        }
        if (index.size() !=  2) {
            return false;
        }
        return s1.charAt(index.get(0)) == s2.charAt(index.get(1)) && s2.charAt(index.get(0)) == s1.charAt(index.get(1));

    }
}