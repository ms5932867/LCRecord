// two pointers Time O(n) Space O(1)
/**
The height is limited by the shorter line, so to potentially increase the area, we must move the pointer at the shorter line inward.
Moving the taller line never helps because it keeps the height the same but reduces the width.
By always moving the shorter side, we explore all meaningful possibilities.
*/
class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;
        while (l < r) {
            int cur = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, cur);
            if (heights[l] < heights[r] ) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
/**
 * You are given an integer array heights where heights[i] represents the height of the 
i th bar.

You may choose any two bars to form a container. Return the maximum amount of water a container can store.

Example 1:



Input: height = [1,7,2,5,4,7,3,6]

Output: 36
Example 2:

Input: height = [2,2,2]

Output: 4
 */