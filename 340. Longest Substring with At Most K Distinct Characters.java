import java.util.Map;
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }
        int i = 0;
        int j = 0;
        int max = 0;
        Map<Character, Integer> charCnt = new HashMap<>();
        while ( j < s.length()) {
            while (charCnt.size() <= k && j < s.length()) {
                
                char c = s.charAt(j);
                charCnt.putIfAbsent(c, 0);
                charCnt.put(c, charCnt.get(c) + 1); 
                if (charCnt.size() <= k)  {
                    max = Math.max(max, j- i + 1);
                }
                
                j++; 
            }
        
            while (charCnt.size() > k && i < j) {
                char c = s.charAt(i);
                charCnt.put(c, charCnt.get(c) - 1);
                if (charCnt.get(c) == 0) {
                    charCnt.remove(c);
                }
                i++;
            }

            
        }
        return max;
        
    }
}