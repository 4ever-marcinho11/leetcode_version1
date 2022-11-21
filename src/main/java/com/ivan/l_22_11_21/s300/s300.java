package com.ivan.l_22_11_21.s300;

import java.util.Arrays;

public class s300 {
    /**
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
     * <p>
     * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     * @param nums 整数数组 nums
     * @return 找到其中最长严格递增子序列的长度
     */
    public int dp(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > res) {
                res = dp[i];
            }
        }

        return res;
    }
}
