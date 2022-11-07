package com.ivan.l_22_11_07.s343;

/**
 * @author Maximilian_Li
 */
public class s343 {
    /**
     * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
     *
     * @param n 正整数
     * @return 你可以获得的最大乘积
     */
    public int integerBreak(int n) {
        // dp[i]: 拆分数字i得到的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Integer.max(dp[i], Integer.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
