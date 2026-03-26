
/**
 * 739. Daily Temperatures
 * Given an array of integers temperatures represents the daily temperatures, 
 * return an array answer such that answer[i] is the number of days 
 * you have to wait after the ith day to get a warmer temperature. 
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.           
 * Input: temperatures = [30,38,30,36,35,40,28]
 * Output: [1,4,1,2,1,0,0]
 * Input: temperatures = [22,21,20]
 * Output: [0,0,0]
*/
// Solution 1: monotonic stack Time O(n) Space O(n) 
/**
我们想找每一天右边第一个比它大的数。
这其实就是一个典型的：
Next Greater Element（下一个更大元素）
所以可以用 单调递减栈。
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>(); //decreased temperature index
        for (int i = 0; i < temperatures.length; i++) {
            while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int lastIdx = stk.pop();
                res[lastIdx] = i - lastIdx;      
            }
            stk.push(i);
        }
        return res;
    }
}
// Solution 2: DP Time O(n) Space O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] dp = new int[temperatures.length];
        dp[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i>= 0; i--) {
            int j = i + 1;
            while (true) {
                if (temperatures[i] < temperatures[j]) {
                    dp[i] = j - i;
                    break;
                }
                else if (dp[j] == 0) {
                    dp[i] = 0;
                    break;
                } else {
                    j += dp[j];
                }
            }
        }
        return dp;
    }
}
/**
从右往左，用已经算好的答案 dp[j] 来“跳”，避免一个个往右扫。
🧠 三步思路（必须记住）
对每个 i，从 j = i+1 开始：
1️⃣ 能用就用
temperatures[j] > temperatures[i]
→ 答案就是 j - i
2️⃣ 彻底没戏
dp[j] == 0
→ 后面没有更大的 → dp[i] = 0
3️⃣ 否则就跳
j = j + dp[j]
*/
