// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 0 <= n <= 3 * 10^4
// 0 <= height[i] <= 10^5

// array for leftMax and rightMax
class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int left = 0;
        for (int i = 0 ; i < height.length; i++) {
            left = Math.max(left, height[i]);
            leftMax[i] = left;

        }

        int right = 0;
        for (int i = height.length - 1 ; i >= 0; i--) {
            right = Math.max(right, height[i]);
            rightMax[i] = right;
            
        }

        int res = 0;
        for (int i = 1 ; i< height.length - 1; i++) {

            res += Math.min(leftMax[i], rightMax[i]) - height[i];

        }
        return res;
    }
}

// two pointer
class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while ( i <= j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            
            if (height[i] >= height[j]) {
                res += Math.min(leftMax, rightMax) - height[j];
                j--;
            }
            else {
                res += Math.min(leftMax, rightMax) - height[i];
                i++;
            }
        }
        return res;
    }
}