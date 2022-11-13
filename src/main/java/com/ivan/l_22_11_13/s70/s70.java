package com.ivan.l_22_11_13.s70;

public class s70 {
    public int climbStairs(int n) {
        // 此题 bagsize = n， nums = {1, 2}

        int[] nums = new int[]{1, 2};
        int bagsize = n;

        int[] dp = new int[n + 1];
        dp[0] = 1;

        // 完全背包 + 组合
        for (int j = 0; j <= bagsize; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }

        return dp[bagsize];
    }
}
