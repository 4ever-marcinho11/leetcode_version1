package com.ivan.l_22_11_14.s322;

import java.util.Arrays;

/**
 * @author Maximilian_Li
 */
public class s322 {
    /**
     * 如果没有任何一种硬币组合能组成总金额，返回-1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     *
     * @param coins  整数数组 coins ，表示不同面额的硬币
     * @param amount 整数 amount ，表示总金额
     * @return 可以凑成总金额所需的 最少的硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        // declare
        int[] dp = new int[amount + 1];

        // init
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // loop
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Integer.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
