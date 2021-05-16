// https://leetcode-cn.com/problems/word-break/solution/dong-tai-gui-hua-ji-yi-hua-hui-su-zhu-xing-jie-shi/
//  https://zxi.mytechroad.com/blog/leetcode/leetcode-139-word-break/
//Recursion with memoization
class Solution {
    Map<String, Boolean> mem =  new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        mem =  buildMem(wordDict);
        return helper(s, 0);
    }
    private boolean helper(String s, int start) {
        String cur = s.substring(start, s.length());
        if (mem.containsKey(cur)) {
            return mem.get(cur);
        }

        for (int i = start; i < s.length(); i++) {
            String left = s.substring(start, i + 1);
            String right = s.substring(i + 1, s.length());
            if (mem.containsKey(left) && mem.get(left)) {
                if (!mem.containsKey(right)) {
                    mem.put(right, helper(s, i + 1));
                }
                if (mem.get(right)) {
                    return true;
                } 
            } 
        }
        return false;
    }
    private Map<String, Boolean> buildMem(List<String> wordDict) {
        Map<String, Boolean> mem =  new HashMap<>();
        for (String s: wordDict) {
            mem.put(s, true);
        }
        return mem;
    }
}

// dp
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // dp[i] : if the first s.substring(0, i) can be formed by the word in wordDict
        //  dp[i] = dp[j] && subtring(j, i)
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}