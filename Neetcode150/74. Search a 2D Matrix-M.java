/**
74. Search a 2D Matrix
You are given an m x n 2-D integer array matrix and an integer target.

Each row in matrix is sorted in non-decreasing order.
The first integer of every row is greater than the last integer of the previous row.
Return true if target exists within matrix or false otherwise.

Can you write a solution that runs in O(log(m * n)) time?

 */
// time: O(log(m * n)) space: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        while (l <= r) {
            int m =  l + (r - l) / 2;
            int row =  m / matrix[0].length;
            int col = m % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
// time: O(m + n) space: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = 0;
        int row = matrix.length - 1;
        while (col < matrix[0].length && row >= 0) {
           if (matrix[row][col] == target) {
            return true;
           } else if (matrix[row][col] > target) {
            row--;
           } else {
            col++;
           }
        }
        return false;
    }
}


