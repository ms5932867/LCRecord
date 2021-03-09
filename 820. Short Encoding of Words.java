// A valid encoding of an array of words is any reference string s and array of indices indices such that:

// words.length == indices.length
// The reference string s ends with the '#' character.
// For each index indices[i], the substring of s starting from indices[i] and up to (but not including) the next '#' character is equal to words[i].
// Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.

 

// Example 1:

// Input: words = ["time", "me", "bell"]
// Output: 10
// Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
// words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
// words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
// words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> reverseWords = new HashSet<>();
        for (String w: words) {
            StringBuilder sb = new StringBuilder(w);
            sb.reverse();
            reverseWords.add(sb.toString());
        }
        for (String w: words) {
            for (int i = w.length() - 1; i > 0; i--) {
                StringBuilder subWord = new StringBuilder(w.substring(i, w.length()));
                subWord.reverse();
                if (reverseWords.contains(subWord.toString())) {
                    reverseWords.remove(subWord.toString());
                }
            }
        }
        int res = 0;
        for (String w: reverseWords) {
            res += w.length();
            res++;
        }
        return res;
    }
}