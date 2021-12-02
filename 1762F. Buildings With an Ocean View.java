// Soultion 1 no stack
class Solution {
    public int[] findBuildings(int[] heights) {
        int lastHeight = -1;
        List<Integer> ans = new ArrayList<>();
        for (int i = heights.length -1; i >= 0; i--) {
            if (heights[i] > lastHeight) {
                ans.add(i);
                lastHeight = heights[i];
            }
        }
        int indexAns = ans.size() - 1;
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(indexAns);
            indexAns--;
        }
        return res;
    }
}


// Soultion 2 use  stack
class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> canSee = new Stack<>();
        for (int i = heights.length -1; i >= 0; i--) {
            if (canSee.isEmpty() || heights[i] > heights[canSee.peek()]) {
                canSee.push(i);
            }
        }
        int[] res = new int[canSee.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = canSee.pop();
        }
        return res;
    }
}