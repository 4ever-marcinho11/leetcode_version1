package com.ivan.l_22_11_09.s1049;

import java.util.Arrays;

/**
 * @author Maximilian_Li
 */
public class s1049 {
    /**
     * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x和y，且x<=y。那么粉碎的可能结果如下：
     * <p>
     * 如果x == y，那么两块石头都会被完全粉碎；
     * <p>
     * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
     *
     * @param stones 一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
     * @return 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int bagsize = sum / 2;

        // declare
        int[][] dp = new int[stones.length][bagsize + 1];

        // init
        for (int i = 0; i < stones.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = stones[0]; i <= bagsize; i++) {
            dp[0][i] = stones[0];
        }

        // loop
        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }

        return sum - dp[stones.length - 1][bagsize] - dp[stones.length - 1][bagsize];
    }

    public int lastStoneWeightII_id_arr(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int bagsize = sum / 2;

        // declare
        int[] dp = new int[bagsize + 1];

        // init
        for (int i = stones[0]; i <= bagsize; i++) {
            dp[i] = stones[0];
        }

        // loop
        for (int i = 1; i < stones.length; i++) {
            for (int j = bagsize; j >= stones[i]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - dp[bagsize] - dp[bagsize];
    }
}
