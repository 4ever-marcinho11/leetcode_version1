package com.ivan.l_22_09_27.s746;

/**
 * @author Maximilian_Li
 */
public class s746 {
    /**
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * <p>
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     *
     * @param cost 整数数组 cost
     * @return 达到楼梯顶部的最低花费
     */
    public int minCostClimbingStairs(int[] cost) {
        // dp[i]：从第i个楼梯向上爬时的最小消耗
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Integer.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Integer.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
