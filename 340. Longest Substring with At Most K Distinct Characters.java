class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() <= k) {
            return s.length();
        }
        int left = 0;
        int maxRes = 0;
        Map<Character, Integer> charCnt = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            charCnt.putIfAbsent(rc, 0);
            charCnt.put(rc, charCnt.get(rc) + 1);
            while(charCnt.size() > k) {
                char lc = s.charAt(left);
                charCnt.put(lc, charCnt.get(lc) - 1);
                if (charCnt.get(lc) == 0) {
                    charCnt.remove(lc);
                }
                left++;
            }
            maxRes = Math.max(maxRes, right - left + 1);
        }
        return maxRes;
    }
}

//v2

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