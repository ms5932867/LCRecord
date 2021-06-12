//https://www.cnblogs.com/grandyang/p/8097513.html
/**
 * 实际上这道题应该使用递减栈Descending Stack来做，栈里只有递减元素，思路是这样的，
 * 我们遍历数组，如果栈不空，且当前数字大于栈顶元素，那么如果直接入栈的话就不是递减栈了，所以我们取出栈顶元素，
 * 那么由于当前数字大于栈顶元素的数字，而且一定是第一个大于栈顶元素的数，那么我们直接求出下标差就是二者的距离了，
 * 然后继续看新的栈顶元素，直到当前数字小于等于栈顶元素停止，然后将数字入栈，
 * 这样就可以一直保持递减栈，且每个数字和第一个大于它的数的距离也可以算出来了
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                ans[stk.peek()] = i - stk.peek();
                stk.pop();
            }
            stk.push(i);
        }
        

        return ans;
    }
    
}