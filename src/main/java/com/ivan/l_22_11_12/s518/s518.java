package com.ivan.l_22_11_12.s518;

/**
 * @author Maximilian_Li
 */
public class s518 {
    /**
     * 假设每一种面额的硬币有无限个
     * <p>
     * 题目数据保证结果符合 32 位带符号整数
     *
     * @param amount 整数 amount 表示总金额
     * @param coins  整数数组 coins 表示不同面额的硬币
     * @return 返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     */
    public int change(int amount, int[] coins) {
        // declare
        int[] dp = new int[amount + 1];

        // init
        dp[0] = 1;

        // loop
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 求装满背包有几种方法，一般公式都是：dp[j] += dp[j - nums[i]]
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
