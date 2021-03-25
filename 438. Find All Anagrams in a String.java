class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p.length() > s.length()) {
            return res;
        }
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for (int i = 0; i < p.length(); i++){
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCnt, pCnt)) {
            res.add(0);
        }

        for (int i = 1; i <= s.length() - p.length(); i++) {
            sCnt[s.charAt(i - 1) - 'a']--;
            sCnt[s.charAt(i + p.length() - 1) - 'a']++;
            if (Arrays.equals(sCnt, pCnt)) {
                res.add(i);
            }
        }
        return res;

     }
}