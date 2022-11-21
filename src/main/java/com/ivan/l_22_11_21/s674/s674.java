package com.ivan.l_22_11_21.s674;

import java.util.Arrays;

public class s674 {
    /**
     * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定
     * <p>
     * 如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1]
     * <p>
     * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
     *
     * @param nums 未经排序的整数数组
     * @return 找到最长且 连续递增的子序列，并返回该序列的长度
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }

            if (dp[i] > result) {
                result = dp[i];
            }
        }

        return result;
    }
}
