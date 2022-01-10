class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        boolean isA = true;
        
        for (int[] pos : moves) {
            if (isA) {
                board[pos[0]][pos[1]] = 'A';
            } else {
                board[pos[0]][pos[1]] = 'B';
            }
            isA = !isA;
        }
        if (helper(board, 'A')) {
            return "A";
        }
         if (helper(board, 'B')) {
            return "B";
        }
        if (moves.length < 9) {
            return "Pending";
        }
        return "Draw";
        
    }
    private boolean helper(char[][] board, char c) {
       
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == c && board[1][j] == c && board[2][j] == c) {
                return true;
            }
        }
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
            return true;
        }
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) {
            return true;
        }
        return false;
    }
}