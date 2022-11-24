package com.ivan.l_22_11_24.s53;

import java.util.Arrays;

public class s53 {
    /**
     * 请你找出一个具有最大和的连续子数组（子数组最少包含一个元素）
     * <p>
     * 子数组 是数组中的一个连续部分
     *
     * @param nums 整数数组 nums
     * @return 返回其最大和
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // dp[i]表示包括下标i之前的最大连续子序列和为dp[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i - 1] + nums[i], nums[i]);
        }

        return Arrays.stream(dp).max().getAsInt();

    }
}
