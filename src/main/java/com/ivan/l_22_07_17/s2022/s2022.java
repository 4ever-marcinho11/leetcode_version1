package com.ivan.l_22_07_17.s2022;

public class s2022 {
    /**
     * @param original 原一维数组
     * @param m        m行
     * @param n        n列
     * @return 新二维数组
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length > m * n) {
            // 返回形式为：[]
            return new int[][]{};
        }

        // 构建
        int[][] arr2D = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (0 <= i * n + j && i * n + j <= original.length - 1) {
                    arr2D[i][j] = original[i * n + j];
                } else {
                    // 返回形式为：[]
                    return new int[][]{};
                }

            }
        }

        return arr2D;
    }
}
