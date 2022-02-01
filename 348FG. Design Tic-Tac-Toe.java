// Follow up中让我们用更高效的方法，那么根据提示中的，我们建立一个大小为n的一维数组rows和cols，
// 还有变量对角线diag和逆对角线rev_diag，这种方法的思路是，如果玩家1在第一行某一列放了一个子，那么rows[0]自增1，
// 如果玩家2在第一行某一列放了一个子，则rows[0]自减1，那么只有当rows[0]等于n或者-n的时候，
// 表示第一行的子都是一个玩家放的，则游戏结束返回该玩家即可，
// 其他各行各列，对角线和逆对角线都是这种思路

class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal = 0;;
    int antiDiagonal = 0;
    int n;
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        
    }
    
    public int move(int row, int col, int player) {
        int val = (player == 1)? 1 : -1;
        rows[row] += val;
        cols[col] += val;
        if (row == col) {
                diagonal += val;
        }
        if (row + col == n - 1) {
            antiDiagonal += val;
        }
        if (rows[row] == n * val || cols[col] == n * val || diagonal == n * val || antiDiagonal == n * val) {
            return player;
        }  
        return 0;
        
    }    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */