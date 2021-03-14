class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternToS = new HashMap<>();
        Map<String, Character> sToPattern = new HashMap<>();
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = arr[i];
            // System.out.println(w + " " + c);
            if (patternToS.containsKey(c) && !patternToS.get(c).equals(w)) {
                return false;
            }
            if (sToPattern.containsKey(w) && sToPattern.get(w) != c) {
                return false;
            }
            patternToS.put(c, w);
            sToPattern.put(w,c);
        }
        return true;
    }
}