package com.ivan.l_22_09_23.s714;

/**
 * @author Maximilian_Li
 */
public class s714 {
    /**
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
     * 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * <p>
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * @param prices 整数数组prices，其中 prices[i]表示第i天的股票价格
     * @param fee    整数fee 代表了交易股票的手续费用
     * @return 获得利润的最大值
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Integer.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[len - 1][0];
    }
}
