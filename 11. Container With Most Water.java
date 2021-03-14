class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i <= j) {
            int curRes = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, curRes);
            if (height[i] > height[j]) {
                j--;
            }
            else {
                i++;
            }
        }
        return res;
    }
}

// I found a lot of the discussion and proof about this quite opaque, but one thing helped it finally clicked for me (which is sort of proof by contradiction i guess)

// You have two heights H_left and H_right, and H_right < H_left, then we know we have two choices, we want to move one of them. If we move the larger one, we cannot increase the height for the simple reason that we are always limited by the shortest, and we would be decreasing j-i, the width as well.

// To clarify: let's say we kept the shortest forever, what would happen? Well, j-i would decrease, and either we come across a taller block, which doesn't matter because our shorter one we kept only mattered, or we find a shorter one, in which case that one matters.

// Either way we end up with a smaller area, so we must move the shorter one because moving the larger one cannot give an increase in area