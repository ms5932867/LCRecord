/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public class Pair {
        int num;
        int depth;
        Pair (int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
    List<Pair> pairList =  new ArrayList<>();
    int maxDepth = 1;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        dfs(nestedList, 1);
        return calculateRes(pairList, maxDepth);
    }
    private void dfs(List<NestedInteger> nestedList, int curDepth) {

        if (nestedList == null || nestedList.size() == 0) {
            return;
        } 
        maxDepth = Math.max(maxDepth, curDepth);
        int curSum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                curSum += ni.getInteger();
            } else {
                dfs(ni.getList(), curDepth + 1);
            }
        }
        pairList.add(new Pair(curSum, curDepth));
    }
    private int calculateRes(List<Pair> pairList ,int maxDepth ) {
        int sum = 0;
        for (Pair p : pairList) {
            sum += (p.num * (maxDepth - p.depth + 1));
        }
        return sum;
    }
}