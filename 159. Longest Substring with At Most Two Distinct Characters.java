// Given a string s, return the length of the longest substring that contains at most two distinct characters.
// Example 1:
// Input: s = "eceba"
// Output: 3
// Explanation: The substring is "ece" which its length is 3.
// Example 2:
// Input: s = "ccaabbb"
// Output: 5
// Explanation: The substring is "aabbb" which its length is 5.
// Constraints:
// 1 <= s.length <= 104
// s consists of English letters.
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            //right pointer
            map.putIfAbsent(s.charAt(right), 0);
            map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
     

            //left pointer
            while (map.size() > 2) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            

        }
        return maxLength;
    }
}