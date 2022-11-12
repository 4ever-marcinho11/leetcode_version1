package com.ivan.l_22_11_08.knapsack01.l_22_11_09.s416;

import java.util.Arrays;

public class s416 {
    /**
     * @param nums 只包含正整数 的 非空 数组
     * @return 否可以将这个数组分割成两个子集，使得两个子集的元素和相等
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int bagsize = sum / 2;

        // dp
        int[][] dp = new int[nums.length][bagsize + 1];

        // init
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = nums[0]; i <= bagsize; i++) {
            dp[0][i] = nums[0];
        }

        // loop
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }

        return dp[nums.length - 1][bagsize] == bagsize;
    }
}
