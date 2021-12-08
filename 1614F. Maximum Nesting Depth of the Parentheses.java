class Solution {
    public int maxDepth(String s) {
        int dif = 0;
        int maxDif = 0;
        for (char c:  s.toCharArray()){
            if (c == '(') {
                dif++;
                maxDif = Math.max(dif, maxDif);
            } else if (c == ')') {
                dif--;
            }
        }
        return maxDif;
    }
}