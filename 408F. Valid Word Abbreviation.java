class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        for (; j < abbr.length(); j++) {
            if (!Character.isDigit(abbr.charAt(j))) {
                if (i >= word.length() || abbr.charAt(j) != word.charAt(i)) {
                    // System.out.println("return false i=" + i + " j=" +j);
                    return false;
                } else {
                    i++;
                }
                continue;
            }
            
            if (abbr.charAt(j) == '0') {
                return false;
            }
            
            int cnt = 0;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                cnt = cnt * 10 + (abbr.charAt(j) - '0');
                j++;
            }
            i += cnt ;
            j--;
        }
        return i == word.length();
    }
}