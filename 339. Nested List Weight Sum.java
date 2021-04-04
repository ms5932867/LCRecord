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

//dfs

// class Solution {
//     public int depthSum(List<NestedInteger> nestedList) {
//         return helper(nestedList, 1);
//     }
//     private int helper(List<NestedInteger> nestedList, int depth) {
//         int curSum = 0;
//         for (NestedInteger ni : nestedList) {
//             if (ni.isInteger()) {
//                 curSum += depth * ni.getInteger();
//             }
//             else {
//                 curSum += helper(ni.getList(), depth + 1);
//             }
//         }
//         return curSum;
//     }
// }

//bfs

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();
        int depth = 1;
        for (NestedInteger ni : nestedList) {
            q.offer(ni);
        }
        int sum = 0;
        while (!q.isEmpty()) {
            for (int s = q.size(); s > 0; s--) {
                NestedInteger curNi = q.poll();
                if (curNi.isInteger()) {
                    sum += curNi.getInteger() * depth;
                } else {
                    for (NestedInteger ni : curNi.getList()) {
                        q.offer(ni);
                    }
                }
            }
            depth++;
        }
        return sum;
    }
}

