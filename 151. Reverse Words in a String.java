class Solution {
    public String reverseWords(String s) {
        String[] sAry = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sAry.length - 1; i >= 0; i--) {
            if (sAry[i].equals("")) {
                continue;
            }
            sb.append(sAry[i]);
            sb.append(" ");
        } 
        if (sb.length() >= 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}