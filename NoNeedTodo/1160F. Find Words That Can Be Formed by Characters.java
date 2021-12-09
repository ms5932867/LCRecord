class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charAry = getAry(chars);
        int cnt = 0;
        for (String w: words) {
            int[] sAry = getAry(w);
            boolean can = true;
            for (int i = 0; i < 26; i++) {
                if (sAry[i] > charAry[i]) {
                    can = false;
                    break;
                }
            }
            if (can) {
                cnt += w.length();
            }
            
        }
        return cnt;
    }
    private int[] getAry(String s) {
        int[] ary = new int[26];
        for (char c: s.toCharArray()) {
            ary[c - 'a']++;
        }
        return ary;
    }
}