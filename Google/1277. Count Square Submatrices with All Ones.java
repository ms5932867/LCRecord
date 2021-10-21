// https://www.youtube.com/watch?v=P5Fw7oD8VR0
// https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/441306/JavaC++Python-DP-solution
/**
 * dp[i][j] means the size of biggest square with A[i][j] as bottom-right corner.
dp[i][j] also means the number of squares with A[i][j] as bottom-right corner.

If A[i][j] == 0, no possible square.
If A[i][j] == 1,
we compare the size of square dp[i-1][j-1], dp[i-1][j] and dp[i][j-1].
min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1 is the maximum size of square that we can find.


Complexity
Time O(MN)
Space O(1)
 */
class Solution {
    public int countSquares(int[][] matrix) {
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    cnt++;
                }
                else  { //(i > 0 && j > 0)
                    matrix[i][j] +=  Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
                    cnt += matrix[i][j];
                } 
            }
        }
        return cnt;
    }
}