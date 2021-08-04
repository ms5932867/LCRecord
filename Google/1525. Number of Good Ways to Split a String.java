class Solution {
    public int numSplits(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int[] leftToRight = new int[s.length()];
        // cnt of dif chars in index substring(0, index + 1) so the right half is substring(index + 1, length)
        Set<Character> cntLeft = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            cntLeft.add(s.charAt(i));
            leftToRight[i] = cntLeft.size();
        }

        int res = 0;
        int rightToleft = 0;
        // cnt of dif chars in index substring(index + 1, length)
        Set<Character> cntRight = new HashSet<>();
        for (int i = s.length() - 1; i > 0; i--) {
            cntRight.add(s.charAt(i));
            rightToleft = cntRight.size();
            if (rightToleft == leftToRight[i - 1]) {
                res++;
            }
        }
        return res;

    }
}