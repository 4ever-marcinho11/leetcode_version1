package com.ivan.l_22_11_18.s188;

public class s188 {
    /**
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @param k      多可以完成 k 笔交易
     * @param prices 整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格
     * @return 你所能获取的最大利润
     */
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Integer.max(dp[i - 1][j] - prices[i], dp[i - 1][j + 1]);
                dp[i][j + 2] = Integer.max(dp[i - 1][j + 1] + prices[i], dp[i - 1][j + 2]);
            }
        }

        return dp[prices.length - 1][2 * k];
    }
}
