package com.ivan.l_22_11_16.s198;

public class s198 {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金
     * <p>
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统
     * <p>
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * @param nums 代表每个房屋存放金额的非负整数数组
     * @return 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i]表示考虑从头开始到第i家能打劫的最多金额
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
