// combine dp
// read the picture of 3d dp
class Solution {
    public int longestLine(int[][] mat) {
        int res = 0;
        int[][][] dp = new int[mat.length][mat[0].length][4];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : mat[i][j]; //horizontal
                dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : mat[i][j]; //vertical
                dp[i][j][2] = i > 0 && j > 0 ? dp[i - 1][j - 1][2] + 1 : mat[i][j];// diagonal
                dp[i][j][3] = i > 0 && j < mat[0].length - 1 ? dp[i - 1][j + 1][3] + 1 : mat[i][j];// anti-diagonal
                res = Math.max(res, Math.max(dp[i][j][0], Math.max(dp[i][j][1], Math.max(dp[i][j][2], dp[i][j][3]))));
            }
        }
        return res;
    }
}
// dp for 4 directions
class Solution {
    public int longestLine(int[][] mat) {
        int res = 0;
        // horizontal
        int[][] hori = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    hori[i][j] = 0;
                } else {
                    if (j == 0) {
                        hori[i][j] = mat[i][j];
                    } else {
                        hori[i][j] = hori[i][j - 1] + 1;
                    }   
                }
                res = Math.max(res, hori[i][j]);
            }
        }
        // vertical
        int[][] verti = new int[mat.length][mat[0].length];
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] == 0) {
                    verti[i][j] = 0;
                } else {
                    if (i == 0) {
                        verti[i][j] = mat[i][j];
                    } else {
                        verti[i][j] = verti[i - 1][j] + 1;
                    }   
                }
                res = Math.max(res, verti[i][j]);
            }
        }
        // diagonal
        int[][] diagonal = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    diagonal[i][j] = 0;
                } else {
                    if (j == 0 || i == 0) {
                        diagonal[i][j] = mat[i][j];
                    } else {
                        diagonal[i][j] = diagonal[i - 1][j - 1] + 1;
                    }   
                }
                res = Math.max(res, diagonal[i][j]);
            }
        }
        // anti- diagonal
        int[][] antiDiagonal = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    antiDiagonal[i][j] = 0;
                } else {
                    if (j == mat[0].length - 1 || i == 0) {
                        antiDiagonal[i][j] = mat[i][j];
                    } else {
                        antiDiagonal[i][j] = antiDiagonal[i - 1][j + 1] + 1;
                    }   
                }
                res = Math.max(res, antiDiagonal[i][j]);
            }
        }
        return res;
    }
}

