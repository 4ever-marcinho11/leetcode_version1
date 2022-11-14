package com.ivan.l_22_11_14.s279;

import java.util.Arrays;

public class s279 {
    /**
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
     * <p>
     * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     *
     * @param n 整数
     * @return 和为 n的完全平方数的最少数量
     */
    public int numSquares(int n) {
        // declare
        int[] dp = new int[n + 1];

        // init
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // loop
        for (int i = 1; i * i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - i * i >= 0) {
                    dp[j] = Integer.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n];
    }
}
