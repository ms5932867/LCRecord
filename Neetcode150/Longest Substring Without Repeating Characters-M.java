/*
3. Longest Substring Without Repeating Characters
Medium  
Given a string s, find the length of the longest substring without duplicate characters.

A substring is a contiguous sequence of characters within a string.

Example 1:

Input: s = "zxyzxyz"

Output: 3
Explanation: The string "xyz" is the longest without duplicate characters.

Example 2:

Input: s = "xxxx"

Output: 1
*/
/**
 * O(n) time, O(n) space
 * Key point: left pointer should never go back, otherwise it will cause wrong answer.
 * map只需要存储每个字符最后一次出现的index就行了，不需要存储所有出现的index。
 * 左指针的更新应该是：l = Math.max(idx + 1, l)，而不是l = idx + 1，因为可能之前已经有一个重复字符了，左指针已经移动过了。
 * 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        Map<Character, List<Integer>> seenIdx = new HashMap<>();
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (!seenIdx.containsKey(c)) {
                seenIdx.put(c, new ArrayList<>());
            } else {
                List<Integer> idx = seenIdx.get(c);
                l = Math.max(idx.get(idx.size() - 1) + 1, l); // left 指针不能往回走!!!!
            }
            seenIdx.get(c).add(r);
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
