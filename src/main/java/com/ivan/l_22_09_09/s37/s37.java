package com.ivan.l_22_09_09.s37;

public class s37 {
    /**
     * 编写一个程序，通过填充空格来解决数独问题。
     * <p>
     * 数独的解法需 遵循如下规则：
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * <p>
     * 数字 1-9 在每一列只能出现一次。
     * <p>
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * <p>
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     *
     * @param board 棋盘
     */
    public void solveSudoku(char[][] board) {
        bt(board);
    }

    public boolean bt(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    // 只考虑空白区域
                    for (char c = '1'; c <= '9'; c++) {
                        if (canSet(row, col, c, board)) {
                            // 回溯
                            board[row][col] = c;
                            if (bt(board)) {
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    // 能到这里就代表就九个数字都不能放置
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canSet(int row, int col, char ch, char[][] board) {
        // 同行
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == ch) {
                return false;
            }
        }

        // 同列
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == ch) {
                return false;
            }
        }

        // 九宫格
        int r = row / 3 * 3;
        int c = col / 3 * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }
}
