package com.ivan.l_22_09_12.s53;

import java.util.Arrays;

/**
 * @author Maximilian_Li
 */
public class s53 {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组 是数组中的一个连续部分。
     *
     * @param nums 数组
     * @return 最大子数组和
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.max(nums[i], nums[i] + dp[i - 1]);
        }

        int res = Integer.MIN_VALUE;
        for (int i : dp) {
            if (res < i) {
                res = i;
            }
        }
        return res;
    }
}
