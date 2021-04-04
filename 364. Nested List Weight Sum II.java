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
    public class Item {
        int val;
        int depth;
        Item (int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }
    int maxDepth = 1;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Item> items = new ArrayList<>();
        
        dfs(nestedList, items, 1);
        return calculate(items);
    }
    private void dfs (List<NestedInteger> nestedList, List<Item> items, int curDepth) {
        maxDepth = Math.max(maxDepth, curDepth);
        int allInt = 0;

        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                allInt += ni.getInteger();
            } else {
                dfs(ni.getList(), items, curDepth + 1);
            }
        }
        items.add(new Item(allInt, curDepth));   
    }

    private int calculate(List<Item> items){
        int sum = 0;
        for (Item i : items) {
            sum += i.val * (maxDepth - i.depth + 1);
        }
        return sum;
    }
}