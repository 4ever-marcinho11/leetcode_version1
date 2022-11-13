package com.ivan.l_22_11_13.s377;

/**
 * @author Maximilian_Li
 */
public class s377 {
    /**
     * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     *
     * @param nums   不同 整数组成的数组
     * @param target 一个目标整数 target
     * @return 总和为 target 的元素组合的个数
     */
    public int combinationSum4(int[] nums, int target) {
        // declare
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // loop
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }
}
