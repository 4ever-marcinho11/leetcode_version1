package com.ivan.l_22_09_12.s122;

/**
 * @author Maximilian_Li
 */
public class s122 {
    /**
     * 给你一个整数数组prices，其中prices[i]表示某支股票第i天的价格。
     * <p>
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * <p>
     * 返回 你能获得的 最大 利润。
     *
     * @param prices 股票每天的价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[] profits = new int[size - 1];

        for (int i = 0; i < size - 1; i++) {
            profits[i] = prices[i + 1] - prices[i];
        }

        int res = 0;
        for (int i : profits) {
            if (i > 0) {
                res += i;
            }
        }

        return res;
    }
}
