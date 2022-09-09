package com.ivan.l_22_09_09.s51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s51 {
    List<List<String>> res = new ArrayList<>();

    /**
     * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     * <p>
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     * <p>
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] cs : board) {
            Arrays.fill(cs, '.');
        }
        bt(n, 0, board);
        return res;
    }

    public void bt(int n, int row, char[][] board) {
        if (row == n) {
            res.add(changeState(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlace(row, col, board)) {
                board[row][col] = 'Q';
                bt(n, row + 1, board);
                board[row][col] = '.';
            }
        }
    }

    /**
     * 判断是否可以在坐标（rowIdx，colIdx）放置棋子
     *
     * @param rowIdx 横坐标，从左至右
     * @param colIdx 纵坐标，从上至下
     * @return boolean
     */
    public boolean canPlace(int rowIdx, int colIdx, char[][] board) {
        int n = board.length;

        // 同列不能有棋子
        for (int row = 0; row < rowIdx; row++) {
            if (board[row][colIdx] == 'Q') {
                return false;
            }
        }

        // 左上右下不能有棋子
        for (int i = rowIdx - 1, j = colIdx - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 左下右上不能有棋子
        for (int i = rowIdx - 1, j = colIdx + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> changeState(char[][] matrix) {
        List<String> board = new ArrayList<>();
        for (char[] cs : matrix) {
            board.add(String.valueOf(cs));
        }

        return board;
    }
}
