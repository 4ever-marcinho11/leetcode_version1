package com.ivan.l_22_11_18.s122;

public class s122 {
    /**
     * 在每一天，你可以决定是否购买或出售股票。你在任何时候最多只能持有一股股票。
     * <p>
     * 你也可以先购买，然后在 同一天 出售。
     *
     * @param prices 整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格
     * @return 你能获得的 最大 利润
     */
    public int maxProfit(int[] prices) {
        // 一只股票可以购买卖出多次

        if (prices.length == 0) {
            return 0;
        }

        // [][0]表示持有股票[]；[1]表示不持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 持有：前一天持有，保留；前一天没有，买入
            dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 不持有：前一天持有，卖出；前一天没有，不变
            dp[i][1] = Integer.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }

        return Integer.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
