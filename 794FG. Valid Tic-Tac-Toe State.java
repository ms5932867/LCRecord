// https://www.cnblogs.com/grandyang/p/9223105.html
class Solution {
    public boolean validTicTacToe(String[] board) {
        int cntDif = 0; // dif of x -o
        for (String row : board) { 
            for (char c: row.toCharArray()) {
                if (c == 'X') {
                    cntDif++;
                } else if (c == 'O') {
                    cntDif--;
                }
            }
        }
        if (cntDif != 0 && cntDif != 1) {
            return false;
        }
        
        boolean Xwin = check(board, 'X');
        boolean Owin = check(board, 'O');
        
        if ((cntDif == 1 && Xwin && !Owin ) || (cntDif == 0 && !Xwin && Owin) || (!Xwin && !Owin)) {
            return true;
        }
        return false; 
            
    }
    private boolean check(String[] board, char c) {
        String winRow = "" + c + c + c;
        for (String row : board) {
            if (row.equals(winRow)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == c &&board[1].charAt(i) ==c && board[2].charAt(i) == c ) {
                return true;
            }
        }
        if (board[0].charAt(0) == c &&board[1].charAt(1) ==c && board[2].charAt(2) == c ) {
            return true;
        } 
        if (board[0].charAt(2) == c &&board[1].charAt(1) ==c && board[2].charAt(0) == c ) {
            return true;
        }
        
        return false;
    }        
            
}