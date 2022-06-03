package com.ivan.l_22_06_03.s53;

import java.util.Arrays;

public class s53 {
    public int maxSubArray(int[] nums) {
        // 子数组：连续
        // dp：dp[i]代表以第i个元素为结尾的最大子数组和为dp[i]
        int[] dp = new int[nums.length];

        // base case
        Arrays.fill(dp, 1);
        if (nums.length == 0) {
            return 0;
        } else {
            dp[0] = nums[0];
        }

        // cases and choices
        for (int i = 1; i < nums.length; i++) {
            // 自成一派 or 前一个结合
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int j : dp) {
            if (j > res) {
                res = j;
            }
        }

        return res;
    }
}
