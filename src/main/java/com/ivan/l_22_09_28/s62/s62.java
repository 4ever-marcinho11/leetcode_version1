package com.ivan.l_22_09_28.s62;

/**
 * @author Maximilian_Li
 */
public class s62 {
    /**
     * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * <p>
     * 问总共有多少条不同的路径？
     *
     * @param m 行数
     * @param n 列数
     * @return 路径数
     */
    public int uniquePaths(int m, int n) {
        // dp[i][j]代表从起点开始到这个格子的路径总数
        int[][] dp = new int[m][n];

        // 起点一列到起点的路径为一
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // 起点一行到起点的路径为一
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 一个格子只取决于上面的与右面的各自的路径数
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
