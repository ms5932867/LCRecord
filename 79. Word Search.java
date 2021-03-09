class Solution {
    class Pos {
        int m;
        int n;
        Pos (int m, int n) {
            this.m = m;
            this.n = n;
        }
    }
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        int startC = word.charAt(0);
       
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == startC) {
                    dfs(board, visited, word, pos, 0);
                    if (res) {  
                        return res;
                    }

                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, boolean[][] visited, String word, Pos pos, int index) {
        if (index == word.length()) {
            res = true;
            return;
        }
        if (!validate(board, visited, pos ) || board[pos.m][pos.n] != word.charAt(index)) {
            return;
        }
        
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        visited[pos.m][pos.n] = true;
        for (int d = 0; d < 4; d++) {
            dfs(board, visited, word, new Pos(pos.m + rowOffsets[d], pos.n + colOffsets[d]), index + 1);
            if (res) {
                return;
            }
        } 
        visited[pos.m][pos.n] = false;    
    }
    private boolean validate(char[][] board, boolean[][] visited,Pos pos ) {
        if (pos.m < 0 || pos.m >= board.length || pos.n < 0 || pos.n >= board[0].length || visited[pos.m][pos.n] == true ) {
            return false;
        }
        return true;
    }
}