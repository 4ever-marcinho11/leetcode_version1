package com.ivan.l_22_11_17.s121;

public class s121 {
    /**
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * @param prices 它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
     * @return 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     */
    public int maxProfit(int[] prices) {
        // 一只股票只能有一次购买卖出操作

        if (prices.length == 0) {
            return 0;
        }

        // dp[i][0]表示考虑买入，dp[i][1]表示不考虑买入
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 考虑买入：上一周已经买入，这周就不用买入了；上一周未买入，这周要花费prices[i]
            dp[i][0] = Integer.max(dp[i - 1][0], -prices[i]);
            // 不考虑买入：上一周已经不考虑，这周就也不考虑；上一周买入，这周要收获prices[i]
            dp[i][1] = Integer.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return Integer.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
