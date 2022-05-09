/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int s = 0;
        int e = r * c - 1;
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            int val = getVal(matrix, c, m);
            if(val == target) {
                return true;
            } else if (val < target) {
                s = m + 1; 
            } else {
                e = m - 1;
            }
        }
        if (getVal(matrix, c, s) == target || getVal(matrix, c, e) == target) {
            return true;
        }
        return false;
    }
    private int getVal(int[][] matrix, int c, int index) {
        return matrix[index / c][index % c];
    }
}