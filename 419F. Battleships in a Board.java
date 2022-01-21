//这道题让求战舰的个数，所谓的战舰就是只能是一行或者一列，不能有拐弯。
//这道题降低了难度的做法是限定了不会有相邻的两个战舰的存在，有了这一点限制，那么只需要遍历一次二维数组就行了，
// 只要找出战舰的起始点。所谓的战舰起始点，就是为X的点，而且该点的上方和左边的点不能为X，所以只要找出所有满足这个条件的点即可

class Solution {
    public int countBattleships(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if ((i > 0 && board[i -1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X')) {
                    continue;
                }
                cnt++;
            }
        }
        return cnt;
    }
}