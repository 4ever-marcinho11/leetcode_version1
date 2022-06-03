package com.ivan.l_22_06_03.s322;

import java.util.Arrays;

public class s322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示当钱数为i元时，需要的最少硬币个数
        int[] dp = new int[amount + 1];

        // 初始状态
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // 状态+选择
        for (int i = 1; i <= amount; i++) {
            for (int val : coins) {
                // 如果当前金额不足以使用当前币值支付，跳过此次循环
                if (i - val < 0) {
                    continue;
                }
                // 使用动态规划的方式得到最少硬币数
                dp[i] = Math.min(dp[i], 1 + dp[i - val]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
