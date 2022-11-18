package com.ivan.l_22_11_18.s123;

public class s123 {
    /**
     * 设计一个算法来计算。你最多可以完成两笔交易。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @param prices 个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格
     * @return 你所能获取的最大利润
     */
    public int maxProfit(int[] prices) {
        // 至多买卖两次，这意味着可以买卖一次，可以买卖两次，也可以不买卖

        /*
        一天一共就有五个状态，
        0: 没有操作
        1: 第一次买入
        2: 第一次卖出
        3: 第二次买入
        4: 第二次卖出
        dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，dp[i][j]表示第i天状态j所剩最大现金。
         */
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            // 第一次考虑持有：新买入；延续
            dp[i][1] = Integer.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            // 第一次考虑不持有：新卖出；延续
            dp[i][2] = Integer.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            // 第二次考虑持有：第二次新买入；延续
            dp[i][3] = Integer.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            // 第二次考虑不持有：第二次新卖出；延续
            dp[i][4] = Integer.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }

        return dp[prices.length - 1][4];
    }
}
