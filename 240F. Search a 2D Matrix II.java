// Solution 1: Time O(m + n), Space O(1)
/**
 * 是之前那道 Search a 2D Matrix 的延伸，
 * 那道题的不同在于每行的第一个数字比上一行的最后一个数字大，是一个整体蛇形递增的数组。
 * 所以那道题可以将二维数组展开成一个一位数组用一次二查搜索。而这道题没法那么做，
 * 这道题有它自己的特点。如果我们观察题目中给的那个例子，可以发现有两个位置的数字很有特点，
 * 左下角和右上角的数。
 * 左下角的 18，往上所有的数变小，往右所有数增加，那么就可以和目标数相比较，
 * 如果目标数大，就往右搜，如果目标数小，就往上搜。
 * 这样就可以判断目标数是否存在。当然也可以把起始数放在右上角，往左和下搜，停止条件设置正确就行。
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } 
            if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
// Solution 2: