package com.ivan.l_22_11_11.s474;

public class s474 {
    /**
     * 给你一个 strs 和两个整数 m 和 n
     * <p>
     * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1
     * <p>
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集
     *
     * @param strs 二进制字符串数组
     * @param m    整数
     * @param n    另一个整数
     * @return strs的最大子集的长度
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]: 表示i个0和j个1时的最大子集(一维升为二维)
        int[][] dp = new int[m + 1][n + 1];
        int o, z;

        for (String str : strs) {
            // 计算01数目
            o = 0;
            z = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    z++;
                } else {
                    o++;
                }
            }

            // loop
            for (int i = m; i >= z; i--) {
                for (int j = n; j >= o; j--) {
                    // 要么自成一派，要么跟前面
                    dp[i][j] = Integer.max(dp[i][j], dp[i - z][j - o] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
